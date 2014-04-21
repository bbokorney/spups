package controller.potentialuistates;

import controller.Controller;
import controller.keylistener.Funktor;
import controller.keylistener.InternalListener;
import controller.keylistener.KeyListener;
import model.GameModel;
import model.Pair;
import model.actions.ActionResult;
import model.actions.tiles.PlaceRiceTile;
import model.board.Location;
import model.potentialactions.PotentialAction;
import model.potentialactions.PotentialPlaceRiceTile;
import model.tiles.RiceTileComponent;
import model.tiles.Tile;
import model.tiles.TileComponent;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Baker on 4/14/2014.
 */
public class PlaceRiceTileUIState extends GameplayUIState {
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

	PotentialPlaceRiceTile potentialAction;

    public PlaceRiceTileUIState(Controller controller, KeyListener keyListener, GameModel model){
        this.controller = controller;
        this.keyListener = keyListener;
        this.model = model;

	    potentialAction = new PotentialPlaceRiceTile(model, controller.getPalaceFestival());
        updateView(potentialAction.getActionResult());

        initListeners();

    }

    private void updateView(ActionResult result) {
        Map<Location, TileComponent> hoverComponents = new HashMap<Location, TileComponent>();
        hoverComponents.put(potentialAction.getLocation(), new RiceTileComponent());
        List<Location> highlighted = new ArrayList<Location>();
        highlighted.add(potentialAction.getLocation());
        controller.refreshGameView(result, hoverComponents, highlighted);
    }

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
		Pair<ActionResult, PlaceRiceTile> actionPair = potentialAction.confirmPlacement();
		ActionResult result = actionPair.getFirst();

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

		keyListener.replaceTemporaryListener(listeners);
	}
}
