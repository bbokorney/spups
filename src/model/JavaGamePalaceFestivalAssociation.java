package model;

import model.board.Location;
import model.palacefestival.Card;
import model.palacefestival.PalaceFestival;
import model.palacefestival.PalaceFestivalPlayer;
import model.player.Developer;
import model.player.JavaPlayer;
import model.player.JavaPlayerResourceType;
import model.sharedresources.SharedResourceType;
import model.tiles.TileComponent;

import java.util.List;

/**
 * Created by Owner on 4/15/14.
 */
public class JavaGamePalaceFestivalAssociation {

    private PalaceFestival palaceFestival;
    private JavaGameModel javaGame;
    
    public JavaGamePalaceFestivalAssociation(JavaGameModel javaGame, PalaceFestival palaceFestival) {
        this.javaGame = javaGame;
        this.palaceFestival = palaceFestival;
    }
    
    public int getCount(SharedResourceType res) { return javaGame.getCount(res); }
    public void useResource(SharedResourceType res) { javaGame.useResource(res); }
    public int getCount(JavaPlayerResourceType res) { return javaGame.getCount(res); }
    public void useResource(JavaPlayerResourceType res) { javaGame.useResource(res); }
    public int getAvailableAPPoints(boolean isLandTileAction) { return javaGame.getAvailableAPPoints(isLandTileAction); }
    public boolean hasUsedActionToken() { return javaGame.hasUsedActionToken(); }
    public void advanceJavaTurn() { javaGame.advanceJavaTurn(); }
    public boolean canAdvanceJavaTurn() { return javaGame.canAdvanceJavaTurn(); }
    public void beginFinalRound() { javaGame.beginFinalRound(); }
    public JavaPlayer getCurrentJavaPlayer() { return javaGame.getCurrentJavaPlayer(); }
    public void placeTopTileComponent(Location loc, TileComponent tile) { javaGame.placeTopTileComponent(loc, tile); }
    public void getTopTileComponent(Location loc) { javaGame.getTopTileComponent(loc); }
    public String getName() { return javaGame.getName(); }
    public void incrementScore(int score) { javaGame.incrementScore(score); }
    public List<Developer> getDevelopers() { return javaGame.getDevelopers(); }

    public void addPlayer(PalaceFestivalPlayer player) { palaceFestival.addPlayer(player); }
    public void removePlayer(PalaceFestivalPlayer player) { palaceFestival.removePlayer(player); }
    public PalaceFestivalPlayer getCurrentPalaceFestivalPlayer() { return palaceFestival.getCurrentPlayer(); }
    public void advancePalaceFestivalTurn() { palaceFestival.advanceTurn(); }
    public boolean canDrawCard() { return palaceFestival.canDrawCard(); }
    public void recordDrawCard() { palaceFestival.recordDrawCard(); }
    public Card peekAtFestivalCard() { return palaceFestival.peekAtFestivalCard(); }
    public Card drawFestivalCard() { return palaceFestival.drawFestivalCard(); }
    public Card drawDeckCard() { return palaceFestival.drawDeckCard(); }
    public void discard(Card card) { palaceFestival.discard(card); }
}
