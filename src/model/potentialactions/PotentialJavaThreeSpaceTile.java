package model.potentialactions;

import model.GameModel;
import model.actions.ActionResult;
import model.actions.tiles.PlaceThreeSpaceTile;
import model.tiles.RiceTileComponent;
import model.tiles.VillageTileComponent;

/**
 * Created by Baker on 4/14/2014.
 */
public class PotentialJavaThreeSpaceTile extends PotentialThreeSpaceMovement{

    public PotentialJavaThreeSpaceTile(GameModel game) {
        super(game);
    }

    @Override
    protected void setComponentsOnHoverBoard() {
        Boolean validity = isValid();
        getHoverBoard().reset();
        getHoverBoard().placeTileComponent(getOtherLocation(0), new RiceTileComponent(), ActionState.fromValue(validity) );
        getHoverBoard().placeTileComponent(getOtherLocation(1), new RiceTileComponent(), ActionState.fromValue(validity) );
        getHoverBoard().placeTileComponent(getCenterLocation(), new VillageTileComponent(), ActionState.fromValue(validity) );
    }

    @Override
    protected ActionResult getActionResult() {
        return new PlaceThreeSpaceTile(getCenterLocation(), getOtherLocation(0), getOtherLocation(1)).tryAction(getGameModel());
    }

    //protected

}
