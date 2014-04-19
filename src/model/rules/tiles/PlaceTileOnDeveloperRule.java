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
    public static boolean canPlaceTile(GameModel model, Location... locations) {
        for(Developer dev : model.getDevelopers()) {
            for(Location location : locations) {
                if(dev.getLocation().equals(location)) {
                    return false;
                }
            }
        }
        return true;
    }
}
