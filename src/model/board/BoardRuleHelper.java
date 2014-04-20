package model.board;
import model.player.Player;

import java.util.*;

/**
 * Created by Baker on 4/14/2014.
 */
public class BoardRuleHelper {
    private GameModel model;

    public BoardRuleHelper(GameModel model) {
        this.model = model;
    }

    public Map<JavaPlayer, Integer> getPlayerRanksIn(Collection<Location> locations) {
        List<Developer> developers = model.getDevelopers();

        return new HashMap<JavaPlayer, Integer>();
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
