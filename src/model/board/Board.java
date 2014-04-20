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

    //TODO:
        /*
        for Village tile, check
        1) is it joining two (or more) villages
        2) is it its own village
        3) is it joining a village and a city
        for irrigation, check
        1) its own body of water?
        2) a new body of water?
        for rice, check
        1) are we splitting a village or city?
     */

    public void placeIrrigationTileComponent(Location loc, TileComponent tile) {

    }

    public void placeRiceTileComponent(Location loc, TileComponent tile) {

    }

    public void placeVillageTileComponent(Location loc, TileComponent tile) {

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

    public boolean isHeightAtLocation(int i, Location loc){
        Space space = this.getSpace(loc);
        int height = space.getHeight();
        return height == i;
    }
}
