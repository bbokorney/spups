package model;

import model.board.*;
import model.palacefestival.*;
import model.player.Developer;
import model.player.JavaPlayer;
import model.player.JavaPlayers;
import model.player.JavaPlayerResourceType;
import model.sharedresources.SharedResourceType;
import model.sharedresources.SharedResources;
import model.tiles.PalaceTileComponent;
import model.tiles.TileComponent;
import model.turn.FinalTurn;
import model.turn.NonFinalTurn;
import model.turn.Turn;

import java.util.Collection;
import java.util.List;
import java.util.Stack;

/**
 * Created by Baker on 4/14/2014.
 */
public class JavaGameModel extends GameModel{

    private SharedResources resources;
    private Board board;
    private JavaPlayers javaPlayers;
    private Turn turn;
    //The following value will be held at a sentinel value until the final
    //round, at which point it will decrement from the number of jplayers to 0.
    private int finalRoundTurns;

    public JavaGameModel(int numPlayers) {
        resources = new SharedResources();
        BoardCreator creator = new BoardCreator();
        board = creator.createBoard();
        javaPlayers = new JavaPlayers(numPlayers);
        finalRoundTurns = -1;
        turn = new NonFinalTurn();
    }

    public int getCount(SharedResourceType res) {
        return resources.getCount(res);
    }

    
    public void useResource(SharedResourceType res) {
        resources.useResource(res);
    }

    
    public int getCount(JavaPlayerResourceType res) {
        return getCurrentJavaPlayer().getCount(res);
    }

    
    public void useResource(JavaPlayerResourceType res) {
        getCurrentJavaPlayer().useResource(res);
    }

    public boolean canUseAPForLandTileAction(int pointsToSpend) {
        return turn.canUseAPForLandTileAction(pointsToSpend);
    }

    public boolean canUseAPForNonLandTileAction(int pointsToSpend) {
        return turn.canUseAPForNonLandTileAction(pointsToSpend);
    }

    
    public boolean hasUsedActionToken() {
        return turn.hasUsedActionToken();
    }

    
    public void advanceJavaTurn() {
        if (canAdvanceJavaTurn()) {
            //First check if we are in the final round, indicated by the
            //finalRoundTurns value being > 0
            if (finalRoundTurns > 0) {
                finalRoundTurns--;
                turn = new FinalTurn();
            } else
                turn = new NonFinalTurn();
            javaPlayers.advanceTurn();
        }
    }

    
    public boolean canAdvanceJavaTurn() {
        //If this is the last turn of the game, dont advance?
        if (turn.isFinalTurn() && finalRoundTurns <= 1)
            return false;
        else
            return turn.canEndTurn();
    }

    
    public void beginFinalRound() {
        finalRoundTurns = javaPlayers.getPlayers().size();
        turn = new FinalTurn();
    }

    public JavaPlayer getCurrentJavaPlayer() {
        return javaPlayers.getCurrentPlayer();
    }

    public Collection<JavaPlayer> getJavaPlayers() {
        return javaPlayers.getPlayers();
    }

    //NEVER USED.
/*    public void placeTopTileComponent(Location loc, TileComponent tile) {
        board.placeTopTileComponent(loc, tile);
    }*/

    
    public void getTopTileComponent(Location loc) {
        board.getTopTileComponent(loc);
    }

    
    public String getName() {
        return javaPlayers.getCurrentPlayer().getName();
    }

    
    public void incrementScore(int score) {
        int currentScore = getCurrentJavaPlayer().getScore();
        getCurrentJavaPlayer().adjustScore(currentScore + score);
    }

    
    public List<Developer> getDevelopers() {
        return getCurrentJavaPlayer().getDevelopers();
    }

    public Board getBoard() {
        return board;
    }

    public void placeIrrigationTileComponent(Location loc, TileComponent tile) {
        board.placeIrrigationTileComponent(loc, tile);
    }

    public void placeRiceTileComponent(Location loc, TileComponent tile) {
        board.placeRiceTileComponent(loc, tile);
    }

    public void placeVillageTileComponent(Location loc, TileComponent tile) {
        board.placeVillageTileComponent(loc, tile);
    }

    //TODO:
    public void buildPalace(Location loc, TileComponent tile) {}
    public void upgradePalace(Location loc, TileComponent tile) {}

    public void addPalaceToCurrentTurnList(Location loc) {
        turn.addPalaceToList(loc);
    }

    public boolean hasPalaceLocationBeenUsedThisTurn(Location loc) {
        return turn.hasPalaceBeenUsed(loc);
    }

    @Override
    public void useActionPoints(int actionPoints) {
        turn.useActionPoints(actionPoints);
    }

    @Override
    public boolean isHeightAtLocation(int i, Location location) {
        return board.isHeightAtLocation(i, location);
    }

    @Override
    public Space getSpaceAtLocation(Location location) {
        return board.getSpace(location);
    }

    @Override
    public void takeDeveloperOffBoard(Location developerLocationTakenOff) {
        getCurrentJavaPlayer().removeDeveloper(developerLocationTakenOff);
    }

    @Override
    public void moveDeveloperAroundBoard(Location developerStartinglocation, Location developerEndingLocation) {
            getCurrentJavaPlayer().moveDeveloper(developerStartinglocation, developerEndingLocation);
    }

    @Override
    public void setHasPlacedLandTile(boolean hasPlacedLandTile) {
        turn.setHasPlacedLandTile(hasPlacedLandTile);
    }

    @Override
    public void placeDeveloperOnBoard(Location locationOfDeveloperPlaced) {
            getCurrentJavaPlayer().addDeveloper(new Developer(locationOfDeveloperPlaced));

    }

    public boolean isLocationInCity(Location loc) {
        return board.isLocationInCity(loc);
    }
}