package controller.potentialuistates;

import controller.Controller;
import controller.keylistener.KeyListener;

/**
 * Created by Baker on 4/14/2014.
 */
public abstract class GameplayUIState extends PotentialJavaUIState{
    Controller controller;
    KeyListener keyListener;

    public void switchToEmptyState() {
       controller.setCurrentState(new EmptyUIState(controller, keyListener));
    }
}
