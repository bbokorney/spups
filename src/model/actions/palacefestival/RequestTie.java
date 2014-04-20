package model.actions.palacefestival;

import model.actions.Action;
import model.actions.ActionResult;
import model.actions.serialization.JsonObject;
import model.palacefestival.PalaceFestivalPlayer;

import java.util.Collection;

/**
 * Created by Baker on 4/14/2014.
 */
public class RequestTie extends Action {

    @Override
    public ActionResult tryAction() {
        Collection<PalaceFestivalPlayer> players = game.getFestivalPlayers();
        int score = -1;
        boolean tie = true;
        for (PalaceFestivalPlayer player : players) {
            int playerScore = player.getScore();
            if(score == -1) {
                score = playerScore;
            }
            else if (playerScore != score) {
                tie = false;
                break;
            }
        }

        String message = tie ? "success" : "players are not tied";

        // TODO: send the FP they would win if the tie went through
        return new ActionResult(tie, 0,0, message, this);
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
