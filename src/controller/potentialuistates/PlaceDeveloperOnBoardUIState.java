package controller.potentialuistates;

import controller.Controller;
import controller.keylistener.Funktor;
import controller.keylistener.InternalListener;
import controller.keylistener.KeyListener;
import model.GameModel;
import model.Pair;
import model.actions.Action;
import model.actions.ActionResult;
import model.actions.developer.PlaceDeveloperOnBoard;
import model.board.Location;
import model.potentialactions.PotentialPlaceDeveloperOnBoard;
import model.tiles.TileComponent;
import pathfinding.JavaPath;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Baker on 4/14/2014.
 */
public class PlaceDeveloperOnBoardUIState extends HexComponentMovementUIState {
	PotentialPlaceDeveloperOnBoard potentialAction;

    public PlaceDeveloperOnBoardUIState(Controller controller, KeyListener keyListener, GameModel model){
	    super(controller, keyListener, model);
        System.out.println("Constructor of the PlaceDeveloperOnBoardUIState");
        potentialAction = new PotentialPlaceDeveloperOnBoard(model, controller.getPalaceFestival());
        setPotentialAction(potentialAction);
    }

    @Override
    protected Map<Location, TileComponent> getBoardComponents() {
        return new HashMap<Location, TileComponent>();
    }

    @Override
    protected List<Location> getHighlightedLocations() {
        // always highlight the destination, regardless of whether
        // a path to that location exists or not
        List<Location> highlighted = new ArrayList<Location>();
        highlighted.add(potentialAction.getLocation());
        JavaPath path = potentialAction.getShortestLegalPath();
        if(path != null) {
            highlighted.addAll(potentialAction.getShortestLegalPath().getPath());
        }
        return highlighted;
    }
}
