package model.player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Sachit on 4/18/2014.
 */
public class JavaPlayers implements TurnTracker<JavaPlayer> {

    private ArrayList<JavaPlayer> players;
    private int currentPlayer;

    public JavaPlayers() {
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
        if (currentPlayer == players.size())
            currentPlayer = 0;
    }

    public List<Developer> getDevelopers() {
        ArrayList<Developer> developersFromAllPlayers = new ArrayList<Developer>();
        for(JavaPlayer p : players){
            developersFromAllPlayers.addAll(p.getDevelopers());
        }
        return developersFromAllPlayers;
    }
}
