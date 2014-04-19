package model.potentialactions;

import model.GameModel;
import model.Pair;
import model.actions.ActionResult;
import model.actions.tiles.PlaceVillageTile;
import model.tiles.VillageTileComponent;

/**
 * Created by Baker on 4/14/2014.
 */
public class PotentialPlaceVillageTile extends PotentialOneSpaceMovement {

    public PotentialPlaceVillageTile(GameModel game) {
        super(game);
    }

    @Override
    protected void setComponentsOnHoverBoard() {
        getHoverBoard().reset();
        getHoverBoard().placeTileComponent(getLocation(), new VillageTileComponent(), ActionState.fromValue(isValid()));
    }

    @Override
    public ActionResult getActionResult() {
        return new PlaceVillageTile(getLocation()).tryAction(getGameModel());
    }

    public Pair<ActionResult, PlaceVillageTile> confirmPlacement(){
        PlaceVillageTile result = new PlaceVillageTile(getLocation());
        return new Pair<ActionResult, PlaceVillageTile>(result.doAction(getGameModel()), result);
    }
}
