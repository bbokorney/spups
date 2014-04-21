package model.actions.developer;


import model.GameModel;
import model.actions.Action;
import model.actions.ActionResult;
import model.board.Location;
import model.actions.serialization.JsonObject;
import model.player.JavaPlayerResourceType;
import pathfinding.JavaPath;

/**
 * Created by idinamenzel on 4/14/14.
 */
public class PlaceDeveloperOnBoard extends Action {


     /*
        attributes
     */
    private Location locationOfDeveloperPlaced;
    private JavaPath path;
    GameModel game;


    /*
        constructors
     */
    public PlaceDeveloperOnBoard(){
        //Empty constructor
        //mostly used for loading
    }

    public PlaceDeveloperOnBoard(Location locationOfDeveloperPlaced, JavaPath path, GameModel game){
        this.locationOfDeveloperPlaced = locationOfDeveloperPlaced;
        this.path = path;
        this.game = game;
    }

    @Override
    public ActionResult tryAction() {

        boolean isSuccess = true;
        int famePoints = 0;         //will never gain fame points
        int actionPoints = 1;
        String message = "";

        //check if the player has a developer off the board
        if(game.getCount(JavaPlayerResourceType.DEVELOPER) > 0){//todo figure out if these are developers off the board
            isSuccess = isSuccess && true;
        }
        else{
            isSuccess = isSuccess && false;
            message += "You do not have any more developers.\n";
        }

        if(path != null && path.valid()){
            isSuccess = isSuccess && true;
            actionPoints += path.getCost();
        }
        else{
            isSuccess = isSuccess && false;
            message += "You cannot travel an invalid path.\n";
        }

        if( game.canUseAPForNonLandTileAction(actionPoints)){
            isSuccess = isSuccess && true;
        }
        else{
            isSuccess = isSuccess && false;
            message += "Error: You do not have enough AP.";
        }

        if(message.equalsIgnoreCase("")){
            message += "Place Developer, AP " + actionPoints;
        }

        return new ActionResult(isSuccess, famePoints, actionPoints, message);
    }

    @Override
    public ActionResult doAction() {

        ActionResult result = tryAction();
        if(result.isSuccess()) {

            //Decrememnt the AP points the path cost
            game.useActionPoints(result.getActionPoints());

            //place the developer on the ending of the path
            game.placeDeveloperOnBoard(locationOfDeveloperPlaced);


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
        //reuse move developer around board

        return null;
    }

    @Override

    public PlaceDeveloperOnBoard restore(JsonObject actionToRestore) {
    /*
        Converts the JsonObject used when loading
        to restore the states/attributes of this action.

        Utilized JsonObject to accomplish this
     */

        //reuse move developer around board

        return this;
    }
}
