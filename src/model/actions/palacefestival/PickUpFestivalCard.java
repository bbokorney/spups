package model.actions.palacefestival;

import model.actions.Action;
import model.actions.ActionResult;
import model.actions.serialization.JsonObject;
import model.palacefestival.Card;
import model.palacefestival.PalaceFestivalPlayer;

/**
 * Created by Baker on 4/14/2014.
 */
public class PickUpFestivalCard extends Action {

    @Override
    public ActionResult tryAction() {
        boolean canPickUpFestivalCard = game.canDrawCard();
        boolean festivalCardExists = game.peekAtFestivalCard() != null;
        boolean success = canPickUpFestivalCard && festivalCardExists;
        String message = success ? "action successful" : "action failed";
        return new ActionResult(success, 0, 1, message, this);
    }

    @Override
    public ActionResult doAction() {
        ActionResult result = tryAction();

        if(result.isSuccess()) {
            Card festivalCard = game.drawFestivalCard();
            PalaceFestivalPlayer player = game.getCurrentPalaceFestivalPlayer();
            player.takeCard(festivalCard);
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

    @Override
    public int getActionID() {
        // TODO: Sara
        throw new UnsupportedOperationException("Tell Sara to implement me!");
    }

}
