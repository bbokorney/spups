package model.potentialactions;

import model.GameModel;
import model.Pair;
import model.actions.ActionResult;
import model.actions.tiles.PlaceVillageTile;
import model.palacefestival.PalaceFestival;
import model.tiles.VillageTileComponent;

/**
 * Created by Baker on 4/14/2014.
 */
public class PotentialPlaceVillageTile extends PotentialOneSpaceMovement {

    public PotentialPlaceVillageTile(GameModel game, PalaceFestival festival) {
        super(game, festival);
    }

    @Override
    protected void setComponentsOnHoverBoard() {
        getHoverBoard().reset();
        getHoverBoard().placeTileComponent(getLocation(), new VillageTileComponent(), ActionState.fromValue(isValid()));
    }

    @Override
    protected ActionResult getActionResult() {
        return new PlaceVillageTile(getLocation(), getGameModel()).tryAction();
    }

    protected Pair<ActionResult, PlaceVillageTile> confirmPlacement(){
        PlaceVillageTile result = new PlaceVillageTile(getLocation(), getGameModel() );
        return new Pair<ActionResult, PlaceVillageTile>(result.doAction(), result);
    }
}
