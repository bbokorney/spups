package model.board;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Baker on 4/14/2014.
 */
public class BodyOfWater {

    private Collection<HexLocation> bodyOfWater;

    public BodyOfWater() {
        bodyOfWater = new ArrayList<HexLocation>();
    }

    public int getSize() {
        return bodyOfWater.size();
    }

    public void add(HexLocation loc) {
        bodyOfWater.add(loc);
    }

    public Collection<HexLocation> getLocations() {
        return bodyOfWater;
    }

}
