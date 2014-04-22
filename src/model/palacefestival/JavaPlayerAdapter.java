package model.palacefestival;

import model.player.JavaPlayer;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Baker on 4/14/2014.
 */
public class JavaPlayerAdapter implements PalaceFestivalPlayer {

    private JavaPlayer javaPlayer;
    private ArrayList<Card> hand;

    public JavaPlayerAdapter(JavaPlayer javaPlayer) {
        this.javaPlayer = javaPlayer;
        hand = new ArrayList<Card>();
    }

    @Override
    public void playCard(Card card) {
        if (hand.contains(card))
            hand.remove(card);
    }

    @Override
    public void takeCard(Card card) {
        hand.add(card);
    }

    @Override
    public void incrementScore() {
        javaPlayer.adjustScore(1);
    }

    @Override
    public Collection<Card> getHand() {
        return hand;
    }

    @Override
    public int getScore() {
        return javaPlayer.getScore();
    }
    
    @Override
    public String getPlayerName() { 
    	return javaPlayer.getName();
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof JavaPlayer) {
            JavaPlayer otherPlayer = (JavaPlayer)other;
            return otherPlayer.equals(this.javaPlayer);
        }

        return this == other;
    }

}
