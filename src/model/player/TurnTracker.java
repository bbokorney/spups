package model.player;

import java.util.Collection;

/**
 * Created by Baker on 4/14/2014.
 */
public interface TurnTracker<T> {

    public void addPlayer(T player);

    public void removePlayer(T player);

    public Collection<Player> getPlayers();

    public T getCurrentPlayer();

    public void advanceTurn();

}
