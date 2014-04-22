package controller.potentialuistates;

import controller.Controller;
import controller.history.TimeTraveler;
import controller.keylistener.Funktor;
import controller.keylistener.InternalListener;
import controller.keylistener.KeyListener;
import model.GameModel;
import model.Pair;
import model.actions.ActionResult;
import model.actions.EndTurn;
import model.actions.UseActionToken;
import model.actions.palacefestival.PickUpDeckCard;
import model.actions.palacefestival.PickUpFestivalCard;
import model.board.Location;
import model.palacefestival.Card;
import model.palacefestival.PalaceFestival;
import model.potentialactions.PotentialBeginPalaceFestival;
import model.tiles.TileComponent;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Baker on 4/14/2014.
 */
public class EmptyUIState extends PotentialJavaUIState {
    private final int KEY_PLACEDEVELOPER = KeyEvent.VK_D;
    private final int KEY_SWITCHDEVELOPER = KeyEvent.VK_TAB;

    private final int KEY_PLACERICE = KeyEvent.VK_R;
    private final int KEY_PLACEVILLAGE = KeyEvent.VK_V;
    private final int KEY_PLACEIRRIGATION = KeyEvent.VK_I;
    private final int KEY_PLACEPALACE = KeyEvent.VK_P;
    private final int KEY_PLACETWO = KeyEvent.VK_2;
    private final int KEY_PLACETHREE = KeyEvent.VK_3;

    private final int KEY_UPGRADEPALACE = KeyEvent.VK_U;

    private final int KEY_ACTIONTOKEN = KeyEvent.VK_T;
	private final int KEY_DRAW_DECK_CARD = KeyEvent.VK_C;
	private final int KEY_DRAW_FESTIVAL_CARD = KeyEvent.VK_X;

    private final int KEY_ENDTURN = KeyEvent.VK_E;
    private final int KEY_PALACEFESTIVAL = KeyEvent.VK_F;

    private final int KEY_REPLAYROUND = KeyEvent.VK_A;
    private final int KEY_REPLAYGAME = KeyEvent.VK_Z;
	private final int KEY_DISPLAYCARDS = KeyEvent.VK_SPACE;

    private final int KEY_PLANNINGPLAY = KeyEvent.VK_Q;

    Controller controller;
    KeyListener keyListener;
    GameModel model;
	PalaceFestival paFes;

	boolean cardsDisplayed;

    public EmptyUIState(Controller controller, KeyListener keyListener, GameModel model, PalaceFestival paFes){
        this.controller = controller;
        this.keyListener = keyListener;
        this.model = model;
	    this.paFes = paFes;

	    cardsDisplayed = false;

        initListeners();
    }

    public void switchToSwitchDeveloperState() {
        controller.setCurrentState(new TabThroughDeveloperUIState(controller, keyListener, model, paFes));
    }

    public void switchToPlaceDeveloperState() {
        controller.setCurrentState(new PlaceDeveloperOnBoardUIState(controller, keyListener, model));
    }

    public void switchToUpgradePalaceState() {
        controller.setCurrentState(new UpgradePalaceUIState(controller, keyListener, model));
    }

    public void switchToPlaceTwoSpaceTileState() {
        controller.setCurrentState(new PlaceTwoSpaceTileUIState(controller, keyListener, model));
    }

    public void switchToPlaceThreeSpaceTileState() {
        controller.setCurrentState(new PlaceThreeSpaceTileUIState(controller, keyListener, model));
    }

    public void switchToPlaceVillageTileState() {
        controller.setCurrentState(new PlaceVillageTileUIState(controller, keyListener, model, paFes));
    }

    public void switchToPlacePalaceTileState() {
        controller.setCurrentState(new PlacePalaceTileUIState(controller, keyListener, model, paFes));
    }

    public void switchToPlaceIrrigationTileState() {
        controller.setCurrentState(new PlaceIrrigationTileUIState(controller, keyListener, model, paFes));
    }

    public void switchToPlaceRiceTileState() {
        controller.setCurrentState(new PlaceRiceTileUIState(controller, keyListener, model, paFes));
    }

    public void endTurn() {
	    EndTurn action = new EndTurn(model, paFes);
	    ActionResult result = action.tryAction();
	    if(result.isSuccess()) {
			action.doAction();
		    controller.addEndTurnToHistory(new Pair<ActionResult, EndTurn>(result, action));
			controller.refreshGameView();
	    }
    }

    public void startPalaceFestival() {
	    EndTurn action = new EndTurn(model, paFes);
	    ActionResult result = action.tryAction();
	    if(result.isSuccess()) {
		    //action.doAction(); todo Jon
		    controller.addEndTurnToHistory(new Pair<ActionResult, EndTurn>(result, action));
		    controller.refreshGameView();
		    controller.setCurrentState(new BeginPalaceFestivalTurnUIState(controller, keyListener, model));
	    }
    }

