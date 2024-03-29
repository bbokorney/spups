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
            System.out.println("Found a palace at " + city.getPalaceLocation());
            if(city.getCity().contains(location) && city.getCity().size() >= palaceLevel &&
                    palaceLevel > city.getPalaceLevel()) {
                return true;
            }
        }
        for(Village village : board.getVillageContainer().getVillages()) {
            System.out.println("Village was here" +
                    " of size " + village.getSize());
            if(village.getLocations().contains(location) &&
                    village.getLocations().size() >= palaceLevel) {
                return true;
            }
        }
        return false;
    }
}
