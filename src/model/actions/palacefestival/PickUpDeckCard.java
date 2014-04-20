package model.actions.palacefestival;

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

    public PickUpDeckCard(PalaceFestival festival) {
        this.festival = festival;
    }

    @Override
    public ActionResult tryAction() {
        boolean canPickUpCard = festival.canDrawCard();
        boolean cardExists = festival.drawDeckCard() != null;
        boolean success = true;//canPickUpFestivalCard && festivalCardExists;
        String message = success ? "action successful" : "action failed";
        return new ActionResult(success, 0, 1, message, this);
    }

    @Override
    public ActionResult doAction() {
        ActionResult result = tryAction();
        if (result.isSuccess()) {
            PalaceFestivalPlayer player = festival.getCurrentPlayer();
            player.takeCard(festival.drawDeckCard());
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
