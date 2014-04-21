package controller.potentialuistates;

import controller.Controller;
import controller.keylistener.Funktor;
import controller.keylistener.InternalListener;
import controller.keylistener.KeyListener;
import model.GameModel;
import model.Pair;
import model.actions.ActionResult;
import model.actions.tiles.PlaceRiceTile;
import model.board.Location;
import model.palacefestival.PalaceFestival;
import model.potentialactions.PotentialAction;
import model.potentialactions.PotentialPlaceRiceTile;
import model.tiles.RiceTileComponent;
import model.tiles.Tile;
import model.tiles.TileComponent;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Baker on 4/14/2014.
 */
public class PlaceRiceTileUIState extends PlaceOneSpaceTilUIState {
    public PlaceRiceTileUIState(Controller controller, KeyListener keyListener, GameModel model, PalaceFestival festival) {
        super(controller, keyListener, model, new RiceTileComponent(), new PotentialPlaceRiceTile(model, festival));
    }
}
