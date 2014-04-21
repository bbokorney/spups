package model.actions.tiles;

import model.GameModel;
import model.actions.Action;
import model.actions.ActionResult;
import model.actions.serialization.JsonObject;
import model.board.Board;
import model.board.BoardRuleHelper;
import model.board.HexLocation;
import model.player.JavaPlayerResourceType;
import model.rules.tiles.*;
import model.tiles.Tile;
import model.tiles.VillageTileComponent;

/**
 * Created by idinamenzel on 4/14/14.
 */
public class PlaceVillageTile extends Action {


    /*
        attributes
     */
    HexLocation placement;
    GameModel game;

    /*
        constructors
     */
    public PlaceVillageTile(){

    }
    public PlaceVillageTile(HexLocation placement, GameModel game){
        this.placement = placement;
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
        boolean isSuccess = true;
        int famePoints = 0;         //this gets modified in this method
        int actionPoints = 1;
        String message = "";

        Board board = game.getBoard();
        BoardRuleHelper helperJunk = new BoardRuleHelper(game);

        //see if there is a village tile to take from player
        if(game.getCount(JavaPlayerResourceType.VILLAGE) > 0){
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
            message += "Error: You do not have enough AP.\n";
        }



        //see if all the spaces they are placing on are the same elevation
        if(SameElevationRule.sameElevation(game.getSpaceAtLocation(placement))){
            isSuccess = isSuccess && true;

            /*
                The rest of this stuff should only be checked if they are on the same elevation
             */
            //check if they are placing on another one tile
            if(!PlacementOnSameSizeTileRule.placingOnSameTile(board, placement)){
                isSuccess = isSuccess && true;

            }
            else{
                isSuccess = isSuccess && false;
                message += "Error: You cannot place this on top of another one space tile.\n";
            }

            if(game.isHeightAtLocation(0, placement)){
                famePoints += helperJunk.pointsEarnedFromLandPlacement(placement);
            }

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
        if(PlaceTileOnDeveloperRule.canPlaceTile(game.getDevelopers(),placement) ){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You cannot place this tile on top of a developer.\n";
        }

        //see if they are connecting two cities
        if(!ConnectionTwoCitiesRule.connectsCities(helperJunk, placement)){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You cannot connect cities.\n";
        }

        if(message.equalsIgnoreCase("")){
            message += "Village Tile, AP " + actionPoints + ", Fame " + famePoints;
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

            //Decrememnt the AP points
            game.useActionPoints(result.getActionPoints());

            // decrement the number of villages in player resources
            game.useResource(JavaPlayerResourceType.VILLAGE);

            // place the village component on the placement location
            game.placeVillageTileComponent(placement, new VillageTileComponent(new Tile(1)));


            //award the player the fame points earned
            game.incrementScore(result.getFamePoints());

            //set has placed land tile to true
            game.setHasPlacedLandTile(true);
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

