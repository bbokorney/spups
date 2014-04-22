package controller.potentialuistates;

import controller.Controller;
import controller.keylistener.Funktor;
import controller.keylistener.InternalListener;
import controller.keylistener.KeyListener;
import model.GameModel;
import model.Pair;
import model.actions.Action;
import model.actions.ActionResult;
import model.actions.tiles.PlaceRiceTile;
import model.actions.tiles.PlaceThreeSpaceTile;
import model.board.Location;
import model.potentialactions.PotentialJavaThreeSpaceTile;
import model.potentialactions.PotentialPlaceRiceTile;
import model.tiles.RiceTileComponent;
import model.tiles.Tile;
import model.tiles.TileComponent;
import model.tiles.VillageTileComponent;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Baker on 4/14/2014.
 */
public class PlaceThreeSpaceTileUIState extends RotateableHexComponentUIState {

	PotentialJavaThreeSpaceTile potentialAction;

    public PlaceThreeSpaceTileUIState(Controller controller, KeyListener keyListener, GameModel model){
	    super(controller, keyListener, model);

	    potentialAction = new PotentialJavaThreeSpaceTile(model, controller.getPalaceFestival());
        setPotentialAction(potentialAction);
        setRotatablePotentialAction(potentialAction);
    }

    @Override
    protected Map<Location, TileComponent> getBoardComponents() {
        Map<Location, TileComponent> boardComponents = new HashMap<Location, TileComponent>();
        boardComponents.put(potentialAction.getCenterLocation(), new VillageTileComponent());
        boardComponents.put(potentialAction.getOtherLocation(0), new RiceTileComponent());
        boardComponents.put(potentialAction.getOtherLocation(1), new RiceTileComponent());
        return boardComponents;
    }

    @Override
    protected List<Location> getHighlightedLocations() {
        List<Location> highlighted = new ArrayList<Location>();
        highlighted.add(potentialAction.getCenterLocation());
        highlighted.add(potentialAction.getOtherLocation(0));
        highlighted.add(potentialAction.getOtherLocation(1));
        return highlighted;
    }
}
