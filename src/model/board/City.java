package model.board;

import model.tiles.PalaceTileComponent;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Sachit on 4/15/2014.
 */
public class City {

    private Collection<Location> city;
    private Location palaceLocation;
    private PalaceTileComponent palace;

    public City(Location palaceLocation, PalaceTileComponent palace) {
        city = new ArrayList<Location>();
        this.palaceLocation = palaceLocation;
        this.palace = palace;
    }

    public int getSize() {
        return city.size();
    }

    public void add(Location... locations) {
        for (Location location : locations)
            city.add(location);
    }

    public int getPalaceLevel() {
        return palace.getLevel();
    }

    public Location getPalaceLocation() {
        return palaceLocation;
    }

    public Collection<Location> getCity() {
        return city;
    }

    public PalaceTileComponent getPalaceTile() {
        return palace;
    }

    public void placePalaceTile(PalaceTileComponent palace) {
        this.palace = palace;
    }

    //If this city holds this location, remove it. Otherwise, nothing.
    public void removeLocation(Location loc) {
        if (city.contains(loc))
            city.remove(loc);
    }

    public boolean equals(City city) {
        //Check sizes are the same
        if (this.getSize() != city.getSize())
            return false;
        //Check it holds the same locations as us
        for (Location loc : getCity()) {
            if (!city.getCity().contains(loc))
                return false;
        }

        return (!getPalaceLocation().equals(city.getPalaceLocation())
                && !getPalaceTile().equals(city.getPalaceTile()));
    }
}
