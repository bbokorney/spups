package model.rules.tiles;

import model.board.Board;
import model.board.Location;
import model.tiles.Tile;

/**
 * Created by Baker on 4/14/2014.
 */
public class PlacementOnSameSizeTileRule {
    public static boolean placingOnSameTile(Board board, Location... locations) {
        if(board.getTopTileComponent(locations[0]) != null) {
            Tile tile = board.getTopTileComponent(locations[0]).getParent();
            int count = 1;
            for (int i = 1; i < locations.length; ++i) {
	            if(board.getTopTileComponent(locations[i]) == null) return false;
                if (tile.equals(board.getTopTileComponent(locations[i]).getParent())) {
                    ++count;
                }
            }
            return count == (locations.length > tile.getNumberOfComponents() ? locations.length : tile.getNumberOfComponents());
        }
        return false;
    }
}
