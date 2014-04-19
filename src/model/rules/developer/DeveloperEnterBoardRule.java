package model.rules.developer;

import model.board.BoardRuleHelper;
import model.board.Location;

/**
 * Created by Baker on 4/14/2014.
 */
public class DeveloperEnterBoardRule {
    public static boolean canEnterHere(Location location, BoardRuleHelper helper) {
        return  helper.developerCanEnterHere(location);
    }
}
