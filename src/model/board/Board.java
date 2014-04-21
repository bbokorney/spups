package model.board;

import java.util.*;

import model.tiles.TileComponent;

/**
 * Created by Baker on 4/14/2014.
 */
public abstract class Board {

	protected Map<Location, Space> board;
    private ArrayList<Location> highlands;
    private ArrayList<Location> lowlands;

    protected BodyOfWaterContainer bodyOfWaterContainer;
    protected CityContainer cityContainer;
    protected VillageContainer villageContainer;

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

    public abstract void placeIrrigationTileComponent(Location loc, TileComponent tile);

    public abstract void placeRiceTileComponent(Location loc, TileComponent tile);

    public abstract void placeVillageTileComponent(Location loc, TileComponent tile);

    public abstract void buildPalace(Location loc, TileComponent tile);

    public abstract void upgradePalace(Location loc, TileComponent tile);
	
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

    public Collection<Location> getAllLocations() {
        ArrayList<Location> locations = new ArrayList<Location>();
        Iterator<Location> iter = board.keySet().iterator();
        while(iter.hasNext()) {
            locations.add(iter.next());
        }
        return locations;
    }

    public boolean isLocationInCity(Location loc) {
        for (City c : cityContainer.getCityCollection()) {
            if (c.getCity().contains(c))
                return true;
        }
        return false;
    }

    public boolean isLocationInVillage(Location loc) {
        for (Village v : villageContainer.getVillages()) {
            if (v.getLocations().contains(v))
                return true;
        }
        return false;
    }
}
