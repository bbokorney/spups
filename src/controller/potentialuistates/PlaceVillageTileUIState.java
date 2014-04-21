package controller.potentialuistates;

import controller.Controller;
import controller.keylistener.Funktor;
import controller.keylistener.InternalListener;
import controller.keylistener.KeyListener;
import model.GameModel;
import model.Pair;
import model.actions.ActionResult;
import model.actions.tiles.PlaceVillageTile;
import model.palacefestival.PalaceFestival;
import model.potentialactions.PotentialPlaceVillageTile;
import model.tiles.VillageTileComponent;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Baker on 4/14/2014.
 */
public class PlaceVillageTileUIState extends PlaceOneSpaceTilUIState {

	PotentialPlaceVillageTile potentialAction;

    public PlaceVillageTileUIState(Controller controller, KeyListener keyListener, GameModel model, PalaceFestival festival){
        super(controller, keyListener, model, new VillageTileComponent(), new PotentialPlaceVillageTile(model, festival));
    }
}
