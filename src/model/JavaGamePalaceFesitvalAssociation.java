package model;

import model.board.Board;
import model.board.Location;
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
 */
public class JavaGamePalaceFestivalAssociation extends GameModel {

    private PalaceFestival palaceFestival;
    private JavaGameModel javaGame;
    
    public JavaGamePalaceFesitvalAssociation(JavaGameModel javaGame, PalaceFestival palaceFestival) {
        this.javaGame = javaGame;
        this.palaceFestival = palaceFestival;
    }
    
    public int getCount(SharedResourceType res) { return javaGame.getCount(res); }
    public void useResource(SharedResourceType res) { javaGame.useResource(res); }
    public int getCount(JavaPlayerResourceType res) { return javaGame.getCount(res); }
    public void useResource(JavaPlayerResourceType res) { javaGame.useResource(res); }

    @Override
    public boolean canUseAPForLandTileAction(int pointsToSpend) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean cauUseAPForNonLandTileAction(int pointsToSpend) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    //public int getAvailableAPPoints(boolean isLandTileAction) { return javaGame.getAvailableAPPoints(isLandTileAction); }
    /*  todo changed interface in game model and java game model to not have
        LOD and alternate anti-cohesion dealing with Action Points
        talk to meghan for clarification. Sorry to whoever is coding this!
        
    */

    public boolean hasUsedActionToken() { return javaGame.hasUsedActionToken(); }
    public void advanceJavaTurn() { javaGame.advanceTurn(); }
    public boolean canAdvanceJavaTurn() { return javaGame.canAdvanceTurn(); }
    public void beginFinalRound() { javaGame.beginFinalRound(); }
    public JavaPlayer getCurrentJavaPlayer() { return javaGame.getCurrentJavaPlayer(); }

    @Override
    public Collection<JavaPlayer> getJavaPlayers() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void placeTopTileComponent(Location loc, TileComponent tile) { javaGame.placeTopTileComponent(loc, tile); }
    public void getTopTileComponent(Location loc) { javaGame.getTopTileComponent(loc); }
    public String getName() { return javaGame.getName(); }
    public void incrementScore(int score) { javaGame.adjustScore(score); }
    public List<Developer> getDevelopers() { return javaGame.getDevelopers(); }

    @Override
    public Board getBoard() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void addPlayer(PalaceFestivalPlayer player) { palaceFestival.addPlayer(player); }
    public void removePlayer(PalaceFestivalPlayer player) { palaceFestival.removePlayer(player); }
    public PalaceFestivalPlayer getCurrentPalaceFestivalPlayer() { return palaceFestival.getCurrentPlayer(); }

    @Override
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

    @Override
    public void beginPalaceFestival(PalaceTileComponent palaceTileComponent, int bid, PalaceFestivalPlayer player) {
        palaceFestival.beginPalaceFestival(palaceTileComponent, bid, player);
    }

    @Override
    public void setHighestBid(int bid) {
        palaceFestival.setHighestBid(bid);
    }

    @Override
    public int getHighestBid() {
        // TODO
        throw new UnsupportedOperationException();
    }

    @Override
    public void useActionPoints(int actionPoints) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isHeightAtLocation(int i) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
