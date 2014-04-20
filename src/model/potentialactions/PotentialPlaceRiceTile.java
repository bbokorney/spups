package model.potentialactions;

import model.GameModel;
import model.Pair;
import model.actions.ActionResult;
import model.actions.tiles.PlaceRiceTile;
import model.palacefestival.PalaceFestival;
import model.tiles.RiceTileComponent;

/**
 * Created by Baker on 4/14/2014.
 */
public class PotentialPlaceRiceTile extends PotentialOneSpaceMovement {

    public PotentialPlaceRiceTile(GameModel game, PalaceFestival festival) {
        super(game, festival);
    }


    @Override
    protected ActionResult getActionResult() {
        return new PlaceRiceTile(getLocation(), getGameModel()).tryAction();
    }

    protected Pair<ActionResult, PlaceRiceTile> confirmPlacement(){
        PlaceRiceTile result = new PlaceRiceTile(getLocation(), getGameModel());
        return new Pair<ActionResult, PlaceRiceTile>(result.doAction(), result);
    }
}
