package controller.potentialuistates;

import controller.Controller;
import controller.keylistener.KeyListener;
import model.GameModel;
import model.board.Location;
import model.potentialactions.PotentialOneSpaceMovement;
import model.tiles.TileComponent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Baker on 4/21/2014.
 */
public class PlaceSingleTileUIState extends HexComponentMovementUIState {
    private PotentialOneSpaceMovement potentialAction;
    private TileComponent component;
    public PlaceSingleTileUIState(Controller controller, KeyListener keyListener, GameModel model,
                                  TileComponent component, PotentialOneSpaceMovement potentialAction) {
        super(controller, keyListener, model, potentialAction);
        this.component = component;
        this.potentialAction = potentialAction;
        setPotentialAction(potentialAction);
    }

    public PlaceSingleTileUIState(Controller controller, KeyListener keyListener, GameModel model,
                                  TileComponent component) {
        super(controller, keyListener, model);
        this.component = component;
    }

    protected void setOneSpacePotentialAction(PotentialOneSpaceMovement potentialAction) {
        this.potentialAction = potentialAction;
    }

    protected void setTileComponent(TileComponent component) { this.component = component; }

    @Override
    protected Map<Location, TileComponent> getBoardComponents() {
        Map<Location, TileComponent> hoverComponents = new HashMap<Location, TileComponent>();
        hoverComponents.put(potentialAction.getLocation(), component);
        return hoverComponents;
    }

    @Override
    protected List<Location> getHighlightedLocations() {
        List<Location> highlighted = new ArrayList<Location>();
        highlighted.add(potentialAction.getLocation());
        return highlighted;
    }
}
