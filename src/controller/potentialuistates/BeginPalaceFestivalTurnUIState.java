package controller.potentialuistates;

import controller.Controller;
import controller.keylistener.Funktor;
import controller.keylistener.InternalListener;
import controller.keylistener.KeyListener;
import model.GameModel;
import model.potentialactions.PotentialBeginPalaceFestival;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Baker on 4/14/2014.
 */
public class BeginPalaceFestivalTurnUIState {

    private final int KEY_TAB = KeyEvent.VK_TAB;
    private final int KEY_CANCEL = KeyEvent.VK_ESCAPE;
    private final int KEY_CANCEL_CARD = KeyEvent.VK_DELETE;
    private final int KEY_CONFIRM = KeyEvent.VK_ENTER;
    private final int KEY_LEFT = KeyEvent.VK_LEFT;
    private final int KEY_RIGHT = KeyEvent.VK_RIGHT;

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

        List<InternalListener> listeners = new ArrayList<InternalListener>();
        listeners.add( new InternalListener(KEY_TAB, new Funktor() {
            @Override
            public void call() {
                potentialAction.tabToNextPalace();
            }
        }));

        listeners.add( new InternalListener(KEY_CANCEL, new Funktor() {
            @Override
            public void call() {
                //todo figure this out
            }
        }));

        listeners.add( new InternalListener(KEY_CANCEL_CARD, new Funktor() {
            @Override
            public void call() {
                potentialAction.removeCurrentCardFromBid();
            }
        }));

        listeners.add( new InternalListener(KEY_CONFIRM, new Funktor() {
            @Override
            public void call() {
                potentialAction.chooseCurrentCard();
            }
        }));

        listeners.add( new InternalListener(KEY_LEFT, new Funktor() {
            @Override
            public void call() {
                potentialAction.tabToNextCard();
            }
        }));

        listeners.add( new InternalListener(KEY_RIGHT, new Funktor() {
            @Override
            public void call() {
                potentialAction.tabToPreviousCard();
            }
        }));

        keyListener.replaceTemporaryListener(listeners);

    }

}
