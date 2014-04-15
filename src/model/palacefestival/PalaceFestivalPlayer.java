package model.palacefestival;

import java.util.Collection;

/**
 * Created by Baker on 4/14/2014.
 */
public interface PalaceFestivalPlayer {

    public void playCard(Card card);

    public void takeCard(Card card);

    public void incrementScore();

    public Collection<Card> getHand();

    public int getScore();

}
