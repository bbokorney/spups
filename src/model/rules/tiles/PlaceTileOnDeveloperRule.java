package model.rules.tiles;

import model.board.Location;
import model.player.Developer;

import java.util.Collection;

/**
 * Created by Baker on 4/14/2014.
 */
public class PlaceTileOnDeveloperRule {
    public static boolean canPlaceTile(Collection<Developer> developers, Location... locations) {
        for(Developer dev : developers) {
            for(Location location : locations) {
                if(dev.getLocation().equals(location)) {
                    return false;
                }
            }
        }
        return true;
    }
}
