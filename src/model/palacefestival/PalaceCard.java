package model.palacefestival;

import java.util.List;

/**
 * Created by Baker on 4/14/2014.
 */
public class PalaceCard extends Card<PalaceCardComponent> {

    public PalaceCard(PalaceCardComponent... components) {

        super(components);

    }

    @Override
    public boolean equals(Object other) {

        boolean equal = false;

        if(other instanceof PalaceCard) {

            PalaceCard otherCard = (PalaceCard)other;
            List<PalaceCardComponent> myComponents = this.getComponents();
            List<PalaceCardComponent> otherComponents = otherCard.getComponents();
            equal = myComponents.size() == otherComponents.size();

            for (int i = 0; i < myComponents.size() && equal; i++) {

                equal &= (myComponents.get(i).equals(otherComponents.get(i)));

            }

        }

        return equal;

    }

}
