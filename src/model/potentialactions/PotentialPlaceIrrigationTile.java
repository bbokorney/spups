package model.potentialactions;

import model.GameModel;
import model.Pair;
import model.actions.ActionResult;
import model.actions.tiles.PlaceIrrigationTile;
import model.tiles.IrrigationTileComponent;

/**
 * Created by Baker on 4/14/2014.
 */
public class PotentialPlaceIrrigationTile extends PotentialOneSpaceMovement{

    public PotentialPlaceIrrigationTile(GameModel game) {
        super(game);
    }

    @Override
    protected void setComponentsOnHoverBoard() {
        getHoverBoard().reset();
        getHoverBoard().placeTileComponent(getLocation(), new IrrigationTileComponent(), ActionState.fromValue(isValid()));
    }

    @Override
    public ActionResult getActionResult() {
        return new PlaceIrrigationTile(getLocation()).tryAction(getGameModel());
    }

    public Pair<ActionResult, PlaceIrrigationTile> confirmPlacement(){
        PlaceIrrigationTile result = new PlaceIrrigationTile(getLocation());
        return new Pair<ActionResult, PlaceIrrigationTile>(result.doAction(getGameModel()), result);
    }
}
