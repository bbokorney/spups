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
public class PickUpFestivalCard extends Action {

    private PalaceFestival festival;
    private Card festivalCard;

    public PickUpFestivalCard(PalaceFestival festival) {
        this.festival = festival;
        this.festivalCard = null;
    }

    @Override
    public ActionResult tryAction() {
        boolean canPickUpFestivalCard = festival.canDrawCard();
        boolean festivalCardExists = festival.peekAtFestivalCard() != null;
        boolean success = canPickUpFestivalCard && festivalCardExists;
        String message = success ? "action successful" : "action failed";
        return new ActionResult(success, 0, 1, message);
    }

    @Override
    public ActionResult doAction() {
        ActionResult result = tryAction();

        if(result.isSuccess()) {
            if (festivalCard == null) {
                festivalCard = festival.drawFestivalCard();
            }
            else {
                festival.drawSpecificDeckCard(festivalCard);
            }

            PalaceFestivalPlayer player = festival.getCurrentPlayer();
            player.takeCard(festivalCard);
            festival.recordDrawCard();
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
