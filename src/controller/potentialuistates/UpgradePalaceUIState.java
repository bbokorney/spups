package controller.potentialuistates;

import controller.Controller;
import controller.keylistener.KeyListener;
import model.GameModel;

/**
 * Created by Baker on 4/14/2014.
 */
public class UpgradePalaceUIState extends GameplayUIState {
    Controller controller;
    KeyListener keyListener;
    GameModel model;

    public UpgradePalaceUIState(Controller controller, KeyListener keyListener, GameModel model){
        this.controller = controller;
        this.keyListener = keyListener;
        this.model = model;

        initListeners();
    }
}
