package model;

import model.board.Board;
import model.board.HexLocation;
import model.board.Location;
import model.board.Space;
import model.palacefestival.Card;
import model.palacefestival.PalaceFestivalPlayer;
import model.player.Developer;
import model.player.JavaPlayer;
import model.player.JavaPlayerResourceType;
import model.player.Player;
import model.sharedresources.SharedResourceType;
import model.tiles.PalaceTileComponent;
import model.tiles.TileComponent;
import model.turn.Turn;

import java.util.Collection;
import java.util.List;

/**
 * Created by Baker on 4/14/2014.
 */
public abstract class GameModel {

	public abstract Turn getTurn();
    public abstract void setPlayersInGame(String[] playerNames);
    public abstract int getCount(SharedResourceType res);
    public abstract void useResource(SharedResourceType res);
    public abstract int getCount(JavaPlayerResourceType res);
    public abstract void useResource(JavaPlayerResourceType res);
    public abstract boolean canUseAPForLandTileAction(int pointsToSpend);
    public abstract boolean canUseAPForNonLandTileAction(int pointsToSpend);
    public abstract boolean hasUsedActionToken();
    public abstract void advanceJavaTurn();
    public abstract boolean canAdvanceJavaTurn();
    public abstract void beginFinalRound();
    public abstract JavaPlayer getCurrentJavaPlayer();
    public abstract Collection<JavaPlayer> getJavaPlayers();
    //public abstract void placeTopTileComponent(Location loc, TileComponent tile);
    public abstract void getTopTileComponent(Location loc);
    public abstract String getName();
    public abstract void incrementScore(int score);
    public abstract List<Developer> getDevelopers();
    public abstract List<Developer> getDevelopersFromAllPlayers();
    public abstract Board getBoard();
    public abstract void addPalaceToCurrentTurnList(Location loc);
    public abstract boolean hasPalaceLocationBeenUsedThisTurn(Location loc);
    public abstract void placeIrrigationTileComponent(Location loc, TileComponent tile);
    public abstract void placeRiceTileComponent(Location loc, TileComponent tile);
    public abstract void placeVillageTileComponent(Location loc, TileComponent tile);
    public abstract void buildPalace(Location loc, PalaceTileComponent tile);
    public abstract void upgradePalace(Location loc, PalaceTileComponent tile);
    public abstract void useActionPoints(int actionPoints);
    public abstract boolean isHeightAtLocation(int i, Location location);
    public abstract boolean isLocationInCity(Location loc);
    public abstract void incrementScore(int score, JavaPlayer player);

    //Okay this was some old stuff from when we
/*    public abstract void addPlayer(PalaceFestivalPlayer player);
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
    public abstract void beginPalaceFestival(PalaceTileComponent palaceTileComponent, int bid, PalaceFestivalPlayer player);
    public abstract void endPalaceFestival();
    public abstract void setHighestBid(int bid);
    public abstract int getHighestBid();
    public abstract PalaceTileComponent getFestivalPalace();*/

    public abstract void setHasPlacedLandTile(boolean hasPlacedLandTile);

    public abstract void placeDeveloperOnBoard(Location locationOfDeveloperPlaced);

    public abstract Space getSpaceAtLocation(Location villagePlacement);

    public abstract void takeDeveloperOffBoard(Location developerLocationTakenOff);

    public abstract void moveDeveloperAroundBoard(Location developerStartinglocation, Location developerEndingLocation);

    public abstract List<Location> getLocationsOfCurrentPlayersDevelopers();

    public abstract void resetStates();

}
