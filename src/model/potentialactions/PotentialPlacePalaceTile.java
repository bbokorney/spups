package model.potentialactions;

import model.GameModel;
import model.Pair;
import model.actions.ActionResult;
import model.actions.tiles.PlacePalaceTile;
import model.palacefestival.PalaceFestival;
import model.tiles.PalaceTileComponent;

/**
 * Created by Baker on 4/14/2014.
 */
public class PotentialPlacePalaceTile extends PotentialOneSpaceMovement{

    int value;

    public PotentialPlacePalaceTile(GameModel game, PalaceFestival festival, int value) {
        super(game, festival);
        this.value = value;
    }

    @Override
    protected ActionResult getActionResult() {
        return new PlacePalaceTile(value, getLocation(), getGameModel()).tryAction();
    }

    protected Pair<ActionResult, PlacePalaceTile> confirmPlacement(){
        PlacePalaceTile result = new PlacePalaceTile(value, getLocation(), getGameModel());
        return new Pair<ActionResult, PlacePalaceTile>(result.doAction(), result);
    }
}
