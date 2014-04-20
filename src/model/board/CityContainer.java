package model.board;

import model.tiles.PalaceTileComponent;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Sachit on 4/15/2014.
 */
public class CityContainer {

    private Collection<City> cityCollection;

    public CityContainer() {
        cityCollection = new ArrayList<City>();
    }

    public Collection<City> getCityCollection() {
        return cityCollection;
    }

    //Returns the city in which this palace location exists. If location
    //is not a palace, return null.
    public City getCityFromPalaceLocation(Location loc) {
        for (City city : cityCollection)
            if (city.getPalaceLocation().equals(loc))
                return city;
        return null;
    }

    //TODO: add upgradePalace(Location, PalaceTileComponent)
}
