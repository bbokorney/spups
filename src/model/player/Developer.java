package model.player;

import model.board.Location;

/**
 * Created by Baker on 4/14/2014.
 */
public class Developer {
    private Location location;
    public Developer(Location loc) {
        location = loc;
    }
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location loc) {
        location = loc;
    }
}
