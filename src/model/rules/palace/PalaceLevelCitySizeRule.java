package model.rules.palace;

import model.board.Board;
import model.board.City;
import model.board.Location;

import java.util.Collection;

/**
 * Created by Baker on 4/14/2014.
 */
public class PalaceLevelCitySizeRule {
    public static boolean palaceLevelSizeAllowed(Location location, Board board, int palaceLevel) {
        Collection<City> cities = board.getCityContainer().getCityCollection();
        // find the city this location is part of
        for(City city : cities) {
            if(city.getCity().contains(location) && city.getCity().size() > palaceLevel) {
                return true;
            }
        }
        return false;
    }
}
