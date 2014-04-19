package controller.potentialuistates;

import controller.Controller;
import controller.keylistener.KeyListener;

/**
 * Created by Baker on 4/14/2014.
 */
public class BeginPalaceFestivalTurnUIState extends GameplayUIState {

    Controller controller;
    KeyListener keyListener;

    public BeginPalaceFestivalTurnUIState(Controller controller, KeyListener keyListener){
        this.controller = controller;
        this.keyListener = keyListener;

        initListeners();
    }

    private void initListeners() {

    }
}
