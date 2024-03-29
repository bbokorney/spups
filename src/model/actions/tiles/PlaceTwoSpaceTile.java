package model.actions.tiles;

import model.GameModel;
import model.actions.Action;
import model.actions.ActionResult;
import model.actions.serialization.JsonObject;
import model.board.Board;
import model.board.BoardRuleHelper;
import model.board.Location;
import model.player.JavaPlayer;
import model.player.JavaPlayerResourceType;
import model.rules.tiles.*;
import model.tiles.RiceTileComponent;
import model.tiles.Tile;
import model.tiles.VillageTileComponent;

import java.util.HashMap;

/**
 * Created by idinamenzel on 4/14/14.
 */
public class PlaceTwoSpaceTile extends Action {


     /*
        attributes
     */
    Location villagePlacement;
    Location ricePlacement;
    GameModel game;

    private HashMap<JavaPlayer, Integer> playersAwardedPoints;
    /*
        constructors
     */
    public PlaceTwoSpaceTile(){

    }
    public PlaceTwoSpaceTile(Location villagePlacement, Location ricePlacement, GameModel game){
        this.villagePlacement = villagePlacement;
        this.ricePlacement = ricePlacement;
        this.game = game;
	    this.playersAwardedPoints = new HashMap<JavaPlayer, Integer>();
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


        //see if there is a two space tile to take from player
        if(game.getCount(JavaPlayerResourceType.TWO) > 0){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: There are not have enough two space tiles.";
        }

        //see if all the spaces they are placing on are the same elevation
        if(SameElevationRule.sameElevation(game.getSpaceAtLocation(villagePlacement), game.getSpaceAtLocation(ricePlacement))){
            isSuccess = isSuccess && true;

            //check if they are not placing outside of central java
                    //this should never work
            if(game.isHeightAtLocation(0, villagePlacement)){

                playersAwardedPoints = helperJunk.pointsEarnedFromLandPlacement(villagePlacement, ricePlacement);
                if(playersAwardedPoints.containsKey(game.getCurrentJavaPlayer())){
                    famePoints = playersAwardedPoints.get(game.getCurrentJavaPlayer());
                }

                if(PlacementOutsideCentralJavaRule.canPlaceOutsideCentralJava(board, helperJunk, villagePlacement, ricePlacement)){

                    actionPoints += PlacementOutsideCentralJavaRule.numberOutsideCentralJava(helperJunk, villagePlacement, ricePlacement);

                }
                else{
                    isSuccess = isSuccess && false;
                    message += "Error: You cannot place outside Central Java. ";
                }
            }

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You cannot place on spaces with different elevations.\n";
        }

        //Check if the player has enough action points
        if(game.canUseAPForLandTileAction(actionPoints)){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You do not have enough AP.\n";
        }

        //check if they are placing on another two space tile
        if(!PlacementOnSameSizeTileRule.placingOnSameTile(board, villagePlacement, ricePlacement)){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You cannot place this on top of another two space tile.\n";
        }

        //see if all the spaces they are placing on are the correct terrain
        VillagePlacementRule villageTerrainRule = new VillagePlacementRule(villagePlacement, board);
        RicePlacementRule riceTerrainRule = new RicePlacementRule(ricePlacement, board);

        if(villageTerrainRule.allowed() && riceTerrainRule.allowed()){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You cannot place a two space tile on this terrain.\n";
        }

        //see if they are placing on top of a developer
        if(PlaceTileOnDeveloperRule.canPlaceTile(game.getDevelopersFromAllPlayers(),villagePlacement,ricePlacement) ){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You cannot place this tile on top of a developer.\n";
        }

        //see if they are connecting two cities
        if(!ConnectionTwoCitiesRule.connectsCities(helperJunk, villagePlacement, ricePlacement)){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You cannot connect cities.\n";
        }

        if(message.equalsIgnoreCase("")){
            message += "Two Space Tile, AP " + actionPoints + ", Fame " + famePoints;
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

            //award the player the fame points earned
            for(JavaPlayer p : playersAwardedPoints.keySet()){
                game.incrementScore(playersAwardedPoints.get(p), p);
            }

            //decrement a two space tile from player resources
            game.useResource(JavaPlayerResourceType.TWO);

            //place the tile components down on three locations
            Tile twoSpaceTile = new Tile(2);
            game.placeVillageTileComponent(villagePlacement, new VillageTileComponent(twoSpaceTile));
            game.placeRiceTileComponent(ricePlacement, new RiceTileComponent(twoSpaceTile));

            //set has placed land boolean to true
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

