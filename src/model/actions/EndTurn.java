package model.actions;

import model.GameModel;
import model.actions.serialization.JsonObject;

/**
 * Created by idinamenzel on 4/14/14.
 */
public class EndTurn extends Action {

    /*
        attributes
     */

    /*
        constructors
     */

    GameModel game;

    public EndTurn(GameModel game){
        this.game = game;
    }


    @Override
    public ActionResult tryAction() {
     /*
        Check if the action is valid to complete
        ...
        returns true if valid
                false if invalid
     */
        boolean isSuccess = true;
        int famePoints = 0;
        int actionPoints = 0;
        String message = "";

        //Check if the turn can advance

        //todo talk to controller about mapping key press for end turn to NOT WORK which forces them to go between planning and play mode

        if(!game.canAdvanceJavaTurn()){
            isSuccess = false;
            message += "Player cannot end their turn";
        }

        if(message.equalsIgnoreCase("")){
            message += "End Turn";
        }

        return new ActionResult(isSuccess, famePoints, actionPoints, message);
    }

    @Override
    public ActionResult doAction() {
    /*
        Check if the action is valid
        Do the action if is valid to so
        ...
     */
        ActionResult result = tryAction();
        if(result.isSuccess()) {

            game.advanceJavaTurn();
        }
        return result;
    }


    @Override
    public String serialize() {
     /*
        Formats the attributes of this object
        into a String that can be used
        for loading and saving.

        Utilizes Json and JsonObject to accomplish this.
     */
        return null;
    }

    @Override

    public Action restore(JsonObject actionToRestore) {
    /*
        Converts the JsonObject used when loading
        to restore the states/attributes of this action.

        Utilized JsonObject to accomplish this
     */
        return null;
    }
}
