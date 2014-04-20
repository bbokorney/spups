package model.board;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Baker on 4/14/2014.
 */
public class BodyOfWater {

    private Collection<Location> bodyOfWater;

    public BodyOfWater() {
        bodyOfWater = new ArrayList<Location>();
    }

    public int getSize() {
        return bodyOfWater.size();
    }

    public void add(Location loc) {
        bodyOfWater.add(loc);
    }

    public Collection<Location> getLocations() {
        return bodyOfWater;
    }

}
