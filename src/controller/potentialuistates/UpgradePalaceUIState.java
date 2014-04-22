package controller.potentialuistates;

import controller.Controller;
import controller.keylistener.Funktor;
import controller.keylistener.InternalListener;
import controller.keylistener.KeyListener;
import model.GameModel;
import model.Pair;
import model.actions.ActionResult;
import model.actions.tiles.UpgradePalaceTile;
import model.board.Location;
import model.potentialactions.PotentialUpgradePalaceTile;
import model.tiles.PalaceTileComponent;
import model.tiles.TileComponent;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Baker on 4/14/2014.
 */
public class UpgradePalaceUIState extends GameplayUIState {
	private final int KEY_SWITCH = KeyEvent.VK_TAB;
	private final int KEY_CONFIRM = KeyEvent.VK_ENTER;
	private final int KEY_INCVALUE = KeyEvent.VK_UP;
	private final int KEY_DECVALUE = KeyEvent.VK_DOWN;

    Controller controller;
    KeyListener keyListener;
    GameModel model;

	PotentialUpgradePalaceTile potentialAction;

    public UpgradePalaceUIState(Controller controller, KeyListener keyListener, GameModel model){
	    super(controller, keyListener, model);
        this.controller = controller;
        this.keyListener = keyListener;
        this.model = model;

	    potentialAction = new PotentialUpgradePalaceTile(model, controller.getPalaceFestival());

        updateView();
        initListeners();
    }

	public void switchPalaces() {
		potentialAction.tabToNextPalace();
		updateView();
	}

	public void incValue() {
		potentialAction.incrementLevel();
        updateView();
	}

	public void decValue() {
		potentialAction.decrementLevel();
		updateView();
	}

    private void updateView() {
        Map<Location, TileComponent> componentMap = new HashMap<Location, TileComponent>();
        componentMap.put(potentialAction.getLocation(), new PalaceTileComponent(potentialAction.getLevel()));
        List<Location> highlight = new ArrayList<Location>();
        highlight.add(potentialAction.getLocation());
        controller.refreshGameView(potentialAction.getActionResult(), componentMap, highlight);
    }

	public void confirmPlacement() {
		Pair<ActionResult, UpgradePalaceTile> actionPair = potentialAction.chooseCurrentPlaceToUpgrade();
		ActionResult result = actionPair.getFirst();

		if(result.isSuccess()) {
			controller.addToHistory(actionPair);
			controller.goToEmptyState();
		}
	}

	private void initListeners() {
		List<InternalListener> listeners = new ArrayList<InternalListener>();
		InternalListener i = new InternalListener(KEY_SWITCH, new Funktor() {
			@Override
			public void call() {
				switchPalaces();
			}
		});
		listeners.add(i);

		i = new InternalListener(KEY_INCVALUE, new Funktor() {
			@Override
			public void call() {
				incValue();
			}
		});
		listeners.add(i);

		i = new InternalListener(KEY_DECVALUE, new Funktor() {
			@Override
			public void call() {
				decValue();
			}
		});
		listeners.add(i);

		i = new InternalListener(KEY_CONFIRM, new Funktor() {
			@Override
			public void call() {
				confirmPlacement();
			}
		});
		listeners.add(i);

		keyListener.addTemporaryListeners(listeners);
	}
}
