package model.potentialactions;

import model.GameModel;
import model.Pair;
import model.actions.Action;
import model.actions.ActionResult;
import model.actions.tiles.PlaceIrrigationTile;
import model.palacefestival.PalaceFestival;

/**
 * Created by Baker on 4/14/2014.
 */
public class PotentialPlaceIrrigationTile extends PotentialOneSpaceMovement{

    public PotentialPlaceIrrigationTile(GameModel game, PalaceFestival festival) {
        super(game, festival);
    }

//    private void setComponentsOnHoverBoard() {
//        //getHoverBoard().reset();
//        //getHoverBoard().placeTileComponent(getLocation(), new IrrigationTileComponent(), ActionState.fromValue(isValid()));
//    }

    @Override
    public ActionResult getActionResult() {
        return new PlaceIrrigationTile(getLocation(), getGameModel()).tryAction();
    }

    /*
       This method's return type has been changed, as many PotentialActions have due to
       the modification of ActionResult. At first, ActionResult had Action as an aggregate,
       which coupled them. We separated them to not force an ActionResult to have an Action.
       This change was for the OO purposes.
       To return both, the Pair class was implemented, taking these two as it's parameterizing types
    */
    public Pair<ActionResult, Action> confirmAction(){
        PlaceIrrigationTile result = new PlaceIrrigationTile(getLocation(), getGameModel());
        return new Pair<ActionResult, Action>(result.doAction(), result);
    }
}
