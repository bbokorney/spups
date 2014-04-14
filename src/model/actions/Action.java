package model.actions;

import model.GameModel;
import model.actions.serialization.JsonObject;

/**
 * Created by Owner on 4/14/14.
 */
public abstract class Action {

    public abstract boolean tryAction(GameModel game);

    public abstract boolean doAction(GameModel game);

    public abstract String serialize(GameModel game);

    public abstract Action restore(JsonObject actionToRestore);

    public abstract int getActionID();

}
