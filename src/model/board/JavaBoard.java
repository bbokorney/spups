package model.board;

import model.tiles.TileComponent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Baker on 4/14/2014.
 */
public class JavaBoard extends Board {

    //TODO:
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
    }

}
