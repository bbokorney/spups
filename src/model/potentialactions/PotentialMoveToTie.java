package model.potentialactions;

import model.actions.ActionResult;
import model.actions.palacefestival.AgreeToTie;
import model.actions.palacefestival.EndPalaceFestival;
import model.actions.palacefestival.RequestTie;
import model.palacefestival.PalaceFestival;
import model.palacefestival.PalaceFestivalPlayer;

/**
 * Created by Baker on 4/14/2014.
 */
public class PotentialMoveToTie extends PotentialAction {

    private PalaceFestivalPlayer playerWhoRequestedTie = null;
    private PalaceFestival festival;

    public PotentialMoveToTie(PalaceFestival festival) {
        this.festival = festival;
    }

    private ActionResult tieRequested() {
        playerWhoRequestedTie = festival.getCurrentPlayer();
        return new RequestTie(festival).tryAction();
    }

    private ActionResult tieAgreed() {
        ActionResult tieActionResult = new AgreeToTie(playerWhoRequestedTie, festival).tryAction();
        if (!tieActionResult.isSuccess() || !festival.getCurrentPlayer().equals(playerWhoRequestedTie))
            return tieActionResult;

        return new EndPalaceFestival(festival).tryAction();
    }

    @Override
    public ActionResult getActionResult() {
        return playerWhoRequestedTie == null ? tieRequested() : tieAgreed();
    }

}
