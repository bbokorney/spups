package model.palacefestival;

import java.util.Collection;

/**
 * Created by Baker on 4/14/2014.
 */
public abstract class FaceUpCardStrategy<T> {

    public abstract T getFaceUpCard(Collection<T> cards);

}
