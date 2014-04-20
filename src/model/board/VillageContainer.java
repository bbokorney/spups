package model.board;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Sachit on 4/15/2014.
 */
public class VillageContainer {
    private Collection<Village> villageCollection;

    public VillageContainer() {
        villageCollection = new ArrayList<Village>();
    }

    public Collection<Village> getVillages() {
        return villageCollection;
    }

    public void addVillage(Village v) {
        villageCollection.add(v);
    }

    public void removeVillage(Village... v) {
        for (Village village : v)
            villageCollection.remove(village);
    }

}
