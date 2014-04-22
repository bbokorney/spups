package controller.potentialuistates;

import controller.Controller;
import controller.keylistener.KeyListener;
import model.GameModel;
import model.palacefestival.PalaceFestival;
import model.potentialactions.PotentialPlaceRiceTile;
import model.tiles.RiceTileComponent;

/**
 * Created by Baker on 4/14/2014.
 */
public class PlaceRiceTileUIState extends PlaceSingleTileUIState {
    public PlaceRiceTileUIState(Controller controller, KeyListener keyListener, GameModel model, PalaceFestival festival) {
        super(controller, keyListener, model, new RiceTileComponent(), new PotentialPlaceRiceTile(model, festival));
    }
}
