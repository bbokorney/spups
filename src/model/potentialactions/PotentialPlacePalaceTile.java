package model.potentialactions;

import model.GameModel;
import model.Pair;
import model.actions.ActionResult;
import model.actions.tiles.PlacePalaceTile;
import model.tiles.PalaceTileComponent;

/**
 * Created by Baker on 4/14/2014.
 */
public class PotentialPlacePalaceTile extends PotentialOneSpaceMovement{

    int value;

    public PotentialPlacePalaceTile(GameModel game, int value) {
        super(game);
        this.value = value;
    }

    @Override
    protected void setComponentsOnHoverBoard() {
        getHoverBoard().reset();
        getHoverBoard().placeTileComponent(getLocation(), new PalaceTileComponent(value), ActionState.fromValue(isValid()));
    }

    @Override
    protected ActionResult getActionResult() {
        return new PlacePalaceTile(value, getLocation()).tryAction();
    }

    protected Pair<ActionResult, PlacePalaceTile> confirmPlacement(){
        PlacePalaceTile result = new PlacePalaceTile(value, getLocation());
        return new Pair<ActionResult, PlacePalaceTile>(result.doAction(getGameModel()), result);
    }
}
