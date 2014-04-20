package controller.potentialuistates;

import controller.Controller;
import controller.history.TimeTraveler;
import controller.keylistener.KeyListener;
import model.GameModel;

/**
 * Created by Baker on 4/14/2014.
 */
public class ReplayRoundUIState {
	private final int KEY_NEXT

	Controller controller;
	KeyListener keyListener;
	GameModel model;
	TimeTraveler timeTraveler;

	public ReplayRoundUIState(Controller controller, KeyListener keyListener, GameModel model, TimeTraveler timeTraveler) {
		this.controller = controller;
		this.keyListener = keyListener;
		this.model = model;
		this.timeTraveler = timeTraveler;
	}


}
