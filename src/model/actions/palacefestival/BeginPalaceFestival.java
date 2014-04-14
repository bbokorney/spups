package model.actions.palacefestival;

import model.GameModel;
import model.actions.Action;
import model.actions.serialization.JsonObject;
import model.board.Location;
import model.palacefestival.PalaceCard;

import java.util.ArrayList;

/**
 * Created by Baker on 4/14/2014.
 */
public class BeginPalaceFestival extends Action {

    private int palaceValueForFestival;
    private Location palaceLocation;
    private ArrayList<PalaceCard> cardsBidded;

    @Override
    public boolean tryAction(GameModel game) {
        // TODO: Sara
        throw new UnsupportedOperationException("Tell Sara to implement me!");
    }

    @Override
    public boolean doAction(GameModel game) {
        // TODO: Sara
        throw new UnsupportedOperationException("Tell Sara to implement me!");
    }

    @Override
    public String serialize(GameModel game) {
        // TODO: Sara
        throw new UnsupportedOperationException("Tell Sara to implement me!");
    }

    @Override
    public Action restore(JsonObject actionToRestore) {
        // TODO: Sara
        throw new UnsupportedOperationException("Tell Sara to implement me!");
    }

    @Override
    public int getActionID() {
        // TODO: Sara
        throw new UnsupportedOperationException("Tell Sara to implement me!");
    }

}
