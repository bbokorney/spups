package model.actions.tiles;

import model.GameModel;
import model.Pair;
import model.actions.Action;
import model.actions.ActionResult;
import model.actions.serialization.JsonObject;
import model.board.Board;
import model.board.BoardRuleHelper;
import model.board.HexLocation;
import model.board.Location;
import model.rules.tiles.*;

/**
 * Created by idinamenzel on 4/14/14.
 */
public class PlaceTwoSpaceTile extends Action {


     /*
        attributes
     */
    HexLocation villagePlacement;
    HexLocation ricePlacement;
    /*
        constructors
     */
    public PlaceTwoSpaceTile(){

    }
    public PlaceTwoSpaceTile(HexLocation villagePlacement, HexLocation ricePlacement){
        this.villagePlacement = villagePlacement;
        this.ricePlacement = ricePlacement;
    }

    @Override
    public ActionResult tryAction(GameModel game) {
     /*
        Check if the action is valid to complete
        ...
        returns true if valid
                false if invalid
     */

        BoardRuleHelper helperJunk = new BoardRuleHelper(game);
        Board board = game.getBoard();

        boolean isSuccess = true;
        int famePoints = 0;     //this number may get incremented in the first if statement of this method
        int actionPoints = 1;   // this number may get incremented in the first if statement of this method
                                //to account for placing outside of central java
        String message = "";

        //Check for the extra AP that this move will cost
        //this only needs (and can only be checked) when the height is 0
        // meaning the tile is being placed directly onto the board

        //check if they are not placing outside of central java
        if(game.isHeightAtLocation(0) && PlacementOutsideCentralJavaRule.canPlaceOutsideCentralJava(board, helperJunk, villagePlacement, ricePlacement)){
            isSuccess = isSuccess && true;
            actionPoints += PlacementOutsideCentralJavaRule.numberOutsideCentralJava(helperJunk,villagePlacement,ricePlacement);
            famePoints += PlacementOutsideCentralJavaRule.numberOutsideCentralJava(helperJunk,villagePlacement,ricePlacement);

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You cannot place this outside Central Java.\n";
        }

        //see if there is a two space tile to take from player
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

        //check if they are placing on another two space tile
        if(true){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You cannot place this on top of another three space.\n";
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
        VillagePlacementRule villageTerrainRule = new VillagePlacementRule(villagePlacement, board);
        RicePlacementRule riceTerrainRule = new RicePlacementRule(ricePlacement, board);

        if(villageTerrainRule.allowed() && riceTerrainRule.allowed(){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You cannot place a two space tile on this terrain.\n";
        }

        //see if they are placing on top of a developer
        if(PlaceTileOnDeveloperRule.canPlaceTile(game,villagePlacement,ricePlacement) ){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You cannot place this tile on top of a developer.\n";
        }

        //see if they are connecting two cities
        if(ConnectionTwoCitiesRule.connectsCities(villagePlacement, helperJunk)){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You cannot connect cities.\n";
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

            //decrement a two space tile from player resources

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

