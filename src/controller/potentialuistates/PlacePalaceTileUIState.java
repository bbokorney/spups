package controller.potentialuistates;

import controller.Controller;
import controller.keylistener.Funktor;
import controller.keylistener.InternalListener;
import controller.keylistener.KeyListener;
import model.GameModel;
import model.Pair;
import model.actions.ActionResult;
import model.actions.tiles.PlacePalaceTile;
import model.potentialactions.PotentialPlacePalaceTile;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Baker on 4/14/2014.
 */
public class PlacePalaceTileUIState extends GameplayUIState {
	private final int KEY_NORTH = KeyEvent.VK_NUMPAD8;
	private final int KEY_SOUTH = KeyEvent.VK_NUMPAD2;
	private final int KEY_NORTHEAST = KeyEvent.VK_NUMPAD9;
	private final int KEY_SOUTHEAST = KeyEvent.VK_NUMPAD3;
	private final int KEY_NORTHWEST = KeyEvent.VK_NUMPAD7;
	private final int KEY_SOUTHWEST = KeyEvent.VK_NUMPAD1;

	private final int KEY_CONFIRM = KeyEvent.VK_ENTER;
	private final int KEY_INCVALUE = KeyEvent.VK_UP;
	private final int KEY_DECVALUE = KeyEvent.VK_DOWN;

	Controller controller;
    KeyListener keyListener;
    GameModel model;

	PotentialPlacePalaceTile potentialAction;

    public PlacePalaceTileUIState(Controller controller, KeyListener keyListener, GameModel model){
        this.controller = controller;
        this.keyListener = keyListener;
        this.model = model;

	    potentialAction = new PotentialPlacePalaceTile(model, 2);

        initListeners();
    }

	public void moveNorth() {
		ActionResult result = potentialAction.moveNorth();
		if(!result.isSuccess()) {

		}
	}

	public void moveSouth() {
		ActionResult result = potentialAction.moveSouth();
		if(!result.isSuccess()) {

		}
	}

	public void moveNortheast() {
		ActionResult result = potentialAction.moveNortheast();
		if(!result.isSuccess()) {

		}
	}

	public void moveNorthwest() {
		ActionResult result = potentialAction.moveNorthwest();
		if(!result.isSuccess()) {

		}
	}

	public void moveSoutheast() {
		ActionResult result = potentialAction.moveSoutheast();
		if(!result.isSuccess()) {

		}
	}

	public void moveSouthwest() {
		ActionResult result = potentialAction.moveSouthwest();
		if(!result.isSuccess()) {

		}
	}

	public void incValue() {
		int value = potentialAction.getValue();
		potentialAction.setValue((value >= 10) ? 10 : (value + 2) % 11);
	}

	public void decValue() {
		int value = potentialAction.getValue();
		potentialAction.setValue((value <= 2) ? 2 : value - 2);
	}

	public void confirmPlacement() {
		Pair<ActionResult, PlacePalaceTile> actionPair = potentialAction.confirmPlacement();
		ActionResult result = actionPair.getFirst();

		if(result.isSuccess()) {
			controller.addToHistory(actionPair);
		}
	}

	private void initListeners() {
		List<InternalListener> listeners = new ArrayList<InternalListener>();
		InternalListener i = new InternalListener(KEY_NORTH, new Funktor() {
			@Override
			public void call() {
				moveNorth();
			}
		});
		listeners.add(i);

		i = new InternalListener(KEY_SOUTH, new Funktor() {
			@Override
			public void call() {
				moveSouth();
			}
		});
		listeners.add(i);

		i = new InternalListener(KEY_NORTHWEST, new Funktor() {
			@Override
			public void call() {
				moveNorthwest();
			}
		});
		listeners.add(i);

		i = new InternalListener(KEY_NORTHEAST, new Funktor() {
			@Override
			public void call() {
				moveNortheast();
			}
		});
		listeners.add(i);

		i = new InternalListener(KEY_SOUTHWEST, new Funktor() {
			@Override
			public void call() {
				moveSoutheast();
			}
		});
		listeners.add(i);

		i = new InternalListener(KEY_SOUTHEAST, new Funktor() {
			@Override
			public void call() {
				moveSouthwest();
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
