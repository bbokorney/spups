package model.board;

import model.player.Player;

import java.util.*;

/**
 * Created by Baker on 4/14/2014.
 */
public class BoardRuleHelper {
    public static Map<Player, Integer> getPlayerRanksIn(Collection<Location> locations) {

        return new HashMap<Player, Integer>();
    }

    public static boolean getSurroundingTiles(BodyOfWater bow, List<Location> locationsOutput) {
        return false;
    }

    public static LocationType getLocationType(Location location) {
        return LocationType.CentralJava;
    }

    public boolean isOuterMostBorder(Location location) {
        return false;
    }

    public boolean developerCanEnterHere(Location location) {
        return false;
    }

    public boolean developerCanBeRemovedFromHere(Location location) {
        return false;
    }

    public boolean connectsTwoCities(Location location) { return false; }
}
