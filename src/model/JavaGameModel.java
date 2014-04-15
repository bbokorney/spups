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
public class JavaGameModel extends GameModel{

    @Override
    int getCount(SharedResourceType res) {
        return 0;
    }

    @Override
    void useResource(SharedResourceType res) {

    }

    @Override
    int getCount(JavaPlayerResourceType res) {
        return 0;
    }

    @Override
    void useResource(JavaPlayerResourceType res) {

    }

    @Override
    int getAvailableAPPoints(boolean isLandTileAction) {
        return 0;
    }

    @Override
    boolean hasUsedActionToken() {
        return false;
    }

    @Override
    void advanceTurn() {

    }

    @Override
    boolean canAdvanceTurn() {
        return false;
    }

    @Override
    void beginFinalRound() {

    }

    @Override
    JavaPlayer getCurrentPlayer() {
        return null;
    }

    @Override
    boolean placeTopTileComponent(Location loc, TileComponent tile) {
        return false;
    }

    @Override
    void getTopTileComponent(Location loc) {

    }

    @Override
    String getName() {
        return null;
    }

    @Override
    void adjustScore(int score) {

    }

    @Override
    List<Developer> getDevelopers() {
        return null;
    }
}
