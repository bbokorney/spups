package model;

import model.board.Board;
import model.board.JavaBoard;
import model.board.Location;
import model.palacefestival.Card;
import model.palacefestival.PalaceFestivalPlayer;
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

import java.util.Collection;
import java.util.List;

/**
 * Created by Baker on 4/14/2014.
 */
public class JavaGameModel extends GameModel {

    private SharedResources resources;
    private Board board;
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

    @Override
    public boolean canUseAPForLandTileAction(int pointsToSpend) {
        return turn.canUseAPForLandTileAction(pointsToSpend);
    }

    @Override
    public boolean cauUseAPForNonLandTileAction(int pointsToSpend) {
        return turn.cauUseAPForNonLandTileAction(pointsToSpend);
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
            players.advanceTurn();
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
        finalRoundTurns = players.getPlayers().size();
        turn = new FinalTurn();
    }

    public JavaPlayer getCurrentJavaPlayer() {
        return players.getCurrentPlayer();
    }

    
    public void placeTopTileComponent(Location loc, TileComponent tile) {
        board.placeTopTileComponent(loc, tile);
    }

    
    public void getTopTileComponent(Location loc) {
        board.getTopTileComponent(loc);
    }

    
    public String getName() {
        return players.getCurrentPlayer().getName();
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

    public void addPlayer(PalaceFestivalPlayer player){}
    public void removePlayer(PalaceFestivalPlayer player){}
    public Collection<JavaPlayer> getPlayers() { return null; }
    public PalaceFestivalPlayer getCurrentPalaceFestivalPlayer() { return null; }
    public void advancePalaceFestivalTurn() {}
    public boolean canDrawCard() { return false; }
    public void recordDrawCard() {}
    public Card peekAtFestivalCard() { return null; }
    public Card drawFestivalCard() { return null; }
    public Card drawDeckCard() { return null; }
    public void discard(Card card) {}

    @Override
    public void useActionPoints(int actionPoints) {
        turn.useActionPoints(actionPoints);
    }

}
