package model.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.tiles.TileComponent;

/**
 * Created by Baker on 4/14/2014.
 */
public abstract class Board {

	private Map<Location, Space> board;
    private ArrayList<Location> highlands;
    private ArrayList<Location> lowlands;

    private BodyOfWaterContainer bodyOfWaterContainer;
    private CityContainer cityContainer;
    private VillageContainer villageContainer;

	public Board() {
		board = new HashMap<Location, Space>();
        bodyOfWaterContainer = new BodyOfWaterContainer();
        cityContainer = new CityContainer();
        villageContainer = new VillageContainer();
        highlands = new ArrayList<Location>();
        lowlands = new ArrayList<Location>();
	}

    public LocationType getLocationType(Location loc) {
        if (highlands.contains(loc))
            return LocationType.Highlands;
        else if (lowlands.contains(loc))
            return LocationType.Lowlands;
        else
            return LocationType.CentralJava;
    }

    public void addToLowlands(Location loc) {
        lowlands.add(loc);
    }

    public void addToHighlands(Location loc) {
        highlands.add(loc);
    }

    public BodyOfWaterContainer getBodyOfWaterContainer() {
        return bodyOfWaterContainer;
    }

    public CityContainer getCityContainer() {
        return cityContainer;
    }

    public VillageContainer getVillageContainer() {
        return villageContainer;
    }

    public void placeSpace(Location loc, Space space) {
		board.put(loc, space);
	}

	public Space getSpace(Location loc) {
		return board.get(loc);
	}

	public void placeTopTileComponent(Location loc, TileComponent tile) {
		Space space = board.get(loc);
		space.accept(tile);
	}
	
	public TileComponent getTopTileComponent(Location loc) {
		Space space = board.get(loc);
		return space.getTopTileComponent();
	}

    public boolean areLocationsOnBoard(Location... locations){
        //Check that board contains each of these locations
        for (Location loc : locations) {
            if (!board.containsKey(loc))
                return false;
        }
        return true;
    }

    public boolean isHeightAtLocation(int i){
        //todo for Sachit, my love
        return false;
    }
}
