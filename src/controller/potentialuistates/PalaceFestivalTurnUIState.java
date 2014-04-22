package controller.potentialuistates;

import controller.Controller;
import controller.keylistener.Funktor;
import controller.keylistener.InternalListener;
import controller.keylistener.KeyListener;
import model.GameModel;
import model.actions.ActionResult;
import model.board.Location;
import model.palacefestival.PalaceFestival;
import model.potentialactions.PotentialJoinFestival;
import model.potentialactions.PotentialMoveToTie;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonathan on 4/20/2014.
 */
public class PalaceFestivalTurnUIState extends PotentialJavaUIState {
	private final int KEY_SWITCH = KeyEvent.VK_TAB;
	private final int KEY_SELECT = KeyEvent.VK_ENTER;
	private final int KEY_DESELECT = KeyEvent.VK_DELETE;
	private final int KEY_BID = KeyEvent.VK_B;
	private final int KEY_WITHDRAW = KeyEvent.VK_W;
	private final int KEY_TIE = KeyEvent.VK_T;

	Controller controller;
	KeyListener keyListener;
	GameModel model;
	PalaceFestival paFes;
	Location palaceLocation;

	int playersTying;

	PotentialJoinFestival potentialAction;
	PotentialMoveToTie potentialTie;

	public PalaceFestivalTurnUIState(Controller controller, KeyListener keyListener, GameModel model, Location palaceLocation){
		this.controller = controller;
		this.keyListener = keyListener;
		this.model = model;
		paFes = controller.getPalaceFestival();
		this.palaceLocation = palaceLocation;

		playersTying = 0;

		potentialAction = new PotentialJoinFestival(palaceLocation);
		potentialTie = new PotentialMoveToTie(paFes);
		controller.refreshPalaceFestivalView(potentialAction.getIndexOfCardsToBid());

		initJoinListeners();
	}

	public PalaceFestivalTurnUIState(Controller controller, KeyListener keyListener, GameModel model, Location palaceLocation, PotentialMoveToTie potentialTie, int playersTying){
		this.controller = controller;
		this.keyListener = keyListener;
		this.model = model;
		paFes = controller.getPalaceFestival();
		this.palaceLocation = palaceLocation;

		this.playersTying = playersTying;

		potentialAction = new PotentialJoinFestival(palaceLocation);
		this.potentialTie = potentialTie;
		controller.refreshPalaceFestivalView(potentialAction.getIndexOfCardsToBid());

		initTieListeners();
	}

	public void switchCard() {
		potentialAction.tabToNextElement();
		controller.refreshPalaceFestivalView(potentialAction.getIndexOfCardsToBid());
	}

	public void selectCard() {
		potentialAction.chooseCurrentCard();
		controller.refreshPalaceFestivalView(potentialAction.getIndexOfCardsToBid());
	}

	public void deselectCard() {
		potentialAction.removeCurrentCardFromBid();
		controller.refreshPalaceFestivalView(potentialAction.getIndexOfCardsToBid());
	}

	public void confirmBid() {
		potentialAction.confirmBid();
		controller.refreshPalaceFestivalView(potentialAction.getIndexOfCardsToBid());
		controller.setCurrentState(new PalaceFestivalTurnUIState(controller, keyListener, model, palaceLocation));
	}

	public void withdraw() {
		potentialAction.withdraw();
		if(playersTying > 0) {
			controller.refreshPalaceFestivalView(potentialAction.getIndexOfCardsToBid());
			controller.setCurrentState(new PalaceFestivalTurnUIState(controller, keyListener, model, palaceLocation, potentialTie, playersTying));
		}
		else {
			controller.refreshPalaceFestivalView(potentialAction.getIndexOfCardsToBid());
			controller.setCurrentState(new PalaceFestivalTurnUIState(controller, keyListener, model, palaceLocation));
		}
	}

	public void tie() {
		ActionResult result = potentialTie.getActionResult();
		if(!result.isSuccess()) {
			controller.setCurrentState(new PalaceFestivalTurnUIState(controller, keyListener, model, palaceLocation, potentialTie, ++playersTying));
		}
		else {
			controller.setCurrentState(new EmptyUIState(controller, keyListener, model, paFes));
		}
	}

	private void initCommonListeners() {
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

		i = new InternalListener(KEY_WITHDRAW, new Funktor() {
			@Override
			public void call() {
				withdraw();
			}
		});
		listeners.add(i);

		i = new InternalListener(KEY_TIE, new Funktor() {
			@Override
			public void call() {
				tie();
			}
		});
		listeners.add(i);

		keyListener.replaceTemporaryListener(listeners);
	}

	private void initJoinListeners() {
		initCommonListeners();
	}

	private void initTieListeners() {
		initCommonListeners();
	}
}
