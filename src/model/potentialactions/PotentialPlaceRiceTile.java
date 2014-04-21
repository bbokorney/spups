package model.potentialactions;

import model.GameModel;
import model.Pair;
import model.actions.ActionResult;
import model.actions.tiles.PlaceRiceTile;
import model.palacefestival.PalaceFestival;

/**
 * Created by Baker on 4/14/2014.
 */
public class PotentialPlaceRiceTile extends PotentialOneSpaceMovement {

    public PotentialPlaceRiceTile(GameModel game, PalaceFestival festival) {
        super(game, festival);
    }


    @Override
    public ActionResult getActionResult() {
        return new PlaceRiceTile(getLocation(), getGameModel()).tryAction();
    }

    /*
       This method's return type has been changed, as many PotentialActions have due to
       the modification of ActionResult. At first, ActionResult had Action as an aggregate,
       which coupled them. We separated them to not force an ActionResult to have an Action.
       This change was for the OO purposes.
       To return both, the Pair class was implemented, taking these two as it's parameterizing types
    */
    protected Pair<ActionResult, PlaceRiceTile> confirmPlacement(){
        PlaceRiceTile result = new PlaceRiceTile(getLocation(), getGameModel());
        return new Pair<ActionResult, PlaceRiceTile>(result.doAction(), result);
    }
}
