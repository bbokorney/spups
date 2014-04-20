package model.board;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Sachit on 4/15/2014.
 */
public class BodyOfWaterContainer {
    private Collection<BodyOfWater> bodyOfWaterCollection;

    public BodyOfWaterContainer() {
        bodyOfWaterCollection = new ArrayList<BodyOfWater>();
    }

    public Collection<BodyOfWater> getBodiesOfWater() {
        return bodyOfWaterCollection;
    }

    public void addBodyOfWater(BodyOfWater b) {
        bodyOfWaterCollection.add(b);
    }
}
