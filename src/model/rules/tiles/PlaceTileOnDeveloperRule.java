package model.rules.tiles;

import model.GameModel;
import model.board.Board;
import model.board.Location;
import model.board.Space;
import model.player.Developer;
import model.tiles.TileComponent;

/**
 * Created by Baker on 4/14/2014.
 */
public class PlaceTileOnDeveloperRule {
    public static boolean canPlaceTile(Location location, TileComponent component, GameModel model) {
        for(Developer dev : model.getDevelopers()) {
            if(dev.getLocation().equals(location)) {
                return false;
            }
        }
        return true;
    }
}
