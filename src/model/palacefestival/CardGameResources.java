package model.palacefestival;

import java.util.Stack;

/**
 * Created by Baker on 4/14/2014.
 */
public interface CardGameResources<T> {

    public abstract T peekAtFaceUpCard();

    public abstract T drawFaceUpCard();

    public abstract T drawCardFromDeck();

    public abstract boolean drawSpecificCardFromDeck(T card);

    public abstract void discard(T card);

    public abstract void shuffleUnusedDeck();

    public abstract boolean doesDeckHaveCard();
}
