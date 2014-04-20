package controller.potentialuistates;

import controller.Controller;
import controller.keylistener.KeyListener;
import model.GameModel;
import model.potentialactions.PotentialTabThroughDevelopers;

/**
 * Created by Baker on 4/14/2014.
 */
public class TabThroughDeveloperUIState extends GameplayUIState {
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
}
