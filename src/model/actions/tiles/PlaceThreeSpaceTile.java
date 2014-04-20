package model.actions.tiles;


import model.actions.Action;
import model.actions.ActionResult;
import model.actions.serialization.JsonObject;
import model.board.Board;
import model.board.BoardRuleHelper;
import model.board.HexLocation;
import model.rules.tiles.*;
import model.sharedresources.SharedResourceType;

/**
 * Created by idinamenzel on 4/13/14.
 */
public class PlaceThreeSpaceTile extends Action {


    /*
        attributes
     */
    HexLocation villagePlacement;
    HexLocation[] ricePlacement = new HexLocation[2];


    /*
        constructors
     */
    public PlaceThreeSpaceTile(){

    }
    public PlaceThreeSpaceTile(HexLocation villagePlacement, HexLocation rice1Placement, HexLocation rice2Placement) {
        this.villagePlacement = villagePlacement;
        this.ricePlacement[0] = rice1Placement;
        this.ricePlacement[1] = rice2Placement;
    }


    @Override
    public ActionResult tryAction() {
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
        if(SameElevationRule.sameElevation(game.getSpaceAtLocation(villagePlacement),game.getSpaceAtLocation(ricePlacement[0]), game.getSpaceAtLocation(ricePlacement[1])) ){
            isSuccess = isSuccess && true;

            /*
                Check if the
            */
            if(game.isHeightAtLocation(0, villagePlacement) && PlacementOutsideCentralJavaRule.canPlaceOutsideCentralJava(board, helperJunk, villagePlacement, ricePlacement[0], ricePlacement[1])){
                isSuccess = isSuccess && true;
                actionPoints += PlacementOutsideCentralJavaRule.numberOutsideCentralJava(helperJunk,villagePlacement,ricePlacement[0], ricePlacement[1]);
                famePoints += helperJunk.pointsEarnedFromLandPlacement(villagePlacement, ricePlacement[0], ricePlacement[1]);

            }
            else{
                isSuccess = isSuccess && false;
                message += "Error: You cannot place outside Central Java.\n";
            }



        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You cannot place on spaces with different elevations.\n";
        }




        //see if there is a three space tile to take from shared
        if(game.getCount(SharedResourceType.THREE) > 1){
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
        if(PlacementOnSameSizeTileRule.placingOnSameTile(board, villagePlacement, ricePlacement[0], ricePlacement[1])){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You cannot place on top of another three space.\n";
        }

        //see if all the spaces they are placing on are the same elevation



        //see if all the spaces they are placing on are the correct terrain
        VillagePlacementRule villageTerrainRule = new VillagePlacementRule(villagePlacement, board);
        RicePlacementRule rice1TerrainRule = new RicePlacementRule(ricePlacement[0], board);
        RicePlacementRule rice2TerrainRule = new RicePlacementRule(ricePlacement[1], board);


        if(villageTerrainRule.allowed() && rice1TerrainRule.allowed() && rice2TerrainRule.allowed()){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You cannot place a three space tile on this terrain.\n";
        }

        //see if they are placing on top of a developer
        if(PlaceTileOnDeveloperRule.canPlaceTile(game.getDevelopers(), villagePlacement, ricePlacement[0], ricePlacement[1])){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You cannot place on top of a developer.\n";
        }

        //see if they are connecting two cities
        if(ConnectionTwoCitiesRule.connectsCities(villagePlacement,helperJunk)){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You cannot connect cities.\n";
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
