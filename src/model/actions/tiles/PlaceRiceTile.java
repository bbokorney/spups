package model.actions.tiles;

import model.GameModel;
import model.Pair;
import model.actions.Action;
import model.actions.ActionResult;
import model.actions.serialization.JsonObject;
import model.board.Location;

/**
 * Created by idinamenzel on 4/14/14.
 */
public class PlaceRiceTile extends Action {


    /*
        attributes
     */
    Location placement;

    /*
        constructors
     */
    public PlaceRiceTile(){
        //Empty constructor
        //mostly used for loading
    }
    public PlaceRiceTile(Location placement){
        this.placement = placement;
    }


    @Override
    public ActionResult tryAction(GameModel game) {
     /*
        Check if the action is valid to complete
        ...
        returns true if valid
                false if invalid
     */
        boolean isSuccess = true;
        int famePoints = 0;         //todo replace with surround body of water
        int actionPoints = 1;       //will always cost 1 ap
        String message = "";

        //Check if the player has a rice tile to use
        if(true){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You do not have enough rice tiles.\n";
        }

        //check if the player has enough AP, 1
        if(true){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You do not have enough AP points.\n";
        }

        //Check if they are not placing on top of a one tile
        if(true){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You cannot place this on a one space tile.\n";
        }

        //Check if they are placing this directly on the board or on another land tile
        if(true){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You cannot place a rice tile on this terrain.\n";
        }

        //Check if the player is placing on top of a developer
        if(true){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You cannot place this tile on top of a developer.\n";
        }


        //todo

        return new ActionResult(isSuccess, famePoints, actionPoints, message, this);
    }

    @Override
    public Pair<ActionResult, Action> doAction(GameModel game) {
    /*
        Check if the action is valid
        Do the action if is valid to so
        ...
     */
        ActionResult result = tryAction(game);
        if(result.isSuccess()) {

            //Decrememnt the AP points

            // decrement rice tiles in the players resources

            //award them with the fame points, if anything

            //place the tile on the board

            //set has placed land tile to true
        }
        return new Pair(result, this);
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

    public PlaceRiceTile restore(JsonObject actionToRestore) {
    /*
        Converts the JsonObject used when loading
        to restore the states/attributes of this action.

        Utilized JsonObject to accomplish this
     */
        return null;
    }
}