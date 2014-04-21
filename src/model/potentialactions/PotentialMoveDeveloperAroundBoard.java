package model.potentialactions;

import model.GameModel;
import model.Pair;
import model.actions.ActionResult;
import model.actions.developer.MoveDeveloperAroundBoard;
import model.board.Location;
import model.palacefestival.PalaceFestival;
import pathfinding.JavaPath;
import pathfinding.LeastCostPathFinder;

import java.util.List;

/**
 * Created by idinamenzel on 4/14/2014.
 */
public class PotentialMoveDeveloperAroundBoard extends PotentialOneSpaceMovement {

    Location developerStartingLocation;


    public PotentialMoveDeveloperAroundBoard(GameModel game, PalaceFestival festival, Location location){
        super(game, festival);
        this.developerStartingLocation = location;
    }

    private JavaPath getShortestLegalPath(){
        return  new LeastCostPathFinder().findShortestPath(developerStartingLocation, getLocation(), getGameModel().getCurrentJavaPlayer(), getGameModel().getBoard());

    }


    @Override
    public ActionResult getActionResult() {
        return new MoveDeveloperAroundBoard(developerStartingLocation, getShortestLegalPath(), getGameModel()).tryAction();
    }


    public Pair<ActionResult, MoveDeveloperAroundBoard> confirmMovement() {
        MoveDeveloperAroundBoard result = new MoveDeveloperAroundBoard(developerStartingLocation, getShortestLegalPath(), getGameModel());
        return new Pair<ActionResult, MoveDeveloperAroundBoard>(result.doAction(), result);
    }

    public List<Location> getLocationFromPath() {
        //Todo Meghan
        return null;
    }

}
