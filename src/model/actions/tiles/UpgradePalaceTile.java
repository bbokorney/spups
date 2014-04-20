package model.actions.tiles;

import model.GameModel;
import model.Pair;
import model.actions.Action;
import model.actions.ActionResult;
import model.actions.serialization.JsonObject;
import model.board.Board;
import model.board.BoardRuleHelper;
import model.board.Location;
import model.rules.tiles.PalacePlacementRule;

/**
 * Created by idinamenzel on 4/14/14.
 */
public class UpgradePalaceTile extends Action {


    /*
        attributes
     */
    int value;
    Location placement;

    /*
        constructors
     */
    public UpgradePalaceTile(){

    }
    public UpgradePalaceTile(Location placement, int value){
        this.value = value;
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
        int famePoints = this.value/2;
        int actionPoints = 1;
        String message = "";

        Board board = game.getBoard();
        BoardRuleHelper helperJunk = new BoardRuleHelper(game);

        //check if there are any palaces left in shared resources
        if(true){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: There are not have enough palace tiles.\n";
        }

        //check if the player has enough action points, 1
        if(game.cauUseAPForNonLandTileAction(actionPoints)){
            isSuccess = isSuccess && true;

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You do not have enough action points.\n";
        }

        //Check if the placement is a palace tile
        PalacePlacementRule terrainRule = new PalacePlacementRule(placement, board); //todo wait for Baker
        if(terrainRule.buildAllowed()){
            isSuccess = isSuccess && true;


            /*
            All these after should only be done if the thingy is a palace tile
             */

            //See if the tile has been interacted with this turn
            if(true){
                isSuccess = isSuccess && true;

            }
            else{
                isSuccess = isSuccess && false;
                message += "Error: This palace has already been interacted with this turn.\n";
            }

            //see if the value is less than the palace underneath
            if(true){
                isSuccess = isSuccess && true;

            }
            else{
                isSuccess = isSuccess && false;
                message += "Error: You may only upgrade to a higher-valued palace.\n";
            }

            //check if the player is the highest ranked in the city
            if(true){
                isSuccess = isSuccess && true;

            }
            else{
                isSuccess = isSuccess && false;
                message += "Error: You are not the highest ranked player.\n";
            }

            //check if there are enough villages in the city to support a palace of this value
            if(true){
                isSuccess = isSuccess && true;

            }
            else{
                isSuccess = isSuccess && false;
                message += "Error: There are not enough villages.\n";
            }

        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: Only current palaces can be upgraded.";
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

            //Decrememnt the AP points the path cost
            //Move the developer along the path
            //(change the developer location to the last place on the path)
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