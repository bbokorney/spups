package model.palacefestival;

import model.tiles.PalaceTileComponent;

import java.util.Stack;

/**
 * Created by Baker on 4/14/2014.
 */
public class PalaceFestival {

    private PalaceFestivalPlayers players;
    private PalaceFestivalResources resources;
    private PalaceTileComponent palace;
    private PalaceFestivalTurn turn;

    public PalaceFestival(PalaceTileComponent palace, Stack<Card> deck) {
        this.palace = palace;
        this.resources = new PalaceFestivalResources(deck);
        this.players = new PalaceFestivalPlayers();
    }

    public void addPlayer(PalaceFestivalPlayer player) {
        players.addPlayer(player);
    }

    public void removePlayer(PalaceFestivalPlayer player) {
        players.removePlayer(player);
    }

    public PalaceFestivalPlayer getCurrentPlayer() {
        return players.getCurrentPlayer();
    }

    public void advanceTurn() {
        players.advanceTurn();
        turn.reset();
    }

    public boolean canDrawCard() {
        return turn.canDrawCard();
    }

    public void recordDrawCard() {
        turn.recordDrawCard();
    }

    public Card peekAtFestivalCard() {
        return resources.peekAtFaceUpCard();
    }

    public Card drawFestivalCard() {
        return resources.drawFaceUpCard();
    }

    public Card drawDeckCard() {
        return resources.drawCardFromDeck();
    }

    public void discard(Card card) {
        resources.discard(card);
    }

}
