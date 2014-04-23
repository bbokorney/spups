package model.actions.palacefestival;

import model.GameModel;
import model.actions.Action;
import model.actions.ActionResult;
import model.actions.serialization.JsonObject;
import model.palacefestival.Card;
import model.palacefestival.PalaceFestival;
import model.palacefestival.PalaceFestivalPlayer;

/**
 * Created by Baker on 4/14/2014.
 */
public class PickUpDeckCard extends Action {

    private PalaceFestival festival;
    private Card cardDrawn;
    private GameModel game;

    public PickUpDeckCard(GameModel game, PalaceFestival festival) {
        this.festival = festival;
        this.cardDrawn = null;
        this.game = game;
    }

    @Override
    public ActionResult tryAction() {
        boolean canPickUpCard = festival.canDrawCard();
        boolean cardExists = festival.doesDeckHaveCard();
        boolean hasEnoughAP = game.canUseAPForNonLandTileAction(1);
        boolean success = canPickUpCard && cardExists && hasEnoughAP;
        String message = success ? "action successful" : "action failed";
        return new ActionResult(success, 0, 1, message);
    }

    @Override
    public ActionResult doAction() {
        ActionResult result = tryAction();
        if (result.isSuccess()) {
            PalaceFestivalPlayer player = festival.getCurrentPlayer();
            if (cardDrawn == null) {
                this.cardDrawn = festival.drawDeckCard();
            }
            else {
                festival.drawSpecificDeckCard(cardDrawn);
            }

            player.takeCard(cardDrawn);
            festival.recordDrawCard();

            game.useActionPoints(result.getActionPoints());
        }

        return result;
    }

    @Override
    public String serialize() {
        // TODO: Sara
        throw new UnsupportedOperationException("Tell Sara to implement me!");
    }

    @Override
    public Action restore(JsonObject actionToRestore) {
        // TODO: Sara
        throw new UnsupportedOperationException("Tell Sara to implement me!");
    }


}
