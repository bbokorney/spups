package model.actions;

import model.GameModel;
import model.Pair;
import model.actions.serialization.JsonObject;

/**
 * Created by idinamenzel on 4/14/14.
 */
public abstract class Action {


    public Action(){

    }

    /*      Getters     */


    /*      Abstract Interface      */

    public abstract ActionResult tryAction();

    public abstract ActionResult doAction();

    public abstract String serialize();

    public abstract Action restore(JsonObject actionToRestore);



}