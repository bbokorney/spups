package model.potentialactions;

import model.GameModel;
import model.Pair;
import model.actions.Action;
import model.actions.ActionResult;
import model.actions.tiles.PlacePalaceTile;
import model.palacefestival.PalaceFestival;

/**
 * Created by Baker on 4/14/2014.
 */
public class PotentialPlacePalaceTile extends PotentialOneSpaceMovement{

    int value;

    public PotentialPlacePalaceTile(GameModel game, PalaceFestival festival, int value) {
        super(game, festival);
        this.value = value;
    }

    @Override
    public ActionResult getActionResult() {
        return new PlacePalaceTile(value, getLocation(), getGameModel()).tryAction();
    }

    public void incrementLevel() {
        if(value != 10) {
            value += 2;
        }
    }

    public void decrementLevel() {
        if(value != 2) {
            value -= 2;
        }
    }

    public int getLevel() { return value; }

    /*
       This method's return type has been changed, as many PotentialActions have due to
       the modification of ActionResult. At first, ActionResult had Action as an aggregate,
       which coupled them. We separated them to not force an ActionResult to have an Action.
       This change was for the OO purposes.
       To return both, the Pair class was implemented, taking these two as it's parameterizing types
    */
    public Pair<ActionResult, Action> confirmAction(){
        PlacePalaceTile result = new PlacePalaceTile(value, getLocation(), getGameModel());
        return new Pair<ActionResult, Action>(result.doAction(), result);
    }
}
