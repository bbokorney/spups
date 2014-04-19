package model.board;

import model.GameModel;
import model.player.Developer;
import model.player.Player;

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

    public Map<Player, Integer> getPlayerRanksIn(Collection<Location> locations) {
        List<Developer> developers = model.getDevelopers();

        return new HashMap<Player, Integer>();
    }

    public Collection<HexLocation> getSurroundingTiles(Collection<HexLocation> waterLocations) {
        Set<HexLocation> surroundingLocations = new HashSet<HexLocation>();
        for(HexLocation location : waterLocations) {
            for(HexLocation neighbor : location.getNeighbors()) {
                surroundingLocations.add(neighbor);
            }
        }
        return surroundingLocations;
    }

    public int pointsEarnedFromIrrigationPlacement(HexLocation location) {
        for(BodyOfWater body : model.getBoard().getBodyOfWaterContainer().getBodiesOfWater()) {
            for(HexLocation water : body.getLocations()) {
                if(neighbors(water, location)) {
                    ArrayList<HexLocation> newBody = new ArrayList<HexLocation>();
                    newBody.add(location);
                    newBody.addAll(body.getLocations());
                    int enclosingTileCount = 0;
                    Collection<HexLocation> surrounding = getSurroundingTiles(newBody);
                    for(HexLocation enclosingLocation : surrounding) {
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

    public int pointsEarnedFromLandPlacement(HexLocation... locations) {
        for(BodyOfWater body : model.getBoard().getBodyOfWaterContainer().getBodiesOfWater()) {
            Collection<HexLocation> surrounding = getSurroundingTiles(body.getLocations());
            if(containsAny(surrounding, Arrays.asList(locations))) {
                for(HexLocation hex : surrounding) {
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

    private boolean containsAny(Collection<HexLocation> locations, Collection<HexLocation> lookUps) {
        for(Location loc : lookUps) {
            if(locations.contains(loc)) {
                return true;
            }
        }
        return false;
    }

    private int getHeight(Location spaceLoc, Collection<HexLocation> toBePlaced) {
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

    public boolean connectsTwoCities(HexLocation location) {
        int neighoringCount = 0;
        for(City city : model.getBoard().getCityContainer().getCityCollection()) {
            if(neighborsCity(city, location)) {
                ++neighoringCount;
            }
        }
        return neighoringCount < 2;
    }

    private boolean neighborsCity(City city, HexLocation location) {
        for(Location possibleNeighbor : city.getCity()) {
            if(neighbors(location, possibleNeighbor)) {
                return true;
            }
        }
        return false;
    }

    private boolean neighbors(HexLocation location1, Location location2) {
        for(Location neighbor : location1.getNeighbors()) {
            if(location2.equals(neighbor)) {
                return true;
            }
        }
        return false;
    }
}
