package controller.potentialuistates;

import controller.Controller;
import controller.keylistener.Funktor;
import controller.keylistener.InternalListener;
import controller.keylistener.KeyListener;
import model.GameModel;
import model.Pair;
import model.actions.ActionResult;
import model.actions.developer.TakeDeveloperOffBoard;
import model.player.Developer;
import model.potentialactions.PotentialTabThroughDevelopers;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Baker on 4/14/2014.
 */
public class TabThroughDeveloperUIState extends GameplayUIState {
	private final int KEY_SWITCH = KeyEvent.VK_TAB;
	private final int KEY_MOVE = KeyEvent.VK_ENTER;
	private final int KEY_REMOVE = KeyEvent.VK_DELETE;

    Controller controller;
    KeyListener keyListener;
    GameModel model;

	PotentialTabThroughDevelopers potentialAction;

    public TabThroughDeveloperUIState(Controller controller, KeyListener keyListener, GameModel model){
        this.controller = controller;
        this.keyListener = keyListener;
        this.model = model;

	    potentialAction = new PotentialTabThroughDevelopers();

        initListeners();
    }

	public void switchDeveloper() {
		ActionResult result = potentialAction.getLocationFromPath();
		if(!result.isSuccess()) {

		}
	}

	public void switchToMoveDeveloperState() {
		Developer developer = potentialAction.getSelectedDeveloper();
		if(developer instanceof Developer) {
			controller.setCurrentState(new MoveDeveloperAroundBoardUIState(controller, keyListener, model, developer));
		}
	}

	public void confirmDeletion() {
		Pair<ActionResult, TakeDeveloperOffBoard> actionPair = potentialAction.confirmDeletion();
		ActionResult result = actionPair.getFirst();

		if(result.isSuccess()) {
			controller.addToHistory(actionPair);
			stuff?
		}
	}

	private void initListeners() {
		List<InternalListener> listeners = new ArrayList<InternalListener>();
		InternalListener i = new InternalListener(KEY_SWITCH, new Funktor() {
			@Override
			public void call() {
				switchDeveloper();
			}
		});
		listeners.add(i);

		i = new InternalListener(KEY_MOVE, new Funktor() {
			@Override
			public void call() {
				switchToMoveDeveloperState();
			}
		});
		listeners.add(i);

		i = new InternalListener(KEY_REMOVE, new Funktor() {
			@Override
			public void call() {
				confirmDeletion();
			}
		});
		listeners.add(i);

		keyListener.replaceTemporaryListener(listeners);
	}
}
