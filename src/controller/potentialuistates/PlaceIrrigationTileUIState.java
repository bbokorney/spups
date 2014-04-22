package controller.potentialuistates;

import controller.Controller;
import controller.keylistener.KeyListener;
import model.GameModel;
import model.palacefestival.PalaceFestival;
import model.potentialactions.PotentialPlaceIrrigationTile;
import model.tiles.IrrigationTileComponent;

/**
 * Created by Baker on 4/14/2014.
 */
public class PlaceIrrigationTileUIState extends PlaceSingleTileUIState {
    public PlaceIrrigationTileUIState(Controller controller,
                                      KeyListener keyListener, GameModel model, PalaceFestival festival){
        super(controller, keyListener, model,
                new IrrigationTileComponent(), new PotentialPlaceIrrigationTile(model, festival));
    }

}
