package controller.potentialuistates;

import controller.Controller;
import controller.keylistener.Funktor;
import controller.keylistener.InternalListener;
import controller.keylistener.KeyListener;
import model.GameModel;
import model.Pair;
import model.actions.ActionResult;
import model.actions.developer.MoveDeveloperAroundBoard;
import model.board.HexLocation;
import model.board.Location;
import model.player.Developer;
import model.potentialactions.PotentialAction;
import model.potentialactions.PotentialMoveDeveloperAroundBoard;
import model.tiles.TileComponent;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Baker on 4/14/2014.
 */
public class MoveDeveloperAroundBoardUIState extends GameplayUIState {
    private final int KEY_NORTH = KeyEvent.VK_NUMPAD8;
    private final int KEY_SOUTH = KeyEvent.VK_NUMPAD2;
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

    Controller controller;
    KeyListener keyListener;
    GameModel model;
    PotentialMoveDeveloperAroundBoard potentialAction;

    public MoveDeveloperAroundBoardUIState(Controller controller, KeyListener keyListener, GameModel model, PotentialMoveDeveloperAroundBoard potential){
	    super(controller, keyListener, model);
        this.controller = controller;
        this.keyListener = keyListener;
        this.model = model;

        //potentialAction = new PotentialMoveDeveloperAroundBoard(model, controller.getPalaceFestival(), developer);
        potentialAction = potential;
        controller.refreshGameView(null, new HashMap<Location, TileComponent>(), potentialAction.getLocationFromPath());
        initListeners();
    }

    public void moveNorth() {
        ActionResult result = potentialAction.moveNorth();
        List<Location> highlighted = new ArrayList<Location>();
        highlighted.add(potentialAction.getLocation());
        if (potentialAction.getShortestLegalPath() != null)
            highlighted.addAll(potentialAction.getShortestLegalPath().getPath());
		updateView(result, highlighted);
    }

    public void moveSouth() {
        ActionResult result = potentialAction.moveSouth();
        List<Location> highlighted = new ArrayList<Location>();
        highlighted.add(potentialAction.getLocation());
        if (potentialAction.getShortestLegalPath() != null)
            highlighted.addAll(potentialAction.getShortestLegalPath().getPath());
        updateView(result, highlighted);
    }

    public void moveNortheast() {
        ActionResult result = potentialAction.moveNortheast();
        List<Location> highlighted = new ArrayList<Location>();
        highlighted.add(potentialAction.getLocation());
        if (potentialAction.getShortestLegalPath() != null)
            highlighted.addAll(potentialAction.getShortestLegalPath().getPath());
        updateView(result, highlighted);
    }

    public void moveNorthwest() {
        ActionResult result = potentialAction.moveNorthwest();
        List<Location> highlighted = new ArrayList<Location>();
        highlighted.add(potentialAction.getLocation());
        if (potentialAction.getShortestLegalPath() != null)
            highlighted.addAll(potentialAction.getShortestLegalPath().getPath());
        updateView(result, highlighted);
    }

	public void moveSoutheast() {
		ActionResult result = potentialAction.moveSoutheast();
        List<Location> highlighted = new ArrayList<Location>();
        highlighted.add(potentialAction.getLocation());
        if (potentialAction.getShortestLegalPath() != null)
            highlighted.addAll(potentialAction.getShortestLegalPath().getPath());
        updateView(result, highlighted);
	}

    public void moveSouthwest() {
        ActionResult result = potentialAction.moveSouthwest();
        List<Location> highlighted = new ArrayList<Location>();
        highlighted.add(potentialAction.getLocation());
        if (potentialAction.getShortestLegalPath() != null)
            highlighted.addAll(potentialAction.getShortestLegalPath().getPath());
        updateView(result, highlighted);
    }

    public void confirmPlacement() {
        Pair<ActionResult, MoveDeveloperAroundBoard> actionPair = potentialAction.confirmMovement();
        ActionResult result = actionPair.getFirst();

	    updateView(result, potentialAction.getShortestLegalPath().getPath());

	    if(result.isSuccess()) {
		    controller.addToHistory(actionPair);
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

	private void updateView(ActionResult result, List<Location> list) {
		controller.refreshGameView(result, new HashMap<Location, TileComponent>(), list);
	}
}
