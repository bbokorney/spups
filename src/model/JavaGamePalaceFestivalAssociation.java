package model;

import model.board.Board;
import model.board.Location;
import model.board.Space;
import model.palacefestival.Card;
import model.palacefestival.PalaceFestival;
import model.palacefestival.PalaceFestivalPlayer;
import model.player.Developer;
import model.player.JavaPlayer;
import model.player.JavaPlayerResourceType;
import model.sharedresources.SharedResourceType;
import model.tiles.PalaceTileComponent;
import model.tiles.TileComponent;

import java.util.Collection;
import java.util.List;

/**
 * Created by Owner on 4/15/14.
 * THIS CLASS IS NOT USED. IT WAS A MISTAKE. PROTECTION WASN'T USED.
 */
public class JavaGamePalaceFestivalAssociation  {

    private PalaceFestival palaceFestival;
    private JavaGameModel javaGame;
    
    public JavaGamePalaceFestivalAssociation(JavaGameModel javaGame, PalaceFestival palaceFestival) {
        this.javaGame = javaGame;
        this.palaceFestival = palaceFestival;

        //Refer to the code below when creating the deck of cards,
        //doesn't have to happen here
/*        //Instantiate the palace festival and its deck of cards
        Stack<Card> deck = new Stack<Card>();
        for (int i = 0; i < 5; i++) {
            PalaceCard card = new PalaceCard(PalaceCardComponent.DRUM);
            deck.add(card);
        }
        for (int i = 0; i < 5; i++) {
            PalaceCard card = new PalaceCard(PalaceCardComponent.MASK);
            deck.add(card);
        }
        for (int i = 0; i < 5; i++) {
            PalaceCard card = new PalaceCard(PalaceCardComponent.PUPPET);
            deck.add(card);
        }
        for (int i = 0; i < 5; i++) {
            PalaceCard card = new PalaceCard(PalaceCardComponent.MASK,
                    PalaceCardComponent.PUPPET);
            deck.add(card);
        }
        for (int i = 0; i < 5; i++) {
            PalaceCard card = new PalaceCard(PalaceCardComponent.DRUM,
                    PalaceCardComponent.MASK);
            deck.add(card);
        }
        for (int i = 0; i < 5; i++) {
            PalaceCard card = new PalaceCard(PalaceCardComponent.DRUM,
                    PalaceCardComponent.PUPPET);
            deck.add(card);
        }*/
    }
    
    public int getCount(SharedResourceType res) { return javaGame.getCount(res); }
    public void useResource(SharedResourceType res) { javaGame.useResource(res); }
    public int getCount(JavaPlayerResourceType res) { return javaGame.getCount(res); }
    public void useResource(JavaPlayerResourceType res) { javaGame.useResource(res); }

    
    public boolean canUseAPForLandTileAction(int pointsToSpend) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    
    public boolean cauUseAPForNonLandTileAction(int pointsToSpend) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    //public int getAvailableAPPoints(boolean isLandTileAction) { return javaGame.getAvailableAPPoints(isLandTileAction); }
    /*  todo changed interface in game model and java game model to not have
        LOD and alternate anti-cohesion dealing with Action Points
        talk to meghan for clarification. Sorry to whoever is coding this!
        
    */

    public boolean hasUsedActionToken() { return javaGame.hasUsedActionToken(); }
    public void advanceJavaTurn() { javaGame.advanceJavaTurn(); }
    public boolean canAdvanceJavaTurn() { return javaGame.canAdvanceJavaTurn(); }
    public void beginFinalRound() { javaGame.beginFinalRound(); }
    public JavaPlayer getCurrentJavaPlayer() { return javaGame.getCurrentJavaPlayer(); }
    public void placeIrrigationTileComponent(Location loc, TileComponent tile) {
        javaGame.placeIrrigationTileComponent(loc, tile);
    }

    public void placeRiceTileComponent(Location loc, TileComponent tile) {
        javaGame.placeRiceTileComponent(loc, tile);
    }

    public void placeVillageTileComponent(Location loc, TileComponent tile) {
        javaGame.placeVillageTileComponent(loc, tile);
    }

    public void buildPalace(Location loc, TileComponent tile) {
        javaGame.buildPalace(loc, tile);
    }
    public void upgradePalace(Location loc, TileComponent tile) {
        javaGame.upgradePalace(loc, tile);
    }

    
    public Collection<JavaPlayer> getJavaPlayers() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void placeTopTileComponent(Location loc, TileComponent tile) { javaGame.placeTopTileComponent(loc, tile); }
    public void getTopTileComponent(Location loc) { javaGame.getTopTileComponent(loc); }
    public String getName() { return javaGame.getName(); }
    public void incrementScore(int score) { javaGame.incrementScore(score); }
    public List<Developer> getDevelopers() { return javaGame.getDevelopers(); }

    
    public Board getBoard() {
        return javaGame.getBoard();  //To change body of implemented methods use File | Settings | File Templates.
    }

    
    public void addPalaceToCurrentTurnList(Location loc) {
        javaGame.addPalaceToCurrentTurnList(loc);
    }

    
    public boolean hasPalaceLocationBeenUsedThisTurn(Location loc) {
        return javaGame.hasPalaceLocationBeenUsedThisTurn(loc);
    }

    public void addPlayer(PalaceFestivalPlayer player) { palaceFestival.addPlayer(player); }
    public void removePlayer(PalaceFestivalPlayer player) { palaceFestival.removePlayer(player); }
    public PalaceFestivalPlayer getCurrentPalaceFestivalPlayer() { return palaceFestival.getCurrentPlayer(); }

    
    public Collection<PalaceFestivalPlayer> getFestivalPlayers() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void advancePalaceFestivalTurn() { palaceFestival.advanceTurn(); }
    public boolean canDrawCard() { return palaceFestival.canDrawCard(); }
    public void recordDrawCard() { palaceFestival.recordDrawCard(); }
    public Card peekAtFestivalCard() { return palaceFestival.peekAtFestivalCard(); }
    public Card drawFestivalCard() { return palaceFestival.drawFestivalCard(); }
    public Card drawDeckCard() { return palaceFestival.drawDeckCard(); }
    public void discard(Card card) { palaceFestival.discard(card); }

    
    public void beginPalaceFestival(PalaceTileComponent palaceTileComponent, int bid, PalaceFestivalPlayer player) {
        palaceFestival.beginPalaceFestival(palaceTileComponent, bid, player);
    }

    
    public void endPalaceFestival() {
        palaceFestival.endPalaceFestival();
    }

    
    public void setHighestBid(int bid) {
        palaceFestival.setHighestBid(bid);
    }

    
    public int getHighestBid() {
        // TODO
        throw new UnsupportedOperationException();
    }

    
    public PalaceTileComponent getFestivalPalace() {
        return palaceFestival.getPalace();
    }

    
    public void useActionPoints(int actionPoints) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    
    public boolean isHeightAtLocation(int i, Location location) {
        return false;   //todo added methods from GameModel
    }

    
    public Space getSpaceAtLocation(Location location) {
        return null;   //todo added methods from GameModel
    }

}
