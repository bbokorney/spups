package model.board;

import model.GameModel;
import model.Pair;
import model.player.Developer;
import model.player.JavaPlayer;
import model.rules.developer.DeveloperPlacementRule;
import model.rules.palace.HighestRankingPlayerRule;
import model.rules.palace.PalaceLevelCitySizeRule;
import model.tiles.PalaceTileComponent;

import java.util.*;

/**
 * Created by Baker on 4/14/2014.
 */
public class BoardRuleHelper {
    private GameModel model;

    public BoardRuleHelper(GameModel model) {
        this.model = model;
    }

    public Map<JavaPlayer, Integer> getPlayerRanksIn(Collection<Location> locations) {
        final Map<JavaPlayer, Map<Integer, Integer>> heightMap = new HashMap<JavaPlayer, Map<Integer, Integer>>();
        int maxHeight = 0;
        JavaPlayer[] players = model.getJavaPlayers().toArray(new JavaPlayer[model.getJavaPlayers().size()]);
        for(int i = 0; i < players.length; ++i) {
            Map<Integer, Integer> heights = new HashMap<Integer, Integer>();
            for(Developer d : players[i].getDevelopers()) {
                if(locations.contains(d.getLocation())) {
                    int height = model.getBoard().getSpace(d.getLocation()).getHeight();
                    maxHeight = Math.max(maxHeight, height);
                    createOrIncrement(heights, height);
                }
            }
            if(heights.keySet().size() > 0) {
                heightMap.put(players[i], heights);
            }
        }

        return calcRanks(heightMap.keySet().toArray(new JavaPlayer[0]), heightMap, maxHeight);
    }

    private Map<JavaPlayer, Integer> calcRanks(JavaPlayer[] players, Map<JavaPlayer,
            Map<Integer, Integer>> heightMap, int currHeight) {

        System.out.println(Arrays.toString(players));

        Map<JavaPlayer, Integer> myRanks = new HashMap<JavaPlayer, Integer>();
        // if this is the only player, they're first by default
        if(players.length == 1) {
            myRanks.put(players[0], 1);
            return myRanks;
        }

        // if we've gone through every height, everyone is tied
        if(currHeight < 0) {
            for(JavaPlayer p : players) {
                myRanks.put(p, 1);
            }
            return myRanks;
        }
        else{
            System.out.println("BRH calcRanks currHeight>=0 " + currHeight);
        }

        if(heightMap != null) {
            for (JavaPlayer p : heightMap.keySet()) {
                if (!heightMap.get(p).containsKey(currHeight)) {
                    heightMap.get(p).put(currHeight, 0);
                }
            }
        }
        else{
            System.out.println("BRH calcRanks height map was null");
        }

        // sort the players descending by the number of developers they have at this height.
        sortPlayersCountAtHeight(players, heightMap, currHeight);

        int rankOffset = 0;
        int start = 0;
        int end = start+1;
        while(start < players.length) {
            while(end < players.length) {
                // if this player is tied with the current highest ranked
                // unresolved player
                if(heightMap.get(players[start]).get(currHeight)
                        .equals(heightMap.get(players[end]).get(currHeight))) {
                    // include them in the list of tied players
                    ++end;
                }
                else {
                    break;
                }
            }
            // resolve this tie at the next height down
            Map<JavaPlayer, Integer> ranks = calcRanks(Arrays.copyOfRange(players, start, end),
                    heightMap, currHeight-1);
            // increment each of the ranks
            int maxRank = 0;
            for(JavaPlayer p : ranks.keySet()) {
                myRanks.put(p, ranks.get(p) + rankOffset);
                maxRank = Math.max(maxRank, myRanks.get(p));
            }
            rankOffset = maxRank;
            start = end;
            end++;
        }
        return myRanks;
    }

    private void createOrIncrement(Map<Integer, Integer> map, Integer key) {
        int value = 1;
        if(map.containsKey(key)) {
            value += map.get(key);
        }
        map.put(key, value);
    }

