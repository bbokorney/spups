package model.palacefestival;

/**
 * Created by Baker on 4/14/2014.
 */
public class PalaceFestivalTurn extends CardGameTurn {

    private int numberCardsDrawn;

    public PalaceFestivalTurn() {
        numberCardsDrawn = 0;
    }

    @Override
    public void reset() {
        numberCardsDrawn = 0;
    }

    @Override
    public boolean canDrawCard() {
        return numberCardsDrawn < 2;
    }

    @Override
    public void recordDrawCard() {
        numberCardsDrawn++;
    }

}
