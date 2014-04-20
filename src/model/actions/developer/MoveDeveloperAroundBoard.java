package model.actions.developer;

import model.actions.Action;
import model.actions.ActionResult;
import model.actions.serialization.JsonObject;
import model.board.Location;
import pathfinding.JavaPath;

/**
 * Created by idinamenzel on 4/14/14.
 */
public class MoveDeveloperAroundBoard extends Action {

    /*
        attributes
     */
    private Location developerStartinglocation;
    private JavaPath path;

    /*
        Constructors
     */
    public MoveDeveloperAroundBoard(){
        //Empty constructor
        //Most likely used for loading
    }

    public MoveDeveloperAroundBoard(Location developerStartinglocation, JavaPath path){
        this.developerStartinglocation = developerStartinglocation;
        this.path = path;
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
        int famePoints = 0;         //will always be 0
        int actionPoints = 0;       //todo add the cost of the path here
        String message = "";

        //Check if the path is valid

        //Check if the player has enough AP points to travel the path

        //todo

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
        //todo fix since JavaPath and other stuff

//        String[] pathToSerial = new String[path.length];
//        for(int i = 0; i < path.length; i++){
//            pathToSerial[i] = path[i].serialize();
//        }
            return null;
//        return Json.wrapObject(Json.wrapElements(
//                Json.wrapPair("developerStartingLocation", developerStartinglocation.serialize()),
//                Json.wrapPair("path", Json.serializeCollection(path))
//        ));

    }

    @Override
    public MoveDeveloperAroundBoard restore(JsonObject actionToRestore) {
    /*
        Converts the JsonObject used when loading
        to restore the states/attributes of this action.

        Utilized JsonObject to accomplish this
     */

        // get the developer starting location
        //todo restore shit
        //developerStartinglocation = (new Location()).loadObject(actionToRestore.getJsonObject("developerStartingLocation"));

        //get the temporary path of JsonObjects which store locations?
        //JsonObject[] temporaryPath = actionToRestore.getJsonObjectArray("path");

//        path = new Location[temporaryPath.length];

//        for(int i = 0; i < temporaryPath.length; i++){
////            path[i] = temporaryPath[i];
//        }




        return this;
    }
}

