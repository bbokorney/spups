package model.player;

import java.util.ArrayList;
import java.util.List;

import model.board.Location;

/**
 * Created by Baker on 4/14/2014.
 */
public class JavaPlayer {

    private Player player;
    private JavaPlayerResources resources;
    private ArrayList<Developer> developers;

    public JavaPlayer(String name) {
        player = new Player(name);
        resources = new JavaPlayerResources();
        developers = new ArrayList<Developer>();
    }

    public String getName() {
        return player.getName();
    }

    public void adjustScore(int adjustment) {
        player.adjustScore(adjustment);
    }

    public int getScore() {
        return player.getScore();
    }



    public List<Developer> getDevelopers() {return developers;}

    public int getCount(JavaPlayerResourceType type) {
        return resources.getCount(type);
    }

    public void useResource(JavaPlayerResourceType type) {
        //check to make sure they are not calling this with developer
        if (type.equals(JavaPlayerResourceType.DEVELOPER))
            throw new IllegalArgumentException();
        resources.useResource(type);
    }

    public void addDeveloper(Location loc){
        /*
            This will place the developer on the board at the location given
            This will account for a developer being taken out of the player's resources
            and will then that developer to the Player's developer container
         */
        resources.useResource(JavaPlayerResourceType.DEVELOPER);
        Developer dev = new Developer(loc);
        developers.add(dev);
    }


    public void moveDeveloper(Location developerStartinglocation, Location developerEndingLocation) {
        /*
            This will move the developer around the board from the first location to the second location
            This will loop through all the developer's in the players container
            and change a developer's location accordingly
         */
        for(Developer d: developers){
            if(d.getLocation().equals(developerStartinglocation)){
                d.setLocation(developerEndingLocation);
                return;
            }
        }
    }

    public void removeDeveloper(Location developerLocationTakenOff) {
        /*
            This will remove the developer off the board that is at the location given
            This will remove the developer from the container that is at the given location
            and add a developer to their resources since they are now off the board
         */
        for(Developer d: developers){
            if(d.getLocation().equals(developerLocationTakenOff)){
                developers.remove(d);
                resources.addResource(JavaPlayerResourceType.DEVELOPER, 1);
                return;
            }
        }

    }
}
