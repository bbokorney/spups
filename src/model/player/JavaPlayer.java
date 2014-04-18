package model.player;

import java.util.Collection;

/**
 * Created by Baker on 4/14/2014.
 */
public class JavaPlayer {

    private Player player;
    private JavaPlayerResources resources;

    public JavaPlayer(String name) {
        player = new Player(name);
        resources = new JavaPlayerResources();
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

    public Collection<Developer> getDevelopers() {return null;}

    public void useResource(JavaPlayerResourceType type)  {
        resources.useResource(type);
    }

}
