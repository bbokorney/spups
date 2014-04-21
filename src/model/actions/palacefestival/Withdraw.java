package model.actions.palacefestival;

import model.actions.Action;
import model.actions.ActionResult;
import model.actions.serialization.JsonObject;
import model.palacefestival.PalaceFestival;
import model.palacefestival.PalaceFestivalPlayer;

import java.util.Collection;

/**
 * Created by Baker on 4/14/2014.
 */
public class Withdraw extends Action {

    private PalaceFestival festival;

    public Withdraw(PalaceFestival festival) {
        this.festival = festival;
    }

    @Override
    public ActionResult tryAction() {
        return new ActionResult(true, 0, 0, "player withdrawn");
    }

    @Override
    public ActionResult doAction() {
        ActionResult result = tryAction();
        if(result.isSuccess()) {
            festival.removePlayer(festival.getCurrentPlayer());
            festival.advanceTurn();
            Collection<PalaceFestivalPlayer> players = festival.getPlayers();
            if (players.size() == 1) {
                ActionResult endResult = new EndPalaceFestival(festival).doAction();
                if (endResult.isSuccess())
                    result = endResult;
            }
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
