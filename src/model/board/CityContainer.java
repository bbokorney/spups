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

    //Returns the city in which this location exists. If location
    //is not in a city, return null.
    public City getCityFromLocation(Location loc) {
        for (City city : cityCollection)
            if (city.getCity().contains(loc))
                return city;
        return null;
    }

    public void removeLocationFromCity(Location loc, City city) {
        city.getCity().remove(loc);
        if (city.getCity().size() == 0)
            cityCollection.remove(city);
    }

    //TODO: add upgradePalace(Location, PalaceTileComponent)
}
