package controller.potentialuistates;

import controller.Controller;
import controller.keylistener.Funktor;
import controller.keylistener.InternalListener;
import controller.keylistener.KeyListener;
import model.GameModel;
import model.palacefestival.PalaceFestival;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Baker on 4/14/2014.
 */
public abstract class GameplayUIState extends PotentialJavaUIState{
	private final int KEY_EMPTYSTATE = KeyEvent.VK_ESCAPE;

    Controller controller;
    KeyListener keyListener;
	GameModel model;
    PalaceFestival festival;

	public GameplayUIState(Controller controller, KeyListener keyListener, GameModel model) {
		this.controller = controller;
		this.keyListener = keyListener;
		this.model = model;
		festival = controller.getPalaceFestival();
		setEmptyListener();
	}

    public void switchToEmptyState() {
	    controller.refreshGameView();
		controller.setCurrentState(new EmptyUIState(controller, keyListener, model, festival));
    }

	public void setEmptyListener() {
		List<InternalListener> listeners = new ArrayList<InternalListener>();
		InternalListener i = new InternalListener(KEY_EMPTYSTATE, new Funktor() {
			@Override
			public void call() {
				switchToEmptyState();
			}
		});
		listeners.add(i);

		keyListener.replaceTemporaryListener(listeners);
	}
}
