package model.actions.palacefestival;

import model.actions.Action;
import model.actions.ActionResult;
import model.actions.serialization.JsonObject;
import model.palacefestival.PalaceFestivalPlayer;
import model.rules.palace.FestivalWinnerRule;

import java.util.Collection;

/**
 * Created by Baker on 4/14/2014.
 */
public class EndPalaceFestival extends Action {

    @Override
    public ActionResult tryAction() {
        Collection<PalaceFestivalPlayer> winners = game.getFestivalPlayers();
        int numberOfWinners = winners.size();
        boolean atLeastOneWinner = numberOfWinners >= 1;
        if (!atLeastOneWinner) {
            return new ActionResult(true, 0, 0, "error: there are no players left in the festival", this);
        }

        int famePoints = new FestivalWinnerRule().pointsToAward(numberOfWinners > 1, game.getFestivalPalace().getLevel());
        return new ActionResult(true, 0, famePoints, "palace festival over", this);
    }

    @Override
    public ActionResult doAction() {
        ActionResult result = tryAction();
        if (result.isSuccess()) {
            Collection<PalaceFestivalPlayer> winners = game.getFestivalPlayers();
            int famePoints = new FestivalWinnerRule().pointsToAward(winners.size() > 1, game.getFestivalPalace().getLevel());
            for (PalaceFestivalPlayer winner : winners) {
                for (int i = 0; i < famePoints; i++) {
                    winner.incrementScore();
                }
            }

            game.endPalaceFestival();
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
