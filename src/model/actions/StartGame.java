package model.actions;

import model.GameModel;
import model.actions.serialization.JsonObject;
import model.palacefestival.JavaPlayerAdapter;
import model.palacefestival.PalaceFestival;
import model.player.JavaPlayer;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by idinamenzel on 4/14/2014.
 */
public class StartGame extends Action {


    int numberOfPlayers;
    String[] playerNames;
    String[] playerColors;
    GameModel game;
    PalaceFestival festival;

    /*
        Constructors
     */
    public StartGame(GameModel game, PalaceFestival festival){
        this.game = game;
        this.festival = festival;
        //Empty constructor
        //Most likely used during loading
    }

    public StartGame(int numberOfPlayers, String[] playerNames){
        this.numberOfPlayers = numberOfPlayers;
        this.playerNames = playerNames;
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
        int famePoints = 0;
        int actionPoints = 0;
        String message = "";

        //check to see if the number fo values is valid, between 2 and 4
        if(numberOfPlayers > 4 || numberOfPlayers < 2){
            isSuccess = isSuccess && false;
            message += "Please select 2 - 4 players";
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

            game.setPlayersInGame(playerNames);
            Collection<JavaPlayer> javaPlayers = game.getJavaPlayers();
            for( JavaPlayer player : javaPlayers) {
                festival.addPlayer(new JavaPlayerAdapter(player));
            }
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
