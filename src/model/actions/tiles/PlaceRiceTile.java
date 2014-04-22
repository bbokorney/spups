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
import model.rules.tiles.PlaceTileOnDeveloperRule;
import model.rules.tiles.PlacementOnSameSizeTileRule;
import model.rules.tiles.PlacementOutsideCentralJavaRule;
import model.rules.tiles.RicePlacementRule;
import model.tiles.RiceTileComponent;
import model.tiles.Tile;

import java.util.HashMap;

/**
 * Created by idinamenzel on 4/14/14.
 */
public class PlaceRiceTile extends Action {


    /*
        attributes
     */
    Location placement;
    GameModel game;

    private HashMap<JavaPlayer, Integer> playersAwardedPoints;

    /*
        constructors
     */
    public PlaceRiceTile(){
        //Empty constructor
        //mostly used for loading
    }
    public PlaceRiceTile(Location placement, GameModel game){
        this.placement = placement;
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

        Board board = game.getBoard();
        BoardRuleHelper helperJunk = new BoardRuleHelper(game);

        boolean isSuccess = true;
        int famePoints = 0;         //this gets modified in this method
        int actionPoints = 1;       //will always cost 1 ap
        String message = "";



        //Check if the player has a rice tile to use
        if(game.getCount(JavaPlayerResourceType.RICE) > 0){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You do not have enough rice tiles. ";
        }

        //check if the player has enough AP, 1
        if(game.canUseAPForLandTileAction(actionPoints)){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You do not have enough AP. ";
        }

        //check if they are not placing outside of central java
        if(game.isHeightAtLocation(0, placement)){

            playersAwardedPoints = helperJunk.pointsEarnedFromLandPlacement(placement);
            if(playersAwardedPoints.containsKey(game.getCurrentJavaPlayer())){
                famePoints = playersAwardedPoints.get(game.getCurrentJavaPlayer());
            }

            if(PlacementOutsideCentralJavaRule.canPlaceOutsideCentralJava(board, helperJunk, placement)){

                actionPoints += PlacementOutsideCentralJavaRule.numberOutsideCentralJava(helperJunk, placement);

            }
            else{
                isSuccess = isSuccess && false;
                message += "Error: You cannot place outside Central Java. ";
            }
        }

        //Check if they are not placing on top of a one tile
        if(!PlacementOnSameSizeTileRule.placingOnSameTile(board, placement)){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You cannot place this on a one space tile. ";
        }

        //Check if they are placing this directly on the board or on another land tile
        RicePlacementRule terrainRule = new RicePlacementRule(placement, board);

        if(terrainRule.allowed()){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You cannot place a rice tile on this terrain. ";
        }

        //Check if the player is placing on top of a developer
        if(PlaceTileOnDeveloperRule.canPlaceTile(game.getDevelopersFromAllPlayers(), placement)){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You cannot place this tile on top of a developer. ";
        }

        if(message.equals("")){
            message += "Rice Tile, AP " + actionPoints + ", Fame " + famePoints;
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

            // decrement rice tiles in the players resources
            game.useResource(JavaPlayerResourceType.RICE);

            //award the player the fame points earned
            for(JavaPlayer p : playersAwardedPoints.keySet()){
                game.incrementScore(playersAwardedPoints.get(p), p);
            }

            //place the tile on the board
            game.placeRiceTileComponent(placement, new RiceTileComponent(new Tile(1)));

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

    public PlaceRiceTile restore(JsonObject actionToRestore) {
    /*
        Converts the JsonObject used when loading
        to restore the states/attributes of this action.

        Utilized JsonObject to accomplish this
     */
        return null;
    }
}