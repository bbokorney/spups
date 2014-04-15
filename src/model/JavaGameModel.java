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
public class JavaGameModel {

    
    int getCount(SharedResourceType res) {
        return 0;
    }

    
    void useResource(SharedResourceType res) {

    }

    
    int getCount(JavaPlayerResourceType res) {
        return 0;
    }

    
    void useResource(JavaPlayerResourceType res) {

    }

    
    int getAvailableAPPoints(boolean isLandTileAction) {
        return 0;
    }

    
    boolean hasUsedActionToken() {
        return false;
    }

    
    void advanceTurn() {

    }

    
    boolean canAdvanceTurn() {
        return false;
    }

    
    void beginFinalRound() {

    }

    
    JavaPlayer getCurrentPlayer() {
        return null;
    }

    
    boolean placeTopTileComponent(Location loc, TileComponent tile) {
        return false;
    }

    
    void getTopTileComponent(Location loc) {

    }

    
    String getName() {
        return null;
    }

    
    void adjustScore(int score) {

    }

    
    List<Developer> getDevelopers() {
        return null;
    }
}
