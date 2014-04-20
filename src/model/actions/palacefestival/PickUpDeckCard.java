package model.actions.palacefestival;

import model.GameModel;
import model.Pair;
import model.actions.Action;
import model.actions.ActionResult;
import model.actions.serialization.JsonObject;
import model.palacefestival.Card;
import model.palacefestival.PalaceFestivalPlayer;

/**
 * Created by Baker on 4/14/2014.
 */
public class PickUpDeckCard extends Action {



    public PickUpDeckCard() {

    }


    @Override
    public ActionResult tryAction(GameModel game) {
        // TODO: Sara
        throw new UnsupportedOperationException("Tell Sara to implement me!");
    }

    @Override
    public ActionResult doAction(GameModel game) {
        ActionResult result = tryAction(game);
        if (result.isSuccess()) {
            PalaceFestivalPlayer player = game.getCurrentPalaceFestivalPlayer();
            player.takeCard(game.drawDeckCard());
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
