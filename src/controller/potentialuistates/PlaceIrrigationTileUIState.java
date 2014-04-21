package controller.potentialuistates;

import controller.Controller;
import controller.keylistener.Funktor;
import controller.keylistener.InternalListener;
import controller.keylistener.KeyListener;
import model.GameModel;
import model.Pair;
import model.actions.Action;
import model.actions.ActionResult;
import model.palacefestival.PalaceFestival;
import model.potentialactions.PotentialPlaceIrrigationTile;
import model.tiles.IrrigationTileComponent;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Baker on 4/14/2014.
 */
public class PlaceIrrigationTileUIState extends PlaceOneSpaceTileUIState {
    public PlaceIrrigationTileUIState(Controller controller,
                                      KeyListener keyListener, GameModel model, PalaceFestival festival){
        super(controller, keyListener, model,
                new IrrigationTileComponent(), new PotentialPlaceIrrigationTile(model, festival));
    }

}
