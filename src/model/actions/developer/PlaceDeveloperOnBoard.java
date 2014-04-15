package model.actions.developer;


/**
 * Created by idinamenzel on 4/14/14.
 */
public class PlaceDeveloperOnBoard extends Action {


     /*
        attributes
     */
    private Location locationOfDeveloperPlaced;
    private Location[] path;


    /*
        constructors
     */
    PlaceDeveloperOnBoard(){
        //Empty constructor
        //mostly used for loading
    }

    PlaceDeveloperOnBoard(Location locationOfDeveloperPlaced, Location[] path){
        this.locationOfDeveloperPlaced = locationOfDeveloperPlaced;
        this.path = path;
    }

    @Override
    public ActionResult tryAction(GameModel game) {

        boolean isSuccess = true;
        int famePoints = 0;         //will never gain fame points
        int actionPoints = 1;       //todo add the cost of the path
        String message = "";

        //check if the player has a developer off the board

        //Check if the path is valid

        //Check if the player has enough AP points to travel the path


        //todo

        return new ActionResult(isSuccess, famePoints, actionPoints, message, this);
    }

    @Override
    public ActionResult doAction(GameModel game) {

        ActionResult result = tryAction(game);
        if(result.isSuccess()) {

            //Decrememnt the AP points the path cost
            //place the developer on the ending of the path
            //increment the number of developers on the board
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
