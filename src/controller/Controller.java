package controller;

import controller.history.History;
import controller.history.TimeTraveler;
import controller.keylistener.KeyListener;
import controller.potentialuistates.EmptyUIState;
import controller.potentialuistates.PotentialJavaUIState;
import model.GameModel;
import model.Pair;
import model.actions.Action;
import view.GameFrame;

/**
 * Created by Baker on 4/14/2014.
 */
public class Controller {
    History history;
    KeyListener keyListener;
    GameFrame view;
    GameModel model;

    PotentialJavaUIState currentState;

	public Controller(GameFrame view, GameModel model) {
		this.view = view;
        this.model = model;
        keyListener = new KeyListener();

        currentState = new EmptyUIState(this, keyListener, model);
	}

    public void setCurrentState(PotentialJavaUIState newState) {
        this.currentState = newState;
    }

    public void addToHistory(Action action) {

    }

	public void addToHistory(Pair action) {
		history.addAction(action);
	}
	public void addEndTurnToHistory(Pair action) {
		history.
	}

    public void askForUserConfirmation(Action actionMessage) {

    }

    public void saveGame() {

    }

    public void loadGame() {

    }

    public TimeTraveler startRoundReplay() {
		return history.rewindTurns(3);
    }

    public TimeTraveler startGameReplay() {
		return history.rewindToBeginning();
    }

	public java.awt.event.KeyListener getKeyListener() {
		return keyListener;
	}
}
