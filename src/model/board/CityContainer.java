package model.board;

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

    //TODO: add upgradePalace(Location, PalaceTileComponent)
}
