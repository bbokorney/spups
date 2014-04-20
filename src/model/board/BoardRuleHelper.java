package model.board;

import model.GameModel;
import model.player.Developer;
import model.player.JavaPlayer;
import model.player.Player;
import org.omg.PortableInterceptor.LOCATION_FORWARD;

import java.awt.*;
import java.util.*;
import java.util.List;

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
        }

        while(maxHeight >= 0) {
            final int currentHeight = maxHeight;
            Arrays.sort(players, new Comparator<JavaPlayer>() {
                @Override
                public int compare(JavaPlayer p1, JavaPlayer p2) {
                    int p1Count = heightMap.get(p1).containsKey(currentHeight) ? heightMap.get(p1).get(currentHeight) : 0;
                    int p2Count = heightMap.get(p2).containsKey(currentHeight) ? heightMap.get(p2).get(currentHeight) : 0;
                    return p2Count - p1Count;
                }
            });
            int heightCount = 0;
            for(int i = 0; i < players.length; ++i) {
                if(heightMap.get(players[i]).containsKey(heightCount)) {
                    ++heightCount;
                }
            }

            if(heightCount == 0) {
                // no one has this height, can't determine anything
                continue;
            }

            if(heightCount > 1) {
                // there's a tie, try the next one
                
            }
        }

        return new HashMap<JavaPlayer, Integer>();
    }

    private void createOrIncrement(Map<Integer, Integer> map, Integer key) {
        int value = 1;
        if(map.containsKey(key)) {
            value += map.get(key);
        }
        map.put(key, value);
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

    public int pointsEarnedFromIrrigationPlacement(HexLocation location) {
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
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    public int pointsEarnedFromLandPlacement(Location... locations) {
        for(BodyOfWater body : model.getBoard().getBodyOfWaterContainer().getBodiesOfWater()) {
            Collection<Location> surrounding = getSurroundingTiles(body.getLocations());
            if(containsAny(surrounding, Arrays.asList(locations))) {
                for(Location hex : surrounding) {
                    if(getHeight(hex, Arrays.asList(locations)) == 0) {
                        return 0;
                    }
                }
            }
            else {
                return 0;
            }
        }
        return 1;
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

    public boolean isOuterMostBorder(HexLocation location) {
        for(Location neighbor : location.getNeighbors()) {
            if(model.getBoard().areLocationsOnBoard(neighbor)) {
                return true;
            }
        }
        return false;
    }

    public boolean developerCanEnterHere(HexLocation location) {
        return isOuterMostBorder(location);
    }

    public boolean developerCanBeRemovedFromHere(HexLocation location) {
        return isOuterMostBorder(location);
    }

    public boolean connectsTwoCities(HexLocation villageLocation, HexLocation... riceLocation) {
        // TODO: Baker, waiting on Suchit
        int neighboringCount = 0;
        for(City city : model.getBoard().getCityContainer().getCityCollection()) {
            if(neighborsCity(city, villageLocation)) {
                ++neighboringCount;
            }
        }
        return neighboringCount < 2;
    }

    private boolean neighborsCity(City city, HexLocation location, HexLocation... riceLocation) {
        for(Location possibleNeighbor : city.getCity()) {
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

}
