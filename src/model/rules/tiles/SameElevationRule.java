package model.rules.tiles;

import model.board.Space;

/**
 * Created by Baker on 4/14/2014.
 */
public class SameElevationRule {
    public static boolean sameElevation(Space... spaces) {
        int elevation = spaces[0].getHeight();
        for(int i = 1; i < spaces.length; ++i) {
            if(spaces[i].getHeight() != elevation) {
                return false;
            }
        }
        return true;
    }
}
