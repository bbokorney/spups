package model.rules.tiles;

import model.board.BoardRuleHelper;
import model.board.HexLocation;
import model.board.Location;

/**
 * Created by Baker on 4/14/2014.
 */
public class ConnectionTwoCitiesRule {
    public static boolean connectsCities(BoardRuleHelper helper, Location villageLocation, Location... riceLocations) {
        return helper.connectsTwoCities(villageLocation, riceLocations);
    }
}
