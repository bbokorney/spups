package model.actions.tiles;

import model.actions.Action;
import model.actions.ActionResult;
import model.actions.serialization.JsonObject;
import model.board.Board;
import model.board.BoardRuleHelper;
import model.board.HexLocation;
import model.rules.tiles.PlacementOutsideCentralJavaRule;
import model.sharedresources.SharedResourceType;
import model.tiles.IrrigationTileComponent;
import model.tiles.Tile;

/**
 * Created by idinamenzel on 4/14/14.
 */
public class PlaceIrrigationTile extends Action {


    /*
        attributes
     */
    private HexLocation placement;


    /*
        constructors
     */
    public PlaceIrrigationTile(){
        //Empty constructor
        //used for loading
    }

    public PlaceIrrigationTile(HexLocation placement){
        this.placement = placement;
    }


    @Override
    public ActionResult tryAction() {
     /*
        Check if the action is valid to complete
        ...
        returns true if valid
                false if invalid
     */

        Board board = game.getBoard();
        BoardRuleHelper helperJunk = new BoardRuleHelper(game);

        boolean isSuccess = true;
        int famePoints = 0; //this gets modified in this method
        int actionPoints = 1;
        String message = "";

    //

        if(game.getCount(SharedResourceType.IRRIGATION) > 1){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: There are not have enough irrigation tiles.";
        }

        //Check if the player has enough AP points - 1
        if(game.cauUseAPForNonLandTileAction(actionPoints)){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You do not have enough AP points.\n";
        }

        //check if required elevation is 0
        if(game.isHeightAtLocation(0, placement)){

            isSuccess = isSuccess && true;
            //calculate the points earned by placing this
            famePoints += helperJunk.pointsEarnedFromIrrigationPlacement(placement);

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: The elevation is nonzero.\n";
        }

        //checks if the player is placing outside of central java
        if(PlacementOutsideCentralJavaRule.canPlaceOutsideCentralJava(board, helperJunk, placement)){
            isSuccess = isSuccess && true;
        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: This tile cannot be placed outside Central Java.\n";
        }


      return new ActionResult(isSuccess, famePoints, actionPoints, message, this);
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

            //Decrememnt the AP points it cost
            game.useActionPoints(result.getActionPoints());

            //Award the fame points to the player
            game.incrementScore(result.getFamePoints());

            //decrement the number of irrigation tiles from shared resources
            game.useResource(SharedResourceType.IRRIGATION);

            //place the tile on the board
            game.placeIrrigationTileComponent(placement, new IrrigationTileComponent(new Tile(1)));

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