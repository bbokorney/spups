package model.potentialactions;

import model.GameModel;
import model.Pair;
import model.actions.Action;
import model.actions.ActionResult;
import model.board.Directions;
import model.board.HexLocation;
import model.palacefestival.PalaceFestival;

import java.util.ArrayList;

/**
 * Created by idinamenzel on 4/15/14.
 */
public abstract class PotentialOneSpaceMovement extends PotentialAction implements HexComponentPotentialAction {

    /*
        If time permitted:
            Fix LOD issue with move methods game.getJavaBoard().areLocationsOnBoard(newLocation)
                to game.areLocationsOnBoard(newLocation)
     */

    private HexLocation location;

    public PotentialOneSpaceMovement(GameModel game, PalaceFestival festival){
        super(game, festival);
        location = new HexLocation(new ArrayList<Directions>());
    }

    @Override
    public ActionResult moveNorth() {
        HexLocation newLocation = location.getNeighbor(0);
        if (getGameModel().getBoard().areLocationsOnBoard(newLocation)) {
            location = newLocation;
        }
        return this.getActionResult();
    }

    @Override
    public ActionResult moveNortheast() {
        HexLocation newLocation = location.getNeighbor(1);
        if (getGameModel().getBoard().areLocationsOnBoard(newLocation)) {
            location = newLocation;
            //this.setComponentsOnHoverBoard();
        }
        return this.getActionResult();
    }

    @Override
    public ActionResult moveSoutheast() {
        HexLocation newLocation = location.getNeighbor(2);
        if (getGameModel().getBoard().areLocationsOnBoard(newLocation)) {
            location = newLocation;
            //this.setComponentsOnHoverBoard();
        }
        return this.getActionResult();
    }

    @Override
    public ActionResult moveSouth() {
        HexLocation newLocation = location.getNeighbor(3);
        if (getGameModel().getBoard().areLocationsOnBoard(newLocation)) {
            location = newLocation;
            //this.setComponentsOnHoverBoard();
        }

        return this.getActionResult();
    }

    @Override
    public ActionResult moveSouthwest() {
        HexLocation newLocation = location.getNeighbor(4);
        if (getGameModel().getBoard().areLocationsOnBoard(newLocation)) {
            location = newLocation;
            //this.setComponentsOnHoverBoard();
        }
        return this.getActionResult();
    }


    @Override
    public ActionResult moveNorthwest() {
        HexLocation newLocation = location.getNeighbor(5);
        if (getGameModel().getBoard().areLocationsOnBoard(newLocation)) {
            location = newLocation;
            //this.setComponentsOnHoverBoard();
        }
        return this.getActionResult();
    }

    public HexLocation getLocation(){
        return location;
    }

    public abstract Pair<ActionResult, Action> confirmAction();
}
