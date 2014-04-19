package model.rules.tiles;

import model.board.BoardRuleHelper;
import model.board.HexLocation;
import model.board.Location;

/**
 * Created by Baker on 4/14/2014.
 */
public class ConnectionTwoCitiesRule {
    public static boolean connectsCities(HexLocation location, BoardRuleHelper helper) {
        return helper.connectsTwoCities(location);
    }
}
