package controller;

import controller.history.History;
import controller.history.TimeTraveler;
import controller.keylistener.KeyListener;
import controller.potentialuistates.EmptyUIState;
import controller.potentialuistates.PotentialJavaUIState;
import model.GameModel;
import model.Pair;
import model.actions.Action;
import model.actions.ActionResult;
import model.board.Location;
import model.palacefestival.Card;
import model.palacefestival.PalaceFestival;
import model.tiles.TileComponent;
import view.GameFrame;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        keyListener = view.getKeyListener();
		paFes = palaceFestival;

        currentState = new EmptyUIState(this, keyListener, model, paFes);
	}

    public void setCurrentState(PotentialJavaUIState newState) {
        this.currentState = newState;
    }

	public void addToHistory(Pair action) {
		//history.addAction(action); TODO: Baker, history broken
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

	public GameFrame getView() { return view; }

	public void refreshGameView(ActionResult actionResult, Map<Location, TileComponent> potentialComponents, List<Location> highlightedComponents) {
		view.refreshGame(model, paFes, actionResult, potentialComponents, highlightedComponents);
	}

	public void refreshGameView() {
		refreshGameView(null, new HashMap<Location, TileComponent>(), new ArrayList<Location>());
	}

	public void refreshCardView(List<Card> cards) {
		view.refreshCardView(cards);
	}

	public void refreshPalaceFestivalView(List<Integer> cardsSelected) {
		view.refreshFestivalView(model, paFes, new ArrayList<Card>(paFes.getCurrentPlayer().getHand()), cardsSelected);
	}

    public void goToEmptyState() {
        this.setCurrentState(new EmptyUIState(this, keyListener, model, paFes));
        refreshGameView();
    }
}
