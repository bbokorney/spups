package model.actions.tiles;

import model.GameModel;
import model.actions.Action;
import model.actions.ActionResult;
import model.actions.serialization.JsonObject;
import model.board.Location;

/**
 * Created by idinamenzel on 4/14/14.
 */
public class PlaceIrrigationTile extends Action {


    /*
        attributes
     */
    private Location placement;


    /*
        constructors
     */
    PlaceIrrigationTile(){
        //Empty constructor
        //used for loading
    }

    PlaceIrrigationTile(Location placement){
        this.placement = placement;
    }


    @Override
    public ActionResult tryAction(GameModel game) {
        //todo

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

        //Check if the player has enough AP points - 1
        if(true){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You do not have enough AP points.\n";
        }

        //check if required elevation is 0
        if(true){
            isSuccess = isSuccess && true;
        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: The elevation is nonzero.\n";
        }

        //checks if the player is placing outside of central java
        if(true){
            isSuccess = isSuccess && true;
        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: This tile cannot be placed outside Central Java.\n";
        }

        //check if the player would surround a body of water by placing this tile
        //this would only gain the player fame points.


        return new ActionResult(isSuccess, famePoints, actionPoints, message, this);
    }

    @Override
    public ActionResult doAction(GameModel game) {
    /*
        Check if the action is valid
        Do the action if is valid to so
        ...
     */
        ActionResult result = tryAction(game);
        if(result.isSuccess()) {

            //Decrememnt the AP points it cost

            //Award the fame points to the player

            //decrement the number of irrigation tiles from shared resources

            //place the tile on the board

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