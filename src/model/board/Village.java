package model.board;

import java.util.Collection;

/**
 * Created by Baker on 4/14/2014.
 */
public class Village {
    private Collection<Location> village;

    public int getSize() {
        return village.size();
    }

    public void add(Location loc) {
        village.add(loc);
    }
}