    private void sortPlayersCountAtHeight(JavaPlayer[] players, final Map<JavaPlayer, Map<Integer, Integer>> heightMap,
                                     final int currentHeight) {
        Arrays.sort(players, new Comparator<JavaPlayer>() {
            public int compare(JavaPlayer p1, JavaPlayer p2) {
                int p1Count = heightMap.get(p1).containsKey(currentHeight) ? heightMap.get(p1).get(currentHeight) : 0;
                int p2Count = heightMap.get(p2).containsKey(currentHeight) ? heightMap.get(p2).get(currentHeight) : 0;
                return p1Count > p2Count ? -1 : 1;
            }
        });
    }


    public Collection<Location> getSurroundingTiles(Collection<Location> waterLocations) {
        Set<Location> surroundingLocations = new HashSet<Location>();
        for(Location location : waterLocations) {
            for(Location neighbor : location.getNeighbors()) {
                surroundingLocations.add(neighbor);
            }
        }
        return surroundingLocations;
    }

    public HashMap<JavaPlayer, Integer> pointsEarnedFromIrrigationPlacement(Location location) {
        for(BodyOfWater body : model.getBoard().getBodyOfWaterContainer().getBodiesOfWater()) {
            for(Location water : body.getLocations()) {
                if(neighbors(water, location)) {
                    ArrayList<Location> newBody = new ArrayList<Location>();
                    newBody.add(location);
                    newBody.addAll(body.getLocations());
                    int enclosingTileCount = 0;
                    Collection<Location> surrounding = getSurroundingTiles(newBody);
                    for(Location enclosingLocation : surrounding) {
                        if(model.getBoard().getSpace(enclosingLocation).getHeight() > 0) {
                            ++enclosingTileCount;
                        }
                    }
                    if(enclosingTileCount == surrounding.size()) {
                        //return 1;
                        //todo return noll baker
                        return new HashMap<JavaPlayer, Integer>();
                    }
                }
            }
        }
        return new HashMap<JavaPlayer, Integer>();
        // return 0; todo baker

        /*
        this will only ever return one player
        this will be called by the irrigation action

        this will return the player that is the highest ranked
        around any tile surrounding the body of water being surrounded

        utilize the HighestRankedPlayer rule to get this done

        return an empty map if there is no highest player

        ties do not count

        award the highest ranked player surrounding that body of water with
        3*body.getSize() famePoints
         */


    }

    public HashMap<JavaPlayer, Integer> pointsEarnedFromLandPlacement(Location... locations) {
        int famePointsEarned = 0;

        for(BodyOfWater body : model.getBoard().getBodyOfWaterContainer().getBodiesOfWater()) {
            Collection<Location> surrounding = getSurroundingTiles(body.getLocations());
            if(containsAny(surrounding, Arrays.asList(locations))) {
                boolean isSurrounded = true;
                for(Location hex : surrounding) {
                    if(getHeight(hex, Arrays.asList(locations)) == 0) {
                        isSurrounded = false;
                    }
                }
                if(isSurrounded){
                    famePointsEarned += 3*body.getSize();
                }
            }

        }
        //todo baker
        return new HashMap<JavaPlayer, Integer>();
        // return famePointsEarned;

        /*this be called by land tile placement (that are being placed directly on the board

        this will return a hash map from JavaPlayer to integers

        Each body of water that is surrounded (which there can be more than one happening at once)
        will award the highest ranked player surrounding that body of water with
        3*body.getSize() famePoints

        Each body of water that gets surrounded can be one by any player, or no players

        Remember that there could be no developers surrounding the irrigation

        */


    }

    private boolean containsAny(Collection<Location> locations, Collection<Location> lookUps) {
        for(Location loc : lookUps) {
            if(locations.contains(loc)) {
                return true;
            }
        }
        return false;
    }

    private int getHeight(Location spaceLoc, Collection<Location> toBePlaced) {
        return model.getBoard().getSpace(spaceLoc).getHeight() +
                (toBePlaced.contains(spaceLoc) ? 1 : 0);
    }

