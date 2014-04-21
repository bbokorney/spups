package controller;

import controller.history.History;
import controller.history.TimeTraveler;
import controller.keylistener.KeyListener;
import controller.potentialuistates.EmptyUIState;
import controller.potentialuistates.PotentialJavaUIState;
import model.GameModel;
import model.Pair;
import model.actions.Action;
import model.palacefestival.PalaceFestival;
import view.GameFrame;

/**
 * Created by Baker on 4/14/2014.
 */
public class Controller {
    History history;
    KeyListener keyListener;
    GameFrame view;
    GameModel model;
	PalaceFestival paFes;

    PotentialJavaUIState currentState;

	public Controller(GameFrame view, GameModel model, PalaceFestival palaceFestival) {
		this.view = view;
        this.model = model;
        keyListener = new KeyListener();
		paFes = palaceFestival;

        currentState = new EmptyUIState(this, keyListener, model);
	}

    public void setCurrentState(PotentialJavaUIState newState) {
        this.currentState = newState;
    }

	public void addToHistory(Pair action) {
		history.addAction(action);
	}
	public void addEndTurnToHistory(Pair action) {
		history.addEndTurn(action);
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

	public PalaceFestival getPalaceFestival() { return paFes; }
}
