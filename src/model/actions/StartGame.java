package model.actions;

import model.GameModel;
import model.actions.serialization.JsonObject;

/**
 * Created by idinamenzel on 4/14/2014.
 */
public class StartGame extends Action {


    int numberOfPlayers;
    String[] playerNames;
    String[] playerColors;

    /*
        Constructors
     */
    StartGame(){
        //Empty constructor
        //Most likely used during loading
    }

    StartGame(int numberOfPlayers, String[] playerNames, String[] playerColors){
        this.numberOfPlayers = numberOfPlayers;
        this.playerNames = playerNames;
        this.playerColors = playerColors;
    }


    @Override
    public ActionResult tryAction() {
     /*
        Check if the action is valid to complete
        ...
        returns true if valid
                false if invalid
     */
        boolean isSuccess = false;
        int famePoints = 0;
        int actionPoints = 0;
        String message = "";

        //see if these are valid...?

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
        ActionResult result = tryAction();
        if(result.isSuccess()) {

            //start the game...?
        }
        return result;
    }

    @Override
    /*
        Formats the attributes of this object
        into a String that can be used
        for loading and saving.

        Utilizes Json and JsonObject to accomplish this.
     */
    public String serialize() {
        return null;
//        return Json.wrapObject(Json.wrapElements(
//                Json.wrapPair("numberOfPlayers", Json.wrapValue(numberOfPlayers + "")),
//                Json.wrapPair("playerNames", Json.wrapArray(playerNames)),
//                Json.wrapPair("playerColors", Json.wrapArray(playerColors))
//        ));
    }

    @Override
    public StartGame restore(JsonObject actionToRestore) {

    /*
        Converts the JsonObject used when loading
        to restore the states/attributes of this action.

        Utilized JsonObject to accomplish this
     */
        /*
            Set the numberOfPlayers integer
         */
        numberOfPlayers = Integer.parseInt(actionToRestore.getString("numberOfPlayers"));

        /*
            Initialize the size of the playerNames and playerColors to be
            set in a further section
         */
        playerNames = new String[numberOfPlayers];
        playerColors = new String[numberOfPlayers];

        /*
            grab the arrays storing the strings for playerColors and playerNames
            in the JsonObject
         */
        Object[] temporaryPlayerNames= (Object[])actionToRestore.getObject("playerNames");
        Object[] temporaryPlayerColors= (Object[])actionToRestore.getObject("playerColors");

        /*
            Set the strings in the playerNames and playerColors
            todo
         */
        for (int i = 0; i < numberOfPlayers; i++){
//            playerNames[i] =
//            playerColors[i] =

        }

        return this;

    }
}
