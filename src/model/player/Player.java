package model.player;

/**
 * Created by Baker on 4/14/2014.
 */
public class Player {

    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public void adjustScore(int adjustment) {
        score += adjustment;
    }

    public int getScore() {
        return score;
    }


}
