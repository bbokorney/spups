package model.potentialactions;

import model.GameModel;
import model.Pair;
import model.actions.ActionResult;
import model.actions.developer.MoveDeveloperAroundBoard;
import model.board.HexLocation;
import pathfinding.JavaPath;
import pathfinding.LeastCostPathFinder;

/**
 * Created by idinamenzel on 4/14/2014.
 */
public class PotentialMoveDeveloperAroundBoard extends PotentialOneSpaceMovement {

    HexLocation developerStartingLocation;


    public PotentialMoveDeveloperAroundBoard(GameModel game){

        super(game);
    }

    private JavaPath getShortestLegalPath(){
        return  new LeastCostPathFinder().findShortestPath(developerStartingLocation, getLocation(), game.getCurrentJavaPlayer(), game.getBoard());

    }

    @Override
    public void setComponentsOnHoverBoard() {

        hoverBoard.reset();
        //hoverBoard.placeTileComponent(getLocation(), null, ActionState.valueOf());

    }

    @Override
    protected ActionResult getActionResult() {
        return new MoveDeveloperAroundBoard(developerStartingLocation, getShortestLegalPath(), game).tryAction();
    }


    protected Pair<ActionResult, MoveDeveloperAroundBoard> confirmMovement() {
        MoveDeveloperAroundBoard result = new MoveDeveloperAroundBoard(developerStartingLocation, getShortestLegalPath(), game);
        return new Pair<ActionResult, MoveDeveloperAroundBoard>(result.doAction(), result);
    }

}
