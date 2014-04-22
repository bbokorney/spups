package controller.potentialuistates;

import controller.Controller;
import controller.keylistener.Funktor;
import controller.keylistener.InternalListener;
import controller.keylistener.KeyListener;
import model.GameModel;
import model.Pair;
import model.actions.Action;
import model.actions.ActionResult;
import model.actions.developer.PlaceDeveloperOnBoard;
import model.board.Location;
import model.potentialactions.PotentialPlaceDeveloperOnBoard;
import model.tiles.TileComponent;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Baker on 4/14/2014.
 */
public class PlaceDeveloperOnBoardUIState extends GameplayUIState {
	private final int KEY_NORTH = KeyEvent.VK_NUMPAD8;
	private final int KEY_SOUTH = KeyEvent.VK_NUMPAD2;
	private final int KEY_NORTHEAST = KeyEvent.VK_NUMPAD9;
	private final int KEY_SOUTHEAST = KeyEvent.VK_NUMPAD1;
	private final int KEY_NORTHWEST = KeyEvent.VK_NUMPAD7;
	private final int KEY_SOUTHWEST = KeyEvent.VK_NUMPAD3;

	private final int KEY_CONFIRM = KeyEvent.VK_ENTER;

    Controller controller;
    KeyListener keyListener;
    GameModel model;

	PotentialPlaceDeveloperOnBoard potentialAction;

    public PlaceDeveloperOnBoardUIState(Controller controller, KeyListener keyListener, GameModel model){
	    super(controller, keyListener, model);
        this.controller = controller;
        this.keyListener = keyListener;
        this.model = model;

	    potentialAction = new PotentialPlaceDeveloperOnBoard(model, controller.getPalaceFestival());

        initListeners();
    }

	public void moveNorth() {
		ActionResult result = potentialAction.moveNorth();
		updateView(result, potentialAction.getLocationFromPath());
	}

	public void moveSouth() {
		ActionResult result = potentialAction.moveSouth();
		updateView(result, potentialAction.getLocationFromPath());
	}

	public void moveNortheast() {
		ActionResult result = potentialAction.moveNortheast();
		updateView(result, potentialAction.getLocationFromPath());
	}

	public void moveNorthwest() {
		ActionResult result = potentialAction.moveNorthwest();
		updateView(result, potentialAction.getLocationFromPath());
	}

	public void moveSoutheast() {
		ActionResult result = potentialAction.moveSoutheast();
		updateView(result, potentialAction.getLocationFromPath());
	}

	public void moveSouthwest() {
		ActionResult result = potentialAction.moveSouthwest();
		updateView(result, potentialAction.getLocationFromPath());
	}

	public void confirmPlacement() {
		Pair<ActionResult, Action> actionPair = potentialAction.confirmAction();
		ActionResult result = actionPair.getFirst();
		updateView(result, potentialAction.getLocationFromPath());

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

		i = new InternalListener(KEY_CONFIRM, new Funktor() {
			@Override
			public void call() {
				confirmPlacement();
			}
		});
		listeners.add(i);

		keyListener.addTemporaryListeners(listeners);
	}

	private void updateView(ActionResult result, List<Location> list) {
		controller.refreshGameView(result, new HashMap<Location, TileComponent>(), list);
	}
}
