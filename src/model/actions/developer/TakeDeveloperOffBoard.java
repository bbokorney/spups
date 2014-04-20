package model.actions.developer;

import model.GameModel;
import model.actions.Action;
import model.actions.ActionResult;
import model.actions.serialization.JsonObject;
import model.board.Location;
import pathfinding.JavaPath;

/**
 * Created by idinamenzel on 4/14/14.
 */
public class TakeDeveloperOffBoard extends Action {


    /*
        attributes
     */
    Location developerLocationTakenOff;
    JavaPath path;
    GameModel game;
    /*
        constructors
     */
    public TakeDeveloperOffBoard(GameModel game){
        this.game = game;

    }
    public TakeDeveloperOffBoard(Location developerLocationTakenOff, JavaPath path, GameModel game){
        this.path = path;
        this.developerLocationTakenOff = developerLocationTakenOff;
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
        boolean isSuccess = false;
        int famePoints = 0;
        int actionPoints = 0;
        String message = "";

        //Check if the path is valid

        //Check if the player has enough AP points to travel the path

        //todo

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

            //Decrememnt the AP points the path cost
            //Move the developer along the path
            //(change the developer location to the last place on the path)
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
