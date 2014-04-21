package controller.potentialuistates;

import controller.Controller;
import controller.keylistener.Funktor;
import controller.keylistener.InternalListener;
import controller.keylistener.KeyListener;
import model.GameModel;
import model.Pair;
import model.actions.Action;
import model.actions.ActionResult;
import model.actions.tiles.PlacePalaceTile;
import model.palacefestival.PalaceFestival;
import model.potentialactions.PotentialPlacePalaceTile;
import model.tiles.PalaceTileComponent;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Baker on 4/14/2014.
 */
public class PlacePalaceTileUIState extends PlaceOneSpaceTileUIState {
    private final int KEY_INCREMENT_LEVEL = KeyEvent.VK_UP;
    private final int KEY_DECREMENT_LEVEL = KeyEvent.VK_DOWN;

    private PotentialPlacePalaceTile potentialAction;

    public PlacePalaceTileUIState(Controller controller, KeyListener keyListener, GameModel model, PalaceFestival festival){
        super(controller, keyListener, model,
                new PalaceTileComponent(2));

	    potentialAction = new PotentialPlacePalaceTile(model, controller.getPalaceFestival(), 2);
        setPotentialAction(potentialAction);
    }

    private void incrementLevel() {
        potentialAction.incrementLevel();
        refreshView();
    }

    private void decrementLevel() {
        potentialAction.decrementLevel();
        refreshView();
    }

    private void refreshView() {
        setTileComponent(new PalaceTileComponent(potentialAction.getLevel()));
        updateView();
    }

    protected void initAdditonalListeners() {
        List<InternalListener> listeners = new ArrayList<InternalListener>();
        InternalListener i = new InternalListener(KEY_INCREMENT_LEVEL, new Funktor() {
            @Override
            public void call() {
                incrementLevel();
            }
        });
        listeners.add(i);
        i = new InternalListener(KEY_DECREMENT_LEVEL, new Funktor() {
            @Override
            public void call() {
                decrementLevel();
            }
        });
        listeners.add(i);

        getKeyListener().addTemporaryListeners(listeners);
    }
}
