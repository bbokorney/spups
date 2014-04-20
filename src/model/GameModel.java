package model;

import model.board.Board;
import model.board.Location;
import model.palacefestival.Card;
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
 * Created by Baker on 4/14/2014.
 */
public abstract class GameModel {

    public abstract int getCount(SharedResourceType res);
    public abstract void useResource(SharedResourceType res);
    public abstract int getCount(JavaPlayerResourceType res);
    public abstract void useResource(JavaPlayerResourceType res);
    public abstract boolean canUseAPForLandTileAction(int pointsToSpend);
    public abstract boolean cauUseAPForNonLandTileAction(int pointsToSpend);
    public abstract boolean hasUsedActionToken();
    public abstract void advanceJavaTurn();
    public abstract boolean canAdvanceJavaTurn();
    public abstract void beginFinalRound();
    public abstract JavaPlayer getCurrentJavaPlayer();
    public abstract Collection<JavaPlayer> getJavaPlayers();
    public abstract void placeTopTileComponent(Location loc, TileComponent tile);
    public abstract void getTopTileComponent(Location loc);
    public abstract String getName();
    public abstract void incrementScore(int score);
    public abstract List<Developer> getDevelopers();
    public abstract Board getBoard();

    public abstract void addPlayer(PalaceFestivalPlayer player);
    public abstract void removePlayer(PalaceFestivalPlayer player);
    public abstract PalaceFestivalPlayer getCurrentPalaceFestivalPlayer();
    public abstract Collection<PalaceFestivalPlayer> getFestivalPlayers();
    public abstract void advancePalaceFestivalTurn();
    public abstract boolean canDrawCard();
    public abstract void recordDrawCard();
    public abstract Card peekAtFestivalCard();
    public abstract Card drawFestivalCard();
    public abstract Card drawDeckCard();
    public abstract void discard(Card card);
    public abstract void beginPalaceFestival(PalaceTileComponent palaceTileComponent, int bid);
    public abstract void setHighestBid(int bid);


    public abstract void useActionPoints(int actionPoints);

    public abstract boolean isHeightAtLocation(int i);
}
