package controller.potentialuistates;

import controller.Controller;
import controller.keylistener.KeyListener;
import model.GameModel;
import model.potentialactions.PotentialBeginPalaceFestival;

/**
 * Created by Baker on 4/14/2014.
 */
public class BeginPalaceFestivalTurnUIState extends GameplayUIState {

    Controller controller;
    KeyListener keyListener;
	GameModel model;

	PotentialBeginPalaceFestival potentialAction;

    public BeginPalaceFestivalTurnUIState(Controller controller, KeyListener keyListener, GameModel model){
        this.controller = controller;
        this.keyListener = keyListener;
	    this.model = model;

	    potentialAction = new PotentialBeginPalaceFestival();

        initListeners();
    }

    private void initListeners() {

    }
}
