package model.rules.developer;

import model.board.BoardRuleHelper;
import model.board.Location;

/**
 * Created by Baker on 4/14/2014.
 */
public class DeverloperExitBoardRule {
    public static boolean canExitHere(Location location, BoardRuleHelper helper) {
        return helper.developerCanBeRemovedFromHere(location);
    }
}
