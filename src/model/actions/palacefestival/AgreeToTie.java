package model.actions.palacefestival;

import model.actions.Action;
import model.actions.ActionResult;
import model.actions.serialization.JsonObject;
import model.palacefestival.PalaceFestivalPlayer;

/**
 * Created by Owner on 4/20/14.
 */
public class AgreeToTie extends Action {

    private PalaceFestivalPlayer requester;

    public AgreeToTie(PalaceFestivalPlayer requester) {
        this.requester = requester;
    }

    @Override
    public ActionResult tryAction() {
        boolean success = requester != null;
        // TODO put real FPs
        return new ActionResult(success, 0, 0, "success", this);
    }

    @Override
    public ActionResult doAction() {
        ActionResult result = tryAction();
        if (result.isSuccess()) {
            game.advancePalaceFestivalTurn();
        }

        return result;
    }

    @Override
    public String serialize() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Action restore(JsonObject actionToRestore) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
