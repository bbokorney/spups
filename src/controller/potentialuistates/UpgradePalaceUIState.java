package controller.potentialuistates;

import controller.Controller;
import controller.keylistener.Funktor;
import controller.keylistener.InternalListener;
import controller.keylistener.KeyListener;
import model.GameModel;
import model.Pair;
import model.actions.ActionResult;
import model.actions.tiles.UpgradePalaceTile;
import model.potentialactions.PotentialUpgradePalaceTile;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

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
        this.controller = controller;
        this.keyListener = keyListener;
        this.model = model;

	    potentialAction = new PotentialUpgradePalaceTile();

        initListeners();
    }

	public void switchPalaces() {
		ActionResult result = potentialAction.tabToNextPalace();
		send result to view
	}

	public void incValue() {
		int value = potentialAction.getValue();
		potentialAction.setValue((value >= 10) ? 10 : (value + 2) % 11);
		update view
	}

	public void decValue() {
		int value = potentialAction.getValue();
		potentialAction.setValue((value <= 2) ? 2 : value - 2);
		update view
	}

	public void confirmPlacement() {
		Pair<ActionResult, UpgradePalaceTile> actionPair = potentialAction.confirmUpgrade();
		ActionResult result = actionPair.getFirst();

		if(result.isSuccess()) {
			controller.addToHistory(actionPair);
		}
	}

	private void initListeners() {
		List<InternalListener> listeners = new ArrayList<InternalListener>();
		InternalListener i = new InternalListener(KEY_SWITCH, new Funktor() {
			@Override
			public void call() {
				moveNorth();
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

		keyListener.replaceTemporaryListener(listeners);
	}
}
