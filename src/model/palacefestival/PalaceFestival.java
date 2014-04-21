package model.palacefestival;

import model.tiles.PalaceTileComponent;

import java.util.Collection;
import java.util.Stack;

/**
 * Created by Baker on 4/14/2014.
 */
public class PalaceFestival {

    private int highestBid;
    private PalaceFestivalPlayers players;
    private PalaceFestivalResources resources;
    private PalaceTileComponent palace;
    private PalaceFestivalTurn turn;
    private State currentState;

    public PalaceFestival(PalaceTileComponent palace, Stack<Card> deck) {
        this.palace = palace;
        this.resources = new PalaceFestivalResources(deck);
        this.players = new PalaceFestivalPlayers();
        this.highestBid = 0;
        this.currentState = new DrawCardState();
    }

    public void addPlayer(PalaceFestivalPlayer player) {
        currentState.addPlayer(player);
    }

    public void removePlayer(PalaceFestivalPlayer player) {
        currentState.removePlayer(player);
    }

    public PalaceFestivalPlayer getCurrentPlayer() {
        return currentState.getCurrentPlayer();
    }

    public void setHighestBid(int bid) {
        highestBid = bid;
    }

    public int getHighestBid() {
        return highestBid;
    }

    public void advanceTurn() {
        currentState.advanceTurn();
    }

    public boolean canDrawCard() {
        return currentState.canDrawCard();
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

    public Collection<PalaceFestivalPlayer> getPlayers() {
        return currentState.getPlayers();
    }

    public PalaceTileComponent getPalace() {
        return palace;
    }

    public void beginPalaceFestival(PalaceTileComponent palace, int bid, PalaceFestivalPlayer player) {
        palace.flip();
        this.palace = palace;
        setHighestBid(bid);
        this.currentState = new FestivalState(player);
    }

    public void endPalaceFestival() {
        this.palace = null;
        this.highestBid = 0;
        this.currentState = new DrawCardState();
    }

    private interface State {

        public void addPlayer(PalaceFestivalPlayer player);
        public void removePlayer(PalaceFestivalPlayer player);
        public PalaceFestivalPlayer getCurrentPlayer();
        public void advanceTurn();
        public boolean canDrawCard();
        public Collection<PalaceFestivalPlayer> getPlayers();

    }

    private class FestivalState implements State {

        private PalaceFestivalPlayers festivalPlayers;

        public FestivalState(PalaceFestivalPlayer initiator) {
            festivalPlayers = new PalaceFestivalPlayers();
            for (PalaceFestivalPlayer player : festivalPlayers.getPlayers()) {
                festivalPlayers.addPlayer(player);
            }
            while (festivalPlayers.getCurrentPlayer() != initiator) {
                festivalPlayers.advanceTurn();
            }
        }

        public void addPlayer(PalaceFestivalPlayer player) {
            festivalPlayers.addPlayer(player);
        }

        public void removePlayer(PalaceFestivalPlayer player) {
            festivalPlayers.removePlayer(player);
        }

        public PalaceFestivalPlayer getCurrentPlayer() {
            return festivalPlayers.getCurrentPlayer();
        }

        public void advanceTurn() {
            festivalPlayers.advanceTurn();
        }

        public boolean canDrawCard(){
            return false;
        }

        public Collection<PalaceFestivalPlayer> getPlayers() {
            return festivalPlayers.getPlayers();
        }

    }

    private class DrawCardState implements State {

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

        public Collection<PalaceFestivalPlayer> getPlayers() {
            return players.getPlayers();
        }

    }

	public int getDeckSize() {
		return resources.getDeckSize();
	}

}
