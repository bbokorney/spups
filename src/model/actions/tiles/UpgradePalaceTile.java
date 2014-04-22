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
import model.sharedresources.SharedResourceType;
import model.tiles.PalaceTileComponent;
import model.tiles.Tile;

/**
 * Created by idinamenzel on 4/14/14.
 */
public class UpgradePalaceTile extends Action {


    /*
        attributes
     */
    int value;
    Location placement;
    GameModel game;

    /*
        constructors
     */
    public UpgradePalaceTile(){

    }
    public UpgradePalaceTile(Location placement, int value, GameModel game){
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

        //check if there are any palaces left in shared resources
        if(game.getCount(SharedResourceType.valueOf("PALACE" + value)) > 1){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: There are not have enough palace tiles.\n";
        }

        //check if the player has enough action points, 1
        if(game.canUseAPForNonLandTileAction(actionPoints)){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You do not have enough AP.\n";
        }

        //Check if the placement is a palace tile
        PalacePlacementRule terrainRule = new PalacePlacementRule(placement, board);
        if(terrainRule.upgradeAllowed(value)){
            isSuccess = isSuccess && true;


            /*
            All these after should only be done if the thingy is a palace tile
             */
            //See if the tile has been interacted with this turn
            if(game.hasPalaceLocationBeenUsedThisTurn(placement)){
                isSuccess = isSuccess && true;

            }
            else{
                isSuccess = isSuccess && false;
                message += "Error: This palace has already been interacted with this turn.\n";
            }

            //check if the player is the highest ranked in the city
            if(HighestRankingPlayerRule.highestRankingPlayerInCityRule(game.getCurrentJavaPlayer(), placement, helperJunk, board)){
                isSuccess = isSuccess && true;

            }
            else{
                isSuccess = isSuccess && false;
                message += "Error: You are not the highest ranked player.\n";
            }

            //check if there are enough villages in the city to support a palace of this value
            if(PalaceLevelCitySizeRule.palaceLevelSizeAllowed(placement, board, value)){
                isSuccess = isSuccess && true;

            }
            else{
                isSuccess = isSuccess && false;
                message += "Error: There are not enough villages.\n";
            }

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: This palace cannot be upgraded.\n";
        }

        if(message.equalsIgnoreCase("")){
            message += "Upgrade Palace, AP " + actionPoints + ", Fame " + famePoints;
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
            game.upgradePalace(placement, new PalaceTileComponent(new Tile(1), value));

            //award the player fame points
            game.incrementScore(result.getFamePoints());

            //set this location to palacesinteractedwith in the turn object
            game.addPalaceToCurrentTurnList(placement);

            //decremenet the number of this valued palace in the shared resources
            game.useResource(SharedResourceType.valueOf("PALACE" + value));
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