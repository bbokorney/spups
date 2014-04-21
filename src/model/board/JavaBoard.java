package model.board;

import model.tiles.TileComponent;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Baker on 4/14/2014.
 */
public class JavaBoard extends Board {

    /*
        for Village tile, check
        1) is it joining two (or more) villages
        2) is it its own village
        3) is it joining a village and a city
        for irrigation, check
        1) its own body of water?
        2) a new body of water?
        for rice, check
        1) are we splitting a village or city?
     */

    public void placeIrrigationTileComponent(Location loc, TileComponent tile){
        Space space = board.get(loc);
        space.accept(tile);

        //Check neighbors for n bodies of water
        List<Location> neighbors = loc.getNeighbors();
        ArrayList<BodyOfWater> bodiesToJoin = new ArrayList<BodyOfWater>();
        for (Location neighbor: neighbors) {
            for (BodyOfWater bodyOfWater : bodyOfWaterContainer.getBodiesOfWater()) {
                if (bodyOfWater.getLocations().contains(neighbor)) {
                    if (!bodiesToJoin.contains(bodyOfWater))
                        bodiesToJoin.add(bodyOfWater);
                }
            }
        }

        //If this is its own body of water
        if (bodiesToJoin.size() == 0) {
            BodyOfWater body = new BodyOfWater();
            body.add(loc);
            bodyOfWaterContainer.addBodyOfWater(body);
        }
        //If this joins 1 body of water
        else if (bodiesToJoin.size() == 1) {
            BodyOfWater body = bodiesToJoin.get(0);
            body.add(loc);
        }
        //If this joins > 1 body of water
        else {
            BodyOfWater newBody = new BodyOfWater();
            for (BodyOfWater body : bodiesToJoin) {
                for (Location waterLoc : body.getLocations()) {
                    newBody.add(loc);
                }
            }
            newBody.add(loc);
            bodyOfWaterContainer.removeBodyOfWater(bodiesToJoin.toArray(new BodyOfWater[0]));
            bodyOfWaterContainer.addBodyOfWater(newBody);
        }
    }

    public void placeRiceTileComponent(Location loc, TileComponent tile){
        Space space = board.get(loc);
        space.accept(tile);

        //Get all neighbors which are in a city
        List<Location> cityNeighbors = new ArrayList<Location>();
        for (Location neighbor: loc.getNeighbors()) {
            for (City city : cityContainer.getCityCollection()) {
                if (city.getCity().contains(neighbor))
                    cityNeighbors.add(neighbor);
            }
        }

        //Remove this location from a city if it was in one
        if (isLocationInCity(loc))
            cityContainer.removeLocationFromCity(loc);

        //Okay so here's the tough part. We're gonna go through each of our
        //city neighbors and basically make a new city out of it and its city
        //neighbors (found successively in a graph search). As we do this for
        //each city neighbor, all the cities which need to be split based
        //on this new rice tile placement will be split, and all the cities
        //which should not be split will be rejoined.
        for (Location neighbor : cityNeighbors) {
            //First get the original city to which this neighbor belonged
            City oldCity = cityContainer.getCityFromLocation(neighbor);

            //Now create a new city
            City newCity = new City(oldCity.getPalaceLocation(),
                                    oldCity.getPalaceTile());
            ArrayList<Location> city = makeCity(loc, oldCity.getPalaceLocation()
                                           , new HashMap<Location, Boolean>());
            newCity.add(city.toArray(new Location[0]));

            //Add this new city to citycontainer
            cityContainer.addCity(newCity);

            //Now we can safely remove the old city
            cityContainer.removeCity(oldCity);
        }
    }

    public void placeVillageTileComponent(Location loc, TileComponent tile){
        Space space = board.get(loc);
        space.accept(tile);

        //Check neighbors for n villages
        List<Location> neighbors = loc.getNeighbors();
        ArrayList<Village> villagesToJoin = new ArrayList<Village>();
        for (Location neighbor: neighbors) {
            for (Village village : villageContainer.getVillages()) {
                if (village.getLocations().contains(neighbor)) {
                    if (!villagesToJoin.contains(village))
                        villagesToJoin.add(village);
                }
            }
        }

        //If this is its own village
        if (villagesToJoin.size() == 0) {
            Village village = new Village();
            village.add(loc);
            villageContainer.addVillage(village);
    }
        //If this joins 1 village
        else if (villagesToJoin.size() == 1) {
            Village village = villagesToJoin.get(0);
            village.add(loc);
        }
        //If this joins > 1 village
        else {
            Village newVillage = new Village();
            for (Village village : villagesToJoin) {
                for (Location villageLoc : village.getLocations()) {
                    newVillage.add(loc);
                }
            }
            newVillage.add(loc);
            villageContainer.removeVillage(villagesToJoin.toArray(new Village[0]));
            villageContainer.addVillage(newVillage);
        }

        //Okay now we have to account for expanding a city
        //First check if any neighbor is in a city
        for (Location neighbor: neighbors) {
            if (isLocationInCity(neighbor)) {
                //If so, add this location (and any village its in) to the city
                City city = cityContainer.getCityFromLocation(neighbor);
                Village village = villageContainer.getVillageFromLocation(neighbor);
                for (Location villageLoc : village.getLocations()) {
                    city.add(villageLoc);
                }
                //Now remove the village cause it no longer is one
                villageContainer.removeVillage(village);
            }
        }



    }

    //This method will construct a City given a single location (which is
    //already in a city) and branch out to find all its city neighbors
    private ArrayList<Location> makeCity(Location loc, Location palaceLoc,
                                         HashMap<Location, Boolean> visited) {
        ArrayList<Location> locations = new ArrayList<Location>();
        if ((loc.equals(palaceLoc) || isLocationInCity(loc) &&
             !visited.get(loc))) {
            locations.add(loc);
            visited.put(loc, true);
            for (Location neighbor : loc.getNeighbors()) {
                locations.addAll(makeCity(neighbor, palaceLoc, visited));
            }
        }
        return locations;
    }

}
