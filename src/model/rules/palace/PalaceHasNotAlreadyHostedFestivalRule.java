package model.rules.palace;

import model.tiles.PalaceTileComponent;

/**
 * Created by Owner on 4/19/14.
 */
public class PalaceHasNotAlreadyHostedFestivalRule {

    public static boolean palaceHasNotAlreadyHostedFestival(PalaceTileComponent palace) {
        return palace.isFaceUp();
    }

}
