package model.potentialactions;

import model.GameModel;
import model.Pair;
import model.actions.ActionResult;
import model.actions.tiles.PlaceRiceTile;
import model.tiles.RiceTileComponent;

/**
 * Created by Baker on 4/14/2014.
 */
public class PotentialPlaceRiceTile extends PotentialOneSpaceMovement {

    public PotentialPlaceRiceTile(GameModel game) {
        super(game);
    }

    @Override
    protected void setComponentsOnHoverBoard() {
        getHoverBoard().reset();
        getHoverBoard().placeTileComponent(getLocation(), new RiceTileComponent(), ActionState.fromValue(isValid()));
    }

    @Override
    protected ActionResult getActionResult() {
        return new PlaceRiceTile(getLocation()).tryAction(getGameModel());
    }

    protected Pair<ActionResult, PlaceRiceTile> confirmPlacement(){
        PlaceRiceTile result = new PlaceRiceTile(getLocation());
        return new Pair<ActionResult, PlaceRiceTile>(result.doAction(getGameModel()), result);
    }
}
