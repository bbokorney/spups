package model.potentialactions;

import model.GameModel;
import model.Pair;
import model.actions.Action;
import model.actions.ActionResult;
import model.board.Directions;
import model.board.HexLocation;
import model.board.Location;
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

    private Location location;

    public PotentialOneSpaceMovement(GameModel game, PalaceFestival festival){
        super(game, festival);
        location = new HexLocation(new ArrayList<Directions>());
    }

    @Override
    public ActionResult moveNorth() {
        Location newLocation = location.getNeighbors().get(0);
        if (getGameModel().getBoard().areLocationsOnBoard(newLocation)) {
            location = newLocation;
        }
        return this.getActionResult();
    }

    @Override
    public ActionResult moveNortheast() {
        Location newLocation = location.getNeighbors().get(1);
        if (getGameModel().getBoard().areLocationsOnBoard(newLocation)) {
            location = newLocation;
            //this.setComponentsOnHoverBoard();
        }
        return this.getActionResult();
    }

    @Override
    public ActionResult moveSoutheast() {
        Location newLocation = location.getNeighbors().get(2);
        if (getGameModel().getBoard().areLocationsOnBoard(newLocation)) {
            location = newLocation;
            //this.setComponentsOnHoverBoard();
        }
        return this.getActionResult();
    }

    @Override
    public ActionResult moveSouth() {
        Location newLocation = location.getNeighbors().get(3);
        if (getGameModel().getBoard().areLocationsOnBoard(newLocation)) {
            location = newLocation;
            //this.setComponentsOnHoverBoard();
        }

        return this.getActionResult();
    }

    @Override
    public ActionResult moveSouthwest() {
        Location newLocation = location.getNeighbors().get(4);
        if (getGameModel().getBoard().areLocationsOnBoard(newLocation)) {
            location = newLocation;
            //this.setComponentsOnHoverBoard();
        }
        return this.getActionResult();
    }


    @Override
    public ActionResult moveNorthwest() {
        Location newLocation = location.getNeighbors().get(5);
        if (getGameModel().getBoard().areLocationsOnBoard(newLocation)) {
            location = newLocation;
            //this.setComponentsOnHoverBoard();
        }
        return this.getActionResult();
    }

    public Location getLocation(){
        return location;
    }

    public abstract Pair<ActionResult, Action> confirmAction();

    protected void setLocation(Location loc) {
        location = loc;
    }
}
