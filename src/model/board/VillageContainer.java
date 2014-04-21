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

    //Returns the village in which this location exists. If location
    //is not in a village, return null.
    public Village getVillageFromLocation(Location loc) {
        for (Village village : villageCollection)
            if (village.getLocations().contains(loc))
                return village;
        return null;
    }

    public void removeLocationFromVillage(Location loc) {
        for (Village village : villageCollection) {
            village.remove(loc); //remember this does nothing if city doesn't hold loc
            //Remove this city if its size is 0 now
            if (village.getLocations().size() == 0)
                removeVillage(village);
        }
    }

}
