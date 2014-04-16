package model.player;

/**
 * Created by Baker on 4/14/2014.
 */
public class JavaPlayer {

    private Player player;

    public JavaPlayer(String name) {
        player = new Player(name);
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

    //TODO: Add other stuff from UML

}
