package model.rules.palace;

import model.palacefestival.Card;
import model.palacefestival.PalaceFestivalPlayer;
import model.player.Player;
import model.tiles.PalaceTileComponent;

/**
 * Created by Owner on 4/18/14.
 */
public class HostPalaceFestivalEligibilityRule {

    public static boolean hostPalaceFestivalEligibilityRule(PalaceFestivalPlayer player, PalaceTileComponent palace, Card festivalCard) {
        throw new UnsupportedOperationException();
        // Player must have a developer in the city
        // TODO: Should a rule be created for this?
        // Player must have a viable bid
        // TODO: Rule?
        // Palace is eligible
    }

}
