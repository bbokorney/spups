package model.rules.developer;

import model.board.BoardRuleHelper;
import model.board.HexLocation;
import model.board.Location;
import model.player.Developer;

/**
 * Created by Baker on 4/14/2014.
 */
public class DeverloperExitBoardRule {
    public static boolean canExitHere(HexLocation location, BoardRuleHelper helper, Developer developer) {
        return helper.developerCanBeRemovedFromHere(location, developer);
    }
}
