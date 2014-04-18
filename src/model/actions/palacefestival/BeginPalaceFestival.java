package model.actions.palacefestival;

import model.GameModel;
import model.Pair;
import model.actions.Action;
import model.actions.ActionResult;
import model.actions.serialization.JsonObject;
import model.board.Location;
import model.palacefestival.Card;

import java.util.ArrayList;

/**
 * Created by Baker on 4/14/2014.
 */
public class BeginPalaceFestival extends Action {

    private int palaceValueForFestival;
    private Location palaceLocation;
    private ArrayList<Card> cardsBidded;

    @Override
    public ActionResult tryAction(GameModel game) {
        // TODO: Sara
        throw new UnsupportedOperationException("Tell Sara to implement me!");
    }

    @Override
    public ActionResult doAction(GameModel game) {
        // TODO: Sara
        throw new UnsupportedOperationException("Tell Sara to implement me!");
    }

    @Override
    public String serialize() {
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
