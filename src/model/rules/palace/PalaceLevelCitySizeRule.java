package model.rules.palace;

import model.board.Board;
import model.board.City;
import model.board.Location;
import model.board.Village;

import java.util.Collection;

/**
 * Created by Baker on 4/14/2014.
 */
public class PalaceLevelCitySizeRule {
    public static boolean palaceLevelSizeAllowed(Location location, Board board, int palaceLevel) {
        Collection<City> cities = board.getCityContainer().getCityCollection();
        // find the city this location is part of
        for(City city : cities) {
            if(city.getCity().contains(location) && city.getCity().size() >= palaceLevel) {
                return true;
            }
        }
        for(Village village : board.getVillageContainer().getVillages()) {
            if(village.getLocations().contains(location) &&
                    village.getLocations().size() >= palaceLevel) {

            }
        }
        return false;
    }
}
