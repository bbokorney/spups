package model.potentialactions;

import model.GameModel;
import model.Pair;
import model.actions.Action;
import model.actions.ActionResult;
import model.actions.developer.PlaceDeveloperOnBoard;
import model.board.Location;
import model.palacefestival.PalaceFestival;
import pathfinding.JavaPath;
import pathfinding.LeastCostPathFinder;

import java.util.List;

/**
 * Created by Baker on 4/14/2014.
 */
public class PotentialPlaceDeveloperOnBoard extends PotentialOneSpaceMovement {

    public PotentialPlaceDeveloperOnBoard (GameModel game, PalaceFestival festival){
        super(game, festival);
    }


    @Override
    public ActionResult getActionResult() {

        return new PlaceDeveloperOnBoard(getLocation(), getShortestLegalPath(), getGameModel()).tryAction();
    }

    /*
       This method's return type has been changed, as many PotentialActions have due to
       the modification of ActionResult. At first, ActionResult had Action as an aggregate,
       which coupled them. We separated them to not force an ActionResult to have an Action.
       This change was for the OO purposes.
       To return both, the Pair class was implemented, taking these two as it's parameterizing types
    */
    public Pair<ActionResult, Action> confirmAction() {
        PlaceDeveloperOnBoard result = new PlaceDeveloperOnBoard(getLocation(), getShortestLegalPath(), getGameModel());
        return new Pair<ActionResult, Action>(result.doAction(), result);
    }

    private JavaPath getShortestLegalPath(){
        LeastCostPathFinder pathFinder = new LeastCostPathFinder(getGameModel());
        return pathFinder.findShortestPlacementPath(getLocation());

    }

    public List<Location> getLocationFromPath() {
        //Todo Meghan
        return null;
    }



}