    public void useActionToken() {
        UseActionToken action = new UseActionToken(model);
	    ActionResult result = action.tryAction();
	    if(result.isSuccess()) {
		    action.doAction();
		    controller.addToHistory(new Pair<ActionResult, UseActionToken>(result, action));
		    controller.refreshGameView();
	    }
    }

	public void drawDeckCard() {
        PickUpDeckCard draw = new PickUpDeckCard(model, paFes);
        ActionResult result = draw.tryAction();
        if(result.isSuccess()) {
            draw.doAction();
            controller.addToHistory(new Pair<ActionResult, PickUpDeckCard>(result, draw));
            controller.refreshGameView();
        }
    }

    public void drawFestivalCard() {
	    PickUpFestivalCard draw = new PickUpFestivalCard(model, paFes);
	    ActionResult result = draw.tryAction();
	    if(result.isSuccess()) {
		    draw.doAction();
		    controller.addToHistory(new Pair<ActionResult, PickUpFestivalCard>(result, draw));
		    controller.refreshGameView();
	    }
    }

    public void switchBetweenPlanningAndPlayModes() {
        // TODO: implement
    }

	public void toggleCards() {
		controller.refreshCardView(new ArrayList<Card>(paFes.getCurrentPlayer().getHand()));
	}

    public void replayRound() {
	    controller.setCurrentState(new ReplayRoundUIState(controller, keyListener, model, controller.startRoundReplay()));
    }

    public void replaySinceBeginningOfGame() {
	    controller.setCurrentState(new ReplayRoundUIState(controller, keyListener, model, controller.startGameReplay()));
    }

    private void initListeners() {
        List<InternalListener> listeners = new ArrayList<InternalListener>();
        InternalListener i = new InternalListener(KEY_PLACEDEVELOPER, new Funktor() {
            @Override
            public void call() {
                switchToPlaceDeveloperState();
            }
        });
        listeners.add(i);

        i = new InternalListener(KEY_SWITCHDEVELOPER, new Funktor() {
            @Override
            public void call() {
                switchToSwitchDeveloperState();
            }
        });
        listeners.add(i);

        i = new InternalListener(KEY_PLACERICE, new Funktor() {
            @Override
            public void call() {
                switchToPlaceRiceTileState();
            }
        });
        listeners.add(i);

        i = new InternalListener(KEY_PLACEVILLAGE, new Funktor() {
            @Override
            public void call() {
                switchToPlaceVillageTileState();
            }
        });
        listeners.add(i);

        i = new InternalListener(KEY_PLACEIRRIGATION, new Funktor() {
            @Override
            public void call() {
                switchToPlaceIrrigationTileState();
            }
        });
        listeners.add(i);

        i = new InternalListener(KEY_PLACEPALACE, new Funktor() {
            @Override
            public void call() {
                switchToPlacePalaceTileState();
            }
        });
        listeners.add(i);

        i = new InternalListener(KEY_PLACETWO, new Funktor() {
            @Override
            public void call() {
                switchToPlaceTwoSpaceTileState();
            }
        });
        listeners.add(i);

        i = new InternalListener(KEY_PLACETHREE, new Funktor() {
            @Override
            public void call() {
                switchToPlaceThreeSpaceTileState();
            }
        });
        listeners.add(i);

        i = new InternalListener(KEY_UPGRADEPALACE, new Funktor() {
            @Override
            public void call() {
                switchToUpgradePalaceState();
            }
        });
        listeners.add(i);

        i = new InternalListener(KEY_ACTIONTOKEN, new Funktor() {
            @Override
            public void call() {
                useActionToken();
            }
        });
        listeners.add(i);

	    i = new InternalListener(KEY_DRAW_DECK_CARD, new Funktor() {
		    @Override
		    public void call() {
			    drawDeckCard();
		    }
	    });
	    listeners.add(i);

        i = new InternalListener(KEY_DRAW_FESTIVAL_CARD, new Funktor() {
            @Override
            public void call() {
                drawFestivalCard();
            }
        });
        listeners.add(i);

        i = new InternalListener(KEY_ENDTURN, new Funktor() {
            @Override
            public void call() {
                endTurn();
            }
        });
        listeners.add(i);

        i = new InternalListener(KEY_PALACEFESTIVAL, new Funktor() {
            @Override
            public void call() {
                startPalaceFestival();
            }
        });
        listeners.add(i);

        i = new InternalListener(KEY_REPLAYROUND, new Funktor() {
            @Override
            public void call() {
                replayRound();
            }
        });
        listeners.add(i);

        i = new InternalListener(KEY_DISPLAYCARDS, new Funktor() {
		    @Override
		    public void call() {
			    toggleCards();
		    }
	    });
	    listeners.add(i);

	    i = new InternalListener(KEY_REPLAYGAME, new Funktor() {
		    @Override
		    public void call() {
			    replaySinceBeginningOfGame();
		    }
	    });
	    listeners.add(i);

        i = new InternalListener(KEY_PLANNINGPLAY, new Funktor() {
            @Override
            public void call() {
                switchBetweenPlanningAndPlayModes();
            }
        });
        listeners.add(i);

        keyListener.replaceTemporaryListener(listeners);
    }
}
