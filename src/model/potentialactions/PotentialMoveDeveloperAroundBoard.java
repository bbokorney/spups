package model.potentialactions;

import model.JavaGameModel;
import model.board.HexLocation;
import pathfinding.JavaPath;
import pathfinding.LeastCostPathFinder;

/**
 * Created by idinamenzel on 4/14/2014.
 */
public class PotentialMoveDeveloperAroundBoard extends PotentialOneSpaceMovement {

    HexLocation developerStartingLocation;


    public PotentialMoveDeveloperAroundBoard(JavaGameModel game){
        super(game);
    }

    private JavaPath getShortestLegalPath(){
        return  new LeastCostPathFinder().findShortestPath(developerStartingLocation, location, game.getCurrentPlayer(), game.getJavaBoard());

    }

    @Override
    public void setHoverBoard() {
        hoverBoard.reset();

    }

}
