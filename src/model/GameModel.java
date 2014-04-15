package model;

import model.board.Location;
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
    abstract int getCount(SharedResourceType res);
    abstract void useResource(SharedResourceType res);
    abstract int getCount(JavaPlayerResourceType res);
    abstract void useResource(JavaPlayerResourceType res);
    abstract int getAvailableAPPoints(boolean isLandTileAction);
    abstract boolean hasUsedActionToken();
    abstract void advanceTurn();
    abstract boolean canAdvanceTurn();
    abstract void beginFinalRound();
    abstract JavaPlayer getCurrentPlayer();
    abstract boolean placeTopTileComponent(Location loc, TileComponent tile);
    abstract void getTopTileComponent(Location loc);
    abstract String getName();
    abstract void adjustScore(int score);
    abstract List<Developer> getDevelopers();

}
