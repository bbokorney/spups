package controller.potentialuistates;

import controller.Controller;
import controller.history.TimeTraveler;
import controller.keylistener.Funktor;
import controller.keylistener.InternalListener;
import controller.keylistener.KeyListener;
import model.GameModel;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Baker on 4/14/2014.
 */
public class ReplayRoundUIState {
	private final int KEY_NEXT = KeyEvent.VK_RIGHT;
	private final int KEY_BACK = KeyEvent.VK_LEFT;
	private final int KEY_TIMED = KeyEvent.VK_TAB;

	private final long TIME_TO_WAIT = 3000; // Milliseconds

	Controller controller;
	KeyListener keyListener;
	GameModel model;
	TimeTraveler timeTraveler;

	public ReplayRoundUIState(Controller controller, KeyListener keyListener, GameModel model, TimeTraveler timeTraveler) {
		this.controller = controller;
		this.keyListener = keyListener;
		this.model = model;
		this.timeTraveler = timeTraveler;

		initListeners();
	}

	public void replayNextMove() {
		if(timeTraveler.hasNext()) timeTraveler.next();
	}

	public void unReplayMove() {
		timeTraveler.back();
	}

	public void replayRoundTimed() {
		while(timeTraveler.hasNext()) {
			try { Thread.sleep(TIME_TO_WAIT); }
			catch(InterruptedException e) { e.printStackTrace(); }
			timeTraveler.next();
		}
	}

	private void initListeners() {
		List<InternalListener> listeners = new ArrayList<InternalListener>();
		InternalListener i = new InternalListener(KEY_NEXT, new Funktor() {
			@Override
			public void call() {
				replayNextMove();
			}
		});
		listeners.add(i);

		i = new InternalListener(KEY_BACK, new Funktor() {
			@Override
			public void call() {
				unReplayMove();
			}
		});
		listeners.add(i);

		i = new InternalListener(KEY_TIMED, new Funktor() {
			@Override
			public void call() {
				replayRoundTimed();
			}
		});
		listeners.add(i);

		keyListener.replaceTemporaryListener(listeners);
	}
}
