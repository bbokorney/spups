package model.potentialactions;

import model.GameModel;
import model.Pair;
import model.actions.ActionResult;
import model.actions.developer.TakeDeveloperOffBoard;
import model.board.Directions;
import model.board.HexLocation;
import model.board.Location;
import model.palacefestival.PalaceFestival;
import model.player.Developer;
import pathfinding.JavaPath;
import pathfinding.LeastCostPathFinder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Baker on 4/14/2014.
 */
public class PotentialTabThroughDevelopers extends PotentialAction {


    List<Location> developerLocationList;
    int indexOfCurrentDeveloper;

    public PotentialTabThroughDevelopers (GameModel game, PalaceFestival festival){
        super(game, festival);
        developerLocationList = game.getLocationsOfCurrentPlayersDevelopers();
        indexOfCurrentDeveloper = 0;
    }


    @Override
    public ActionResult getActionResult() {
        return new TakeDeveloperOffBoard(developerLocationList.get(indexOfCurrentDeveloper), getShortestLegalPath(), getGameModel()).tryAction();
    }

    public void tabToNextDeveloper(){
        indexOfCurrentDeveloper += 1;
        indexOfCurrentDeveloper %= developerLocationList.size();

    }

    /*
        This method below is a change from the design doc.
        It was functionality discussed in the responsibilities but was a method signature forgotten in the UML.
        This class is needed not to help OO design, but for the functionality of the game.
        A player, while tabbing through their developers, may then select a developer to move around the board,
        which requires a transition between this PotentialAction and the PotentialMoveDeveloperAroundBoard Action.
     */

    public PotentialMoveDeveloperAroundBoard selectDeveloperToMoveAroundBoard() {
        return new PotentialMoveDeveloperAroundBoard(getGameModel(), getPalaceFestival(),developerLocationList.get(indexOfCurrentDeveloper));
    }

    /*
        This method's return type has been changed, as many PotentialActions have due to
        the modification of ActionResult. At first, ActionResult had Action as an aggregate,
        which coupled them. We separated them to not force an ActionResult to have an Action.
        This change was for the OO purposes.
        To return both, the Pair class was implemented, taking these two as it's parameterizing types
     */
    public Pair<ActionResult, TakeDeveloperOffBoard> confirmDeletion() {
        TakeDeveloperOffBoard result = new TakeDeveloperOffBoard(developerLocationList.get(indexOfCurrentDeveloper), getShortestLegalPath(), getGameModel());
        return new Pair<ActionResult, TakeDeveloperOffBoard>(result.doAction(), result);
    }

    private JavaPath getShortestLegalPath(){
        LeastCostPathFinder pathFinder = new LeastCostPathFinder(getGameModel());
        return  pathFinder.findShortestRemovalPath(developerLocationList.get(indexOfCurrentDeveloper));

    }

	public List<Location> getLocationFromPath() {
		//Todo Meghan: please check this
        //return null;

        Location loc = developerLocationList.get(indexOfCurrentDeveloper);
        ArrayList<Location> list = new ArrayList<Location>();
        list.add(loc);
        return list;
	}
}
