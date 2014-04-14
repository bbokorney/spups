package model.palacefestival;

import java.util.List;

/**
 * Created by Baker on 4/14/2014.
 */
public abstract class PalaceCard {

    public abstract List<PalaceCardComponent> getComponents();

    @Override
    public abstract boolean equals(Object other);

}
