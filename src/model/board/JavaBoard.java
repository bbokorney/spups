package model.board;

import model.tiles.PalaceTileComponent;
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
                    newBody.add(waterLoc);
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

        //CHECK FOR SPLITTING A CITY
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

        //CHECK FOR SPLITTING A VILLAGE
        //Get all neighbors which are in a city
        List<Location> villageNeighbors = new ArrayList<Location>();
        for (Location neighbor: loc.getNeighbors()) {
            for (Village village : villageContainer.getVillages()) {
                if (village.getLocations().contains(neighbor))
                    villageNeighbors.add(neighbor);
            }
        }

        //Remove this location from a village if it was in one
        if (isLocationInVillage(loc))
            villageContainer.removeLocationFromVillage(loc);

        //Okay so here's the tough part. We're gonna go through each of our
        //village neighbors and basically make a new village out of it and its
        //village neighbors (found successively in a graph search). As we do
        // this for each village neighbor, all the villages which need to be
        // split based on this new rice tile placement will be split, and all
        // the villages which should not be split will be rejoined.
        for (Location neighbor : villageNeighbors) {
            //First get the original city to which this neighbor belonged
            Village oldVillage = villageContainer.getVillageFromLocation(neighbor);

            //Now create a new city
            Village newVillage = new Village();
            ArrayList<Location> villages = makeVillage(loc, new HashMap<Location, Boolean>());
            newVillage.add(villages.toArray(new Location[0]));

            //Add this new city to citycontainer
            villageContainer.addVillage(newVillage);

            //Now we can safely remove the old city
            villageContainer.removeVillage(oldVillage);
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
                    newVillage.add(villageLoc);
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
        visited.put(loc, true);
        if ((loc.equals(palaceLoc) || isLocationInCity(loc) &&
             !visited.get(loc))) {
            locations.add(loc);
            for (Location neighbor : loc.getNeighbors()) {
                locations.addAll(makeCity(neighbor, palaceLoc, visited));
            }
        }
        return locations;
    }

    //This method will construct a village given a single location (which is
    //already in a village) and branch out to find all its village neighbors
    private ArrayList<Location> makeVillage(Location loc,
                                            HashMap<Location, Boolean> visited) {
        ArrayList<Location> locations = new ArrayList<Location>();
        visited.put(loc, true);
        if (isLocationInVillage(loc) && !visited.get(loc)) {
            locations.add(loc);
            for (Location neighbor : loc.getNeighbors()) {
                locations.addAll(makeVillage(neighbor, visited));
            }
        }
        return locations;
    }


    public void buildPalace(Location loc, PalaceTileComponent tile) {
        //First place this palace down
        Space space = board.get(loc);
        space.accept(tile);

        //Now convert all locations that were in this village to being in
        //a city
        City newCity = new City(loc, tile);
        newCity.add(loc);
        Village village = villageContainer.getVillageFromLocation(loc);
        for (Location location : village.getLocations()) {
            newCity.add(location);
            villageContainer.removeLocationFromVillage(location);
        }
        cityContainer.addCity(newCity);
        villageContainer.removeVillage(village);
    }

    public void upgradePalace(Location loc, PalaceTileComponent tile) {
        //First place this palace down
        Space space = board.get(loc);
        space.accept(tile);

        //Now make sure you update the city accordingly
        City city = cityContainer.getCityFromLocation(loc);
        city.placePalaceTile(tile);
    }
}