    public LocationType getLocationType(Location location) {
        return model.getBoard().getLocationType(location);
    }

    private int neighborCountInsideCentralJava(Location location) {
        int count = 0;
        for(Location neighbor : location.getNeighbors()) {
            if(model.getBoard().areLocationsOnBoard(neighbor) &&
                    model.getBoard().getLocationType(location) == LocationType.CentralJava) {
                ++count;
            }
        }
        return count;
    }

    public boolean inLowlandsOrHighlands(Location location) {
        return inLowlands(location) || inHighLands(location);
    }

    public boolean inHighLands(Location location) {
        return model.getBoard().getLocationType(location) == LocationType.Highlands;
    }

    public boolean inLowlands(Location location) {
        return model.getBoard().getLocationType(location) == LocationType.Lowlands;
    }

    public boolean inCentralJava(Location location) {
        return model.getBoard().getLocationType(location) == LocationType.CentralJava;
    }

    public boolean isOuterMostBorder(Location location, Developer developer) {
        DeveloperPlacementRule dpr = new DeveloperPlacementRule(location, model.getBoard(), model.getDevelopersFromAllPlayers(), developer);
        if(!model.getBoard().areLocationsOnBoard(location) ||
                !dpr.allowed()) {
            return false;
        }

        if(neighborCountInsideCentralJava(location) < 6) {
            return true;
        }


        if(inLowlandsOrHighlands(location)) {
            if(neighborCountInsideCentralJava(location) == 4) {
                for(Location neighbor : location.getNeighbors()) {
                    if(inLowlandsOrHighlands(neighbor) && model.getBoard().getTopTileComponent(neighbor) == null) {
                        return true;
                    }
                }
            }
        }

        if(inCentralJava(location)) {
            for(Location neighbor : location.getNeighbors()) {
                if(inLowlandsOrHighlands(neighbor) && model.getBoard().getTopTileComponent(neighbor) == null) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean developerCanEnterHere(Location location) {
        return isOuterMostBorder(location, null);
    }

    public boolean developerCanBeRemovedFromHere(Location location, Developer developer) {
        return isOuterMostBorder(location, developer);
    }

    public boolean connectsTwoCities(Location villageLocation, Location... riceLocations) {
        int neighboringCount = 0;
        for(City city : model.getBoard().getCityContainer().getCityCollection()) {
            List<Location> cityLocations = new ArrayList<Location>(city.getCity());
            for(Location loc : riceLocations) {
                cityLocations.remove(loc);
            }
            if(neighborsCity(cityLocations, villageLocation)) {
                ++neighboringCount;
            }
        }
        return neighboringCount >= 2;
    }

    private boolean neighborsCity(List<Location> cityLocations, Location location) {
        for(Location possibleNeighbor : cityLocations) {
            if(neighbors(location, possibleNeighbor)) {
                return true;
            }
        }
        return false;
    }

    private boolean neighbors(Location location1, Location location2) {
        for(Location neighbor : location1.getNeighbors()) {
            if(location2.equals(neighbor)) {
                return true;
            }
        }
        return false;
    }

    public List<Location> getPalacesLegalForUpgrading() {
        List<Location> legalLocations = new ArrayList<Location>();
        //exclude palaces by the following criteria
        for(City city : model.getBoard().cityContainer.getCityCollection()) {
            //The current player must be the highest in the city
            if(!HighestRankingPlayerRule.highestRankingPlayerInCityRule(model.getCurrentJavaPlayer(),
                    city.getPalaceLocation(), this, model.getBoard())) {
                continue;
            }
            //the city must not have been interacted with during this turn
            if(model.getTurn().hasPalaceBeenUsed(city.getPalaceLocation())) {
                continue;
            }
            //the city must be large enough city size to support a larger palace (at least current value + 2)
            if(PalaceLevelCitySizeRule.palaceLevelSizeAllowed(city.getPalaceLocation(), model.getBoard(),
                    city.getPalaceLevel()+2)) {
                legalLocations.add(city.getPalaceLocation());
            }
        }
        return legalLocations;
    }
}
