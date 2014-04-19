package model.player;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Sachit on 4/18/2014.
 */
public class JavaPlayers implements TurnTracker<JavaPlayer> {

    private ArrayList<JavaPlayer> players;
    private int currentPlayer;

    public JavaPlayers(int numPlayers) {
        players = new ArrayList<JavaPlayer>();
        currentPlayer = 0;
    }

    public void addPlayer(JavaPlayer player){
        players.add(player);
    }

    public void removePlayer(JavaPlayer player){
        players.remove(player);
    }

    public Collection<JavaPlayer> getPlayers(){
        return players;
    }

    public JavaPlayer getCurrentPlayer(){
        return players.get(currentPlayer);
    }

    public void advanceTurn(){
        currentPlayer++;
    }

}
