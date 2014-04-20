package model.rules.tiles;

import model.board.BoardRuleHelper;
import model.board.Location;

/**
 * Created by Baker on 4/14/2014.
 */
public class ConnectionTwoCitiesRule {
    public static boolean connectsCities(Location location, BoardRuleHelper helper) {
        return helper.connectsTwoCities(location);
    }
}
