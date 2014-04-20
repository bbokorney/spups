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
import model.rules.tiles.PlacementOutsideCentralJavaRule;
import model.rules.tiles.VillagePlacementRule;

/**
 * Created by idinamenzel on 4/14/14.
 */
public class PlaceVillageTile extends Action {


    /*
        attributes
     */
    HexLocation placement;

    /*
        constructors
     */
    public PlaceVillageTile(){

    }
    public PlaceVillageTile(HexLocation placement){
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
        int famePoints = 0;         //this gets modified in this method
        int actionPoints = 1;
        String message = "";

        Board board = game.getBoard();
        BoardRuleHelper helperJunk = new BoardRuleHelper(game);

        //see if there is a village tile to take from player
        if(true){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You do not have enough village tiles.";
        }

        //Check if the player has enough action points
        if(game.canUseAPForLandTileAction(actionPoints)){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You do not have enough AP points.\n";
        }

        //check if they are placing on another one tile
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
        VillagePlacementRule terrainRule = new VillagePlacementRule(placement, board);

        if(terrainRule.allowed()){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You cannot place a village tile on this terrain.\n";
        }

        //see if they are placing on top of a developer
        if(true){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You cannot place this tile on top of a developer.\n";
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

            // decrement the number of villages in player resources

            // place the village component on the placement location

            //award the player the fame points earned
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

