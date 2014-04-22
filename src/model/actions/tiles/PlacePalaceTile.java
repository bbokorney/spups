package model.actions.tiles;

import model.GameModel;
import model.actions.Action;
import model.actions.ActionResult;
import model.actions.serialization.JsonObject;
import model.board.Board;
import model.board.BoardRuleHelper;
import model.board.Location;
import model.rules.palace.HighestRankingPlayerRule;
import model.rules.palace.PalaceLevelCitySizeRule;
import model.rules.tiles.PalacePlacementRule;
import model.rules.tiles.PlaceTileOnDeveloperRule;
import model.sharedresources.SharedResourceType;
import model.tiles.PalaceTileComponent;
import model.tiles.Tile;

/**
 * Created by idinamenzel on 4/14/14.
 */
public class PlacePalaceTile extends Action {

    /*
        attributes
     */
    private int value;
    private Location placement;
    GameModel game;

    /*
        constructors
     */
    public PlacePalaceTile(){
        //Empty constructor
        //used for loading
    }

    public PlacePalaceTile(int value, Location placement, GameModel game){
        this.value = value;
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
        int famePoints = this.value/2;
        int actionPoints = 1;
        String message = "";

        Board board = game.getBoard();
        BoardRuleHelper helperJunk = new BoardRuleHelper(game);

        //Check if there are any palace tiles of this value in shared resources
        if(game.getCount(SharedResourceType.valueOf("PALACELEVEL" + value)) > 0){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: There are not enough palaces tiles.\n";
        }


        //Check if the player has enough AP points to complete this - 1 AP
        //ActionPointsRule

        if(game.canUseAPForNonLandTileAction(actionPoints)){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You do not have enough AP.\n";
        }


        //see if you are placing this on top of a village

        PalacePlacementRule terrainRule = new PalacePlacementRule(placement, board);
        if(terrainRule.buildAllowed()){
            isSuccess = isSuccess && true;

            /*
                Check other rules that only correspond to the placement location being a village
             */

            //Check if there is not already a palace in that city/village
            if(!game.isLocationInCity(placement)){
                isSuccess = isSuccess && true;

            }
            else{
                isSuccess = isSuccess && false;
                message += "Error: This is already a city with a palace.\n";
            }

            //Check if there are enough villages to make it a city
            if(PalaceLevelCitySizeRule.palaceLevelSizeAllowed(placement, board, value)){
                isSuccess = isSuccess && true;

            }
            else{
                isSuccess = isSuccess && false;
                message += "Error: There are not enough villages.\n";
            }

            //Check if the player is the highest ranked player in this city
            //HighestRankedPlayerInCityRule
            if(HighestRankingPlayerRule.highestRankingPlayerInVillageRule(game.getCurrentJavaPlayer(), placement, helperJunk, board)){
                isSuccess = isSuccess && true;

            }
            else{
                isSuccess = isSuccess && false;
                message += "Error: You are not the highest ranked player.\n";
            }

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: Palaces need to be built on villages.\n";
        }

        //Check if the player is attempting to place this tile on a
        //PlaceTileOnDeveloperRule
        if(PlaceTileOnDeveloperRule.canPlaceTile(game.getDevelopersFromAllPlayers(),placement) ){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You cannot place this tile on top of a developer.\n";
        }

        if(message.equalsIgnoreCase("")){
            message += "Palace Tile, AP " + actionPoints + ", Fame " + famePoints;
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

            //Decrememnt the AP point
            game.useActionPoints(result.getActionPoints());

            //place the palace on this location of the board
            game.buildPalace(placement, new PalaceTileComponent(new Tile(1), value));

            //award the player fame points
            game.incrementScore(result.getFamePoints());

            //set this location to palacesinteractedwith in the turn object
            game.addPalaceToCurrentTurnList(placement);

            //decremenet the number of this valued palace in the shared resources
            game.useResource(SharedResourceType.valueOf("PALACELEVEL" + value));

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

    public PlacePalaceTile restore(JsonObject actionToRestore) {
    /*
        Converts the JsonObject used when loading
        to restore the states/attributes of this action.

        Utilized JsonObject to accomplish this
     */
        return null;
    }
}
