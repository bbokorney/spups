package model.palacefestival;

import java.util.Collection;

/**
 * Created by Baker on 4/14/2014.
 */
public interface PalaceFestivalPlayer {

    public void playCard(PalaceCard card);

    public void takeCard(PalaceCard card);

    public void incrementScore();

    public Collection<PalaceCard> getHand();

    public int getScore();

}
