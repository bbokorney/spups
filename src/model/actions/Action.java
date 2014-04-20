package model.actions;

import model.GameModel;
import model.Pair;
import model.actions.serialization.JsonObject;

/**
 * Created by idinamenzel on 4/14/14.
 */
public abstract class Action {

    int actionID;

    /*      Getters     */

    public int getActionID(){
        return actionID;
    }

    /*      Abstract Interface      */

    public abstract ActionResult tryAction();

    public abstract ActionResult doAction(GameModel game);

    public abstract String serialize();

    public abstract Action restore(JsonObject actionToRestore);


}