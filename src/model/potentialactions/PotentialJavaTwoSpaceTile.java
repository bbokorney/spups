package model.potentialactions;

import model.GameModel;
import model.Pair;
import model.actions.ActionResult;
import model.actions.tiles.PlaceTwoSpaceTile;
import model.palacefestival.PalaceFestival;
import model.tiles.RiceTileComponent;
import model.tiles.VillageTileComponent;

/**
 * Created by Baker on 4/14/2014.
 */
public class PotentialJavaTwoSpaceTile extends PotentialTwoSpaceMovement{


    public PotentialJavaTwoSpaceTile(GameModel game, PalaceFestival festival) {
        super(game, festival);
    }

//    private void setComponentsOnHoverBoard() {
//       Boolean validity = isValid();
//       getHoverBoard().reset();
//       getHoverBoard().placeTileComponent(getOtherLocation(), new RiceTileComponent(), ActionState.fromValue(validity) );
//       getHoverBoard().placeTileComponent(getCenterLocation(), new VillageTileComponent(), ActionState.fromValue(validity) );
//    }

    @Override
    protected ActionResult getActionResult() {
        return new PlaceTwoSpaceTile(getCenterLocation(), getOtherLocation(), getGameModel()).tryAction();
    }

    protected Pair<ActionResult, PlaceTwoSpaceTile> confirmPlacement() {
        PlaceTwoSpaceTile result = new PlaceTwoSpaceTile(getCenterLocation(), getOtherLocation(), getGameModel());
        return new Pair<ActionResult, PlaceTwoSpaceTile>(result.doAction(), result);
    }

}
