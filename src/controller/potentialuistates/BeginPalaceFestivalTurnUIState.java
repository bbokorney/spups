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
public class BeginPalaceFestivalTurnUIState extends GameplayUIState {
	private final int KEY_SWITCH = KeyEvent.VK_TAB;
	private final int KEY_SELECT = KeyEvent.VK_ENTER;
	private final int KEY_DESELECT = KeyEvent.VK_DELETE;
	private final int KEY_BID = KeyEvent.VK_B;

    Controller controller;
    KeyListener keyListener;
	GameModel model;

	PotentialBeginPalaceFestival potentialAction;

    public BeginPalaceFestivalTurnUIState(Controller controller, KeyListener keyListener, GameModel model){
        this.controller = controller;
        this.keyListener = keyListener;
	    this.model = model;

	    potentialAction = new PotentialBeginPalaceFestival();

        initFirstListeners();
    }

	public void switchPalace() {

	}

	public void confirmPalace() {

	}

	public void switchCard() {

	}

	public void selectCard() {

	}

	public void deselectCard() {

	}

	public void confirmBid() {

	}

    private void initFirstListeners() {
	    List<InternalListener> listeners = new ArrayList<InternalListener>();
	    InternalListener i = new InternalListener(KEY_SWITCH, new Funktor() {
		    @Override
		    public void call() {
			    switchPalace();
		    }
	    });
	    listeners.add(i);

	    i = new InternalListener(KEY_SELECT, new Funktor() {
		    @Override
		    public void call() {
			    confirmPalace();
		    }
	    });
	    listeners.add(i);
    }

	private void initSecondListeners() {
		List<InternalListener> listeners = new ArrayList<InternalListener>();
		InternalListener i = new InternalListener(KEY_SWITCH, new Funktor() {
			@Override
			public void call() {
				switchCard();
			}
		});
		listeners.add(i);

		i = new InternalListener(KEY_SELECT, new Funktor() {
			@Override
			public void call() {
				selectCard();
			}
		});
		listeners.add(i);

		i = new InternalListener(KEY_DESELECT, new Funktor() {
			@Override
			public void call() {
				deselectCard();
			}
		});
		listeners.add(i);

		i = new InternalListener(KEY_BID, new Funktor() {
			@Override
			public void call() {
				confirmBid();
			}
		});
		listeners.add(i);
	}
}
