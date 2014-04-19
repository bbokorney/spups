package model.actions.tiles;


import model.GameModel;
import model.Pair;
import model.actions.Action;
import model.actions.ActionResult;
import model.actions.serialization.JsonObject;
import model.board.Location;

/**
 * Created by idinamenzel on 4/13/14.
 */
public class PlaceThreeSpaceTile extends Action {


    /*
        attributes
     */
    Location villagePlacement;
    Location[] ricePlacement = new Location[2];


    /*
        constructors
     */
    public PlaceThreeSpaceTile(){

    }
    public PlaceThreeSpaceTile(Location villagePlacement, Location rice1Placement, Location rice2Placement) {
        this.villagePlacement = villagePlacement;
        this.ricePlacement[0] = rice1Placement;
        this.ricePlacement[1] = rice2Placement;
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
        int famePoints = 0;     //todo replace with surround body of water
        int actionPoints = 1;   //todo plus however many placed outside of central java is extra.
        String message = "";

        //see if there is a three space tile to take from shared
        if(true){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: There are not have enough three space tiles.";
        }

        //Check if the player has enough action points
        if(game.canUseAPForLandTileAction(actionPoints)){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You do not have enough AP points.\n";
        }

        //check if they are placing on another three space tile
        if(true){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You cannot place on top of another three space.\n";
        }

        //check if they are not placing outside of central java
        if(true){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You cannot place outside Central Java.\n";
        }

        //see if all the spaces they are placing on are the same elevation
        if(true){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You cannot place on spaces with different elevations.\n";
        }

        //see if all the spaces they are placing on are the correct terrain
        if(true){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You cannot place a three space tile on this terrain.\n";
        }

        //see if they are placing on top of a developer
        if(true){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You cannot place on top of a developer.\n";
        }

        //see if they are connecting two cities
        if(true){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You cannot connect two cities.\n";
        }


        //todo

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

            //Decrememnt the AP points

            //decrement a three space tile from shared resources

            //place the tile components down on three locations

            //set has placed land boolean to true
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
