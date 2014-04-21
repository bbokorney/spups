package model.actions;

import model.GameModel;
import model.actions.serialization.JsonObject;
import model.player.JavaPlayerResourceType;

/**
 * Created by idinamenzel on 4/14/14.
 */
public class UseActionToken extends Action {



    /*
        no attributes
     */

    /*
        Constructors
     */
    GameModel game;

    public UseActionToken(GameModel game){
        this.game = game;
        //Empty constructor
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

        if(game.hasUsedActionToken()){
            isSuccess = isSuccess && true;
        }
        else{
            isSuccess = isSuccess && false;
            message += "You have already used an Action Token this turn.";
        }
        if(game.getCount(JavaPlayerResourceType.EXTRAACTIONTOKEN) > 0){
            isSuccess = isSuccess && true;
        }
        else{
            isSuccess = isSuccess && false;
            message += "You have no Action Tokens left";
        }

        if(message.equalsIgnoreCase("")){
            message += "Action Token, AP " + actionPoints + ", Fame " + famePoints;
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

            game.useResource(JavaPlayerResourceType.EXTRAACTIONTOKEN);
            game.useActionPoints(-1);
            game.hasUsedActionToken();
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