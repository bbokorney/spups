package model.potentialactions;

import model.GameModel;
import model.Pair;
import model.actions.Action;
import model.actions.ActionResult;
import model.actions.developer.MoveDeveloperAroundBoard;
import model.actions.tiles.PlaceVillageTile;
import model.board.Directions;
import model.board.HexLocation;
import model.board.Location;
import model.palacefestival.PalaceFestival;
import pathfinding.JavaPath;
import pathfinding.LeastCostPathFinder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by idinamenzel on 4/14/2014.
 */
public class PotentialMoveDeveloperAroundBoard extends PotentialOneSpaceMovement {

    Location developerStartingLocation;

    // TODO: Baker, this needs to expose the shortest path
    public PotentialMoveDeveloperAroundBoard(GameModel game, PalaceFestival festival, Location location){
        super(game, festival);
        this.developerStartingLocation = location;
        setLocation(location);
    }

    public JavaPath getShortestLegalPath(){
        LeastCostPathFinder pathFinder = new LeastCostPathFinder(getGameModel());
        return  pathFinder.findShortestPath(developerStartingLocation, getLocation());

    }


    @Override
    public ActionResult getActionResult() {
        return new MoveDeveloperAroundBoard(developerStartingLocation, getLocation(), getShortestLegalPath(), getGameModel()).tryAction();
    }


    public Pair<ActionResult, MoveDeveloperAroundBoard> confirmMovement() {
        MoveDeveloperAroundBoard result = new MoveDeveloperAroundBoard(developerStartingLocation, getLocation(), getShortestLegalPath(), getGameModel());
        return new Pair<ActionResult, MoveDeveloperAroundBoard>(result.doAction(), result);
    }

    public List<Location> getLocationFromPath() {
        //Todo Meghan, please check
        //return null;
        ArrayList<Location> list = new ArrayList<Location>();
        list.add(developerStartingLocation);
        return list;
    }

    public Pair<ActionResult, Action> confirmAction(){
        return null;
//        PlaceVillageTile result = new MoveDeveloperAroundBoard(getLocation(), getGameModel() );
//        return new Pair<ActionResult, Action>(result.doAction(), result);
    }

}
