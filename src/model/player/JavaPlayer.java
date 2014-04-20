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

    public void addDeveloper(Developer dev){
        developers.add(dev);
    };

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

    public void useDeveloper(Location loc) {
        resources.useResource(JavaPlayerResourceType.DEVELOPER);
        Developer dev = new Developer(loc);
        developers.add(dev);
    }

}
