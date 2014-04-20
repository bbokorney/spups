package model.potentialactions;

import model.GameModel;
import model.Pair;
import model.actions.ActionResult;
import model.actions.developer.PlaceDeveloperOnBoard;
import model.palacefestival.PalaceFestival;
import pathfinding.JavaPath;
import pathfinding.LeastCostPathFinder;

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

    public Pair<ActionResult, PlaceDeveloperOnBoard> confirmMovement() {
        PlaceDeveloperOnBoard result = new PlaceDeveloperOnBoard(getLocation(), getShortestLegalPath(), getGameModel());
        return new Pair<ActionResult, PlaceDeveloperOnBoard>(result.doAction(), result);
    }

    private JavaPath getShortestLegalPath(){
        return  new LeastCostPathFinder().findShortestPlacementPath(getLocation(), getGameModel().getCurrentJavaPlayer(), getGameModel().getBoard());

    }



}
