package model.rules.tiles;

import model.actions.Action;
import model.board.Board;
import model.board.BoardRuleHelper;
import model.board.Location;
import model.board.LocationType;

/**
 * Created by Baker on 4/14/2014.
 */
public class PlacementOutsideCentralJavaRule {
    public static boolean canPlaceOutsideCentralJava(Board board, BoardRuleHelper helper, Location... locations) {
        int min = Integer.MAX_VALUE;
        for(Location loc : locations) {
            min = Math.min(min, board.getSpace(loc).getHeight());
        }
        if(min > 0) {
            return true;
        }
        return locations.length - numberOutsideCentralJava(helper, locations) > 0;
    }

    public static int numberOutsideCentralJava(BoardRuleHelper helper, Location... locations) {
        int count = 0;
        for(Location loc: locations) {
            if(helper.getLocationType(loc) == LocationType.Highlands ||
                    helper.getLocationType(loc) == LocationType.Lowlands ) {
                count++;
            }
        }
        return count;
    }
}
