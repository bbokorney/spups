package model.actions.tiles;

import model.GameModel;
import model.Pair;
import model.actions.Action;
import model.actions.ActionResult;
import model.actions.serialization.JsonObject;
import model.board.Board;
import model.board.BoardRuleHelper;
import model.board.HexLocation;
import model.player.JavaPlayerResourceType;
import model.rules.tiles.PlaceTileOnDeveloperRule;
import model.rules.tiles.PlacementOnSameSizeTileRule;
import model.rules.tiles.PlacementOutsideCentralJavaRule;
import model.rules.tiles.RicePlacementRule;

/**
 * Created by idinamenzel on 4/14/14.
 */
public class PlaceRiceTile extends Action {


    /*
        attributes
     */
    HexLocation placement;

    /*
        constructors
     */
    public PlaceRiceTile(){
        //Empty constructor
        //mostly used for loading
    }
    public PlaceRiceTile(HexLocation placement){
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

        Board board = game.getBoard();
        BoardRuleHelper helperJunk = new BoardRuleHelper(game);

        boolean isSuccess = true;
        int famePoints = 0;         //this gets modified in this method
        int actionPoints = 1;       //will always cost 1 ap
        String message = "";



        //Check if the player has a rice tile to use
        if(game.getCount(JavaPlayerResourceType.RICE) > 1){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You do not have enough rice tiles.\n";
        }

        //check if the player has enough AP, 1
        if(game.canUseAPForLandTileAction(actionPoints)){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You do not have enough AP points.\n";
        }

        //check if they are not placing outside of central java
        if(game.isHeightAtLocation(0, placement) && PlacementOutsideCentralJavaRule.canPlaceOutsideCentralJava(board, helperJunk, placement)){
            isSuccess = isSuccess && true;
            famePoints += helperJunk.pointsEarnedFromLandPlacement(placement);

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You cannot place outside Central Java.\n";
        }

        //Check if they are not placing on top of a one tile
        if(PlacementOnSameSizeTileRule.placingOnSameTile(board, placement)){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You cannot place this on a one space tile.\n";
        }

        //Check if they are placing this directly on the board or on another land tile
        RicePlacementRule terrainRule = new RicePlacementRule(placement, board);

        if(terrainRule.allowed()){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You cannot place a rice tile on this terrain.\n";
        }

        //Check if the player is placing on top of a developer
        if(PlaceTileOnDeveloperRule.canPlaceTile(game.getDevelopers(), placement)){
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
    public ActionResult doAction(GameModel game) {
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

    public PlaceRiceTile restore(JsonObject actionToRestore) {
    /*
        Converts the JsonObject used when loading
        to restore the states/attributes of this action.

        Utilized JsonObject to accomplish this
     */
        return null;
    }
}