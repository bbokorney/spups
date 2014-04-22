package controller.potentialuistates;

import controller.Controller;
import controller.keylistener.Funktor;
import controller.keylistener.InternalListener;
import controller.keylistener.KeyListener;
import model.GameModel;
import model.Pair;
import model.actions.Action;
import model.actions.ActionResult;
import model.board.Location;
import model.potentialactions.HexComponentPotentialAction;
import model.tiles.TileComponent;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Baker on 4/21/2014.
 */
public abstract class HexComponentMovementUIState extends GameplayUIState {
    private final int KEY_SOUTH = KeyEvent.VK_NUMPAD2;
    private final int KEY_NORTH = KeyEvent.VK_NUMPAD8;
    private final int KEY_NORTHEAST = KeyEvent.VK_NUMPAD9;
    private final int KEY_SOUTHEAST = KeyEvent.VK_NUMPAD3;
    private final int KEY_NORTHWEST = KeyEvent.VK_NUMPAD7;
    private final int KEY_SOUTHWEST = KeyEvent.VK_NUMPAD1;

    private final int ALT_KEY_NORTH = KeyEvent.VK_SEMICOLON;
    private final int ALT_KEY_SOUTH = KeyEvent.VK_PERIOD;
    private final int ALT_KEY_NORTHEAST = KeyEvent.VK_QUOTE;
    private final int ALT_KEY_SOUTHEAST = KeyEvent.VK_SLASH;
    private final int ALT_KEY_NORTHWEST = KeyEvent.VK_L;
    private final int ALT_KEY_SOUTHWEST = KeyEvent.VK_COMMA;

    private final int KEY_CONFIRM = KeyEvent.VK_ENTER;

    private Controller controller;
    private KeyListener keyListener;
    private GameModel model;


    private HexComponentPotentialAction potentialAction;

    public HexComponentMovementUIState(Controller controller, KeyListener keyListener,
                                       GameModel model, HexComponentPotentialAction potentialAction){
        this(controller, keyListener, model);
        this.potentialAction = potentialAction;
    }

    public HexComponentMovementUIState(Controller controller, KeyListener keyListener,
                                       GameModel model){
	    super(controller, keyListener, model);
        this.controller = controller;
        this.keyListener = keyListener;
        this.model = model;


        initListeners();
        initAdditionalListeners();
    }

    protected void setPotentialAction(HexComponentPotentialAction action) {
        this.potentialAction = action;
        System.out.println("setPotentialAction");
        updateView(potentialAction.getActionResult());
    }

    protected void initAdditionalListeners() {}

    private void updateView(ActionResult result) {
        controller.refreshGameView(result, getBoardComponents(), getHighlightedLocations());
    }

    protected abstract Map<Location, TileComponent> getBoardComponents();

    protected abstract List<Location> getHighlightedLocations();

    protected void updateView() {
        updateView(potentialAction.getActionResult());
    }

    protected KeyListener getKeyListener() { return keyListener; }

    public void moveNorth() {
        updateView(potentialAction.moveNorth());
    }

    public void moveSouth() {
        updateView(potentialAction.moveSouth());
    }

    public void moveNortheast() {
        updateView(potentialAction.moveNortheast());
    }

    public void moveNorthwest() {
        updateView(potentialAction.moveNorthwest());
    }

    public void moveSoutheast() {
        updateView(potentialAction.moveSoutheast());
    }

    public void moveSouthwest() {
        updateView(potentialAction.moveSouthwest());
    }

    public void confirmPlacement() {
        Pair<ActionResult, Action> actionPair = potentialAction.confirmAction();
        ActionResult result = actionPair.getFirst();

        if(result.isSuccess()) {
            controller.addToHistory(actionPair);
            controller.goToEmptyState();
        }
    }

    private void initListeners() {
        List<InternalListener> listeners = new ArrayList<InternalListener>();
        InternalListener i = new InternalListener(KEY_NORTH, new Funktor() {
            @Override
            public void call() {
                moveNorth();
            }
        });
        listeners.add(i);
        i = new InternalListener(ALT_KEY_NORTH, new Funktor() {
            @Override
            public void call() {
                moveNorth();
            }
        });
        listeners.add(i);

        i = new InternalListener(KEY_SOUTH, new Funktor() {
            @Override
            public void call() {
                moveSouth();
            }
        });
        listeners.add(i);
        i = new InternalListener(ALT_KEY_SOUTH, new Funktor() {
            @Override
            public void call() {
                moveSouth();
            }
        });
        listeners.add(i);


        i = new InternalListener(KEY_NORTHWEST, new Funktor() {
            @Override
            public void call() {
                moveNorthwest();
            }
        });
        listeners.add(i);
        i = new InternalListener(ALT_KEY_NORTHWEST, new Funktor() {
            @Override
            public void call() {
                moveNorthwest();
            }
        });
        listeners.add(i);


        i = new InternalListener(KEY_NORTHEAST, new Funktor() {
            @Override
            public void call() {
                moveNortheast();
            }
        });
        listeners.add(i);
        i = new InternalListener(ALT_KEY_NORTHEAST, new Funktor() {
            @Override
            public void call() {
                moveNortheast();
            }
        });
        listeners.add(i);


        i = new InternalListener(KEY_SOUTHWEST, new Funktor() {
            @Override
            public void call() {
                moveSouthwest();
            }
        });
        listeners.add(i);
        i = new InternalListener(ALT_KEY_SOUTHWEST, new Funktor() {
            @Override
            public void call() {
                moveSouthwest();
            }
        });
        listeners.add(i);

        i = new InternalListener(KEY_SOUTHEAST, new Funktor() {
            @Override
            public void call() {
                moveSoutheast();
            }
        });
        listeners.add(i);
        i = new InternalListener(ALT_KEY_SOUTHEAST, new Funktor() {
            @Override
            public void call() {
                moveSoutheast();
            }
        });
        listeners.add(i);

        i = new InternalListener(KEY_CONFIRM, new Funktor() {
            @Override
            public void call() {
                confirmPlacement();
            }
        });
        listeners.add(i);

        keyListener.addTemporaryListeners(listeners);
    }

}
