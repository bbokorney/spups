package model;

import model.board.Board;
import model.board.JavaBoard;
import model.board.Location;
import model.player.Developer;
import model.player.JavaPlayer;
import model.player.JavaPlayers;
import model.player.JavaPlayerResourceType;
import model.sharedresources.SharedResourceType;
import model.sharedresources.SharedResources;
import model.tiles.TileComponent;
import model.turn.FinalTurn;
import model.turn.NonFinalTurn;
import model.turn.Turn;

import java.util.List;

/**
 * Created by Baker on 4/14/2014.
 */
public class JavaGameModel {

    private SharedResources resources;
    private JavaBoard board;
    private JavaPlayers players;
    private Turn turn;
    //The following value will be held at a sentinel value until the final
    //round, at which point it will decrement from the number of players to 0.
    private int finalRoundTurns;

    public JavaGameModel(int numPlayers) {
        resources = new SharedResources();
        board = new JavaBoard();
        players = new JavaPlayers(numPlayers);
        finalRoundTurns = -1;
        turn = new NonFinalTurn();
    }

    int getCount(SharedResourceType res) {
        return resources.getCount(res);
    }

    
    void useResource(SharedResourceType res) {
        resources.useResource(res);
    }

    
    int getCount(JavaPlayerResourceType res) {
        return getCurrentPlayer().getCount(res);
    }

    
    void useResource(JavaPlayerResourceType res) {
        getCurrentPlayer().useResource(res);
    }

    
    int getAvailableAPPoints(boolean isLandTileAction) {
        return turn.getAvailableAPPoints(isLandTileAction);
    }

    
    boolean hasUsedActionToken() {
        return turn.hasUsedActionToken();
    }

    
    void advanceTurn() {
        if (canAdvanceTurn()) {
            //First check if we are in the final round, indicated by the
            //finalRoundTurns value being > 0
            if (finalRoundTurns > 0) {
                finalRoundTurns--;
                turn = new FinalTurn();
            } else
                turn = new NonFinalTurn();
            players.advanceTurn();
        }
    }

    
    boolean canAdvanceTurn() {
        //If this is the last turn of the game, dont advance?
        if (turn.isFinalTurn() && finalRoundTurns <= 1)
            return false;
        else
            return turn.canEndTurn();
    }

    
    void beginFinalRound() {
        finalRoundTurns = players.getPlayers().size();
        turn = new FinalTurn();
    }

    public JavaPlayer getCurrentPlayer() {
        return players.getCurrentPlayer();
    }

    
    void placeTopTileComponent(Location loc, TileComponent tile) {
        board.placeTopTileComponent(loc, tile);
    }

    
    void getTopTileComponent(Location loc) {
        board.getTopTileComponent(loc);
    }

    
    String getName() {
        return players.getCurrentPlayer().getName();
    }

    
    void adjustScore(int score) {
        getCurrentPlayer().adjustScore(score);
    }

    
    List<Developer> getDevelopers() {
        return getCurrentPlayer().getDevelopers();
    }

    public JavaBoard getJavaBoard() {
        return board;
    }
}
