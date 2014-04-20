package model.potentialactions;

import model.actions.ActionResult;
import model.actions.palacefestival.AgreeToTie;
import model.actions.palacefestival.EndPalaceFestival;
import model.actions.palacefestival.RequestTie;
import model.palacefestival.PalaceFestivalPlayer;

/**
 * Created by Baker on 4/14/2014.
 */
public class PotentialMoveToTie extends PotentialAction {

    private PalaceFestivalPlayer playerWhoRequestedTie = null;

    private ActionResult tieRequested() {
        playerWhoRequestedTie = getGameModel().getCurrentPalaceFestivalPlayer();
        return new RequestTie().tryAction(getGameModel());
    }

    private ActionResult tieAgreed() {
        ActionResult tieActionResult = new AgreeToTie(playerWhoRequestedTie).tryAction(getGameModel());
        if (!tieActionResult.isSuccess() || !getGameModel().getCurrentPalaceFestivalPlayer().equals(playerWhoRequestedTie))
            return tieActionResult;

        return new EndPalaceFestival().tryAction(getGameModel());
    }

    @Override
    protected void setComponentsOnHoverBoard() {
        // nothing to set
    }

    @Override
    protected ActionResult getActionResult() {
        return playerWhoRequestedTie == null ? tieRequested() : tieAgreed();
    }
}
