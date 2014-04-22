package model.actions.tiles;

import model.GameModel;
import model.actions.Action;
import model.actions.ActionResult;
import model.actions.serialization.JsonObject;
import model.board.Board;
import model.board.BoardRuleHelper;
import model.board.Location;
import model.player.JavaPlayer;
import model.rules.tiles.PlacementOutsideCentralJavaRule;
import model.sharedresources.SharedResourceType;
import model.tiles.IrrigationTileComponent;
import model.tiles.Tile;

import java.util.HashMap;

/**
 * Created by idinamenzel on 4/14/14.
 */
public class PlaceIrrigationTile extends Action {


    /*
        attributes
     */
    private Location placement;
    GameModel game;

    private HashMap<JavaPlayer, Integer> playersAwardedPoints;


    /*
        constructors
     */
    public PlaceIrrigationTile(){
        //Empty constructor
        //used for loading
    }

    public PlaceIrrigationTile(Location placement, GameModel game){
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

        Board board = game.getBoard();
        BoardRuleHelper helperJunk = new BoardRuleHelper(game);

        boolean isSuccess = true;
        int famePoints = 0; //this gets modified in this method
        int actionPoints = 1;
        String message = "";

    //

        if(game.getCount(SharedResourceType.IRRIGATION) > 0){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: There are not have enough irrigation tiles.";
        }

        //Check if the player has enough AP points - 1
        if(game.canUseAPForNonLandTileAction(actionPoints)){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You do not have enough AP.\n";
        }

        //check if required elevation is 0
        if(game.isHeightAtLocation(0, placement)){

            isSuccess = isSuccess && true;
            //calculate the points earned by placing this
            playersAwardedPoints = helperJunk.pointsEarnedFromIrrigationPlacement(placement);
            if(playersAwardedPoints.containsKey(game.getCurrentJavaPlayer())){
                famePoints = playersAwardedPoints.get(game.getCurrentJavaPlayer());
            }

            if(PlacementOutsideCentralJavaRule.canPlaceOutsideCentralJava(board, helperJunk, placement)){
                isSuccess = isSuccess && true;
            }
            else{
                isSuccess = isSuccess && false;
                message += "Error: This tile cannot be placed outside Central Java.\n";
            }

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: The elevation is nonzero.\n";
        }

        if(message.equalsIgnoreCase("")){
            message += "Irrigation Tile, AP " + actionPoints + ", Fame " + famePoints;
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

            //Decrememnt the AP points it cost
            game.useActionPoints(result.getActionPoints());

            //award the player the fame points earned
            for(JavaPlayer p : playersAwardedPoints.keySet()){
                game.incrementScore(playersAwardedPoints.get(p), p);
            }

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