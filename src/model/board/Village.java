package model.board;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Baker on 4/14/2014.
 */
public class Village {
    private Collection<Location> village;

    public Village() {
        village = new ArrayList<Location>();
    }

    public int getSize() {
        return village.size();
    }

    public void add(Location loc) {
        village.add(loc);
    }

    public Collection<Location> getLocations() {
        return village;
    }

    public boolean equals(Village village) {
        //Check sizes are the same
        if (this.getSize() != village.getSize())
            return false;
        //Check it holds the same locations as us
        for (Location loc : getLocations()) {
            if (!village.getLocations().contains(loc))
                return false;
        }

        return true;
    }
}
