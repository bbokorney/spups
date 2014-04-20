package model;

import model.board.Location;
import model.palacefestival.Card;
import model.palacefestival.PalaceFestivalPlayer;
import model.player.Developer;
import model.player.JavaPlayer;
import model.player.JavaPlayerResourceType;
import model.sharedresources.SharedResourceType;
import model.tiles.TileComponent;

import java.util.List;

/**
 * Created by Baker on 4/14/2014.
 */
public abstract class GameModel {

    public abstract int getCount(SharedResourceType res);
    public abstract void useResource(SharedResourceType res);
    public abstract int getCount(JavaPlayerResourceType res);
    public abstract void useResource(JavaPlayerResourceType res);
    public abstract int getAvailableAPPoints(boolean isLandTileAction);
    public abstract boolean hasUsedActionToken();
    public abstract void advanceJavaTurn();
    public abstract boolean canAdvanceJavaTurn();
    public abstract void beginFinalRound();
    public abstract JavaPlayer getCurrentJavaPlayer();
    public abstract boolean placeTopTileComponent(Location loc, TileComponent tile);
    public abstract void getTopTileComponent(Location loc);
    public abstract String getName();
    public abstract void incrementScore(int score);
    public abstract List<Developer> getDevelopers();

    public abstract void addPlayer(PalaceFestivalPlayer player);
    public abstract void removePlayer(PalaceFestivalPlayer player);
    public abstract PalaceFestivalPlayer getCurrentPalaceFestivalPlayer();
    public abstract void advancePalaceFestivalTurn();
    public abstract boolean canDrawCard();
    public abstract void recordDrawCard();
    public abstract Card peekAtFestivalCard();
    public abstract Card drawFestivalCard();
    public abstract Card drawDeckCard();
    public abstract void discard(Card card);

}
