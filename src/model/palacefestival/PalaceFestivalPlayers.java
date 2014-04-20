package model.palacefestival;

import model.player.TurnTracker;

import java.util.ArrayList;

/**
 * Created by Baker on 4/14/2014.
 */
public class PalaceFestivalPlayers implements TurnTracker<PalaceFestivalPlayer> {

    private ArrayList<PalaceFestivalPlayer> players;
    private int currentPlayerIndex;

    public PalaceFestivalPlayers() {
        players = new ArrayList<PalaceFestivalPlayer>();
        currentPlayerIndex = 0;
    }

    @Override
    public void addPlayer(PalaceFestivalPlayer player) {
        players.add(player);
    }

    @Override
    public void removePlayer(PalaceFestivalPlayer player) {
        int removedPlayerIndex = players.indexOf(player);
        players.remove(player);
        if(removedPlayerIndex < currentPlayerIndex) {
            currentPlayerIndex--;
        }
        if (removedPlayerIndex >= players.size()) {
            currentPlayerIndex = 0;
        }
    }

    @Override
    public PalaceFestivalPlayer getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    @Override
    public void advanceTurn() {
        currentPlayerIndex++;
        currentPlayerIndex %= players.size();
    }
}
