package controller.potentialuistates;

import controller.Controller;
import controller.keylistener.KeyListener;
import model.GameModel;
import model.palacefestival.PalaceFestival;
import model.potentialactions.PotentialPlaceVillageTile;
import model.tiles.VillageTileComponent;

/**
 * Created by Baker on 4/14/2014.
 */
public class PlaceVillageTileUIState extends PlaceOneSpaceTileUIState {

	PotentialPlaceVillageTile potentialAction;

    public PlaceVillageTileUIState(Controller controller, KeyListener keyListener, GameModel model, PalaceFestival festival){
        super(controller, keyListener, model, new VillageTileComponent(), new PotentialPlaceVillageTile(model, festival));
    }
}
