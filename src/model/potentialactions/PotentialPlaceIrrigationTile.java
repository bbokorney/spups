package model.potentialactions;

import model.GameModel;
import model.Pair;
import model.actions.ActionResult;
import model.actions.tiles.PlaceIrrigationTile;
import model.palacefestival.PalaceFestival;
import model.tiles.IrrigationTileComponent;

/**
 * Created by Baker on 4/14/2014.
 */
public class PotentialPlaceIrrigationTile extends PotentialOneSpaceMovement{

    public PotentialPlaceIrrigationTile(GameModel game, PalaceFestival festival) {
        super(game, festival);
    }

    @Override
    protected void setComponentsOnHoverBoard() {
        getHoverBoard().reset();
        getHoverBoard().placeTileComponent(getLocation(), new IrrigationTileComponent(), ActionState.fromValue(isValid()));
    }

    @Override
    protected ActionResult getActionResult() {
        return new PlaceIrrigationTile(getLocation(), getGameModel()).tryAction();
    }

    protected Pair<ActionResult, PlaceIrrigationTile> confirmPlacement(){
        PlaceIrrigationTile result = new PlaceIrrigationTile(getLocation(), getGameModel());
        return new Pair<ActionResult, PlaceIrrigationTile>(result.doAction(), result);
    }
}
