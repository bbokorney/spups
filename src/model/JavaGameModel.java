package model;

import model.board.Board;
import model.board.JavaBoard;
import model.board.Location;
import model.board.Space;
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
public class JavaGameModel extends GameModel {

    private SharedResources resources;
    private Board board;
    private JavaPlayers javaPlayers;
    private Turn turn;
    private PalaceFestival festival;
    //The following value will be held at a sentinel value until the final
    //round, at which point it will decrement from the number of jplayers to 0.
    private int finalRoundTurns;

    public JavaGameModel(int numPlayers) {
        resources = new SharedResources();
        board = new JavaBoard();
        javaPlayers = new JavaPlayers(numPlayers);
        finalRoundTurns = -1;
        turn = new NonFinalTurn();

        //Instantiate the palace festival and its deck of cards
        Stack<Card> deck = new Stack<Card>();
        for (int i = 0; i < 5; i++) {
            PalaceCard card = new PalaceCard(PalaceCardComponent.DRUM);
            deck.add(card);
        }
        for (int i = 0; i < 5; i++) {
            PalaceCard card = new PalaceCard(PalaceCardComponent.MASK);
            deck.add(card);
        }
        for (int i = 0; i < 5; i++) {
            PalaceCard card = new PalaceCard(PalaceCardComponent.PUPPET);
            deck.add(card);
        }
        for (int i = 0; i < 5; i++) {
            PalaceCard card = new PalaceCard(PalaceCardComponent.MASK,
                                             PalaceCardComponent.PUPPET);
            deck.add(card);
        }
        for (int i = 0; i < 5; i++) {
            PalaceCard card = new PalaceCard(PalaceCardComponent.DRUM,
                                             PalaceCardComponent.MASK);
            deck.add(card);
        }
        for (int i = 0; i < 5; i++) {
            PalaceCard card = new PalaceCard(PalaceCardComponent.DRUM,
                                             PalaceCardComponent.PUPPET);
            deck.add(card);
        }
        festival = new PalaceFestival(null, deck);
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

    public void placeTopTileComponent(Location loc, TileComponent tile) {
        board.placeTopTileComponent(loc, tile);
    }

    
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

    public void addPalaceToCurrentTurnList(Location loc) {
        turn.addPalaceToList(loc);
    }

    public boolean hasPalaceLocationBeenUsedThisTurn(Location loc) {
        return turn.hasPalaceBeenUsed(loc);
    }

    public void addPlayer(PalaceFestivalPlayer player){
        festival.addPlayer(player);
    }

    public void removePlayer(PalaceFestivalPlayer player){
        festival.removePlayer(player);
    }

    public PalaceFestivalPlayer getCurrentPalaceFestivalPlayer() {
        return festival.getCurrentPlayer();
    }

    public Collection<PalaceFestivalPlayer> getFestivalPlayers() {
        return festival.getPlayers();
    }

    public void advancePalaceFestivalTurn() {
        festival.advanceTurn();
    }
    public boolean canDrawCard() {
        return festival.canDrawCard();
    }

    public void recordDrawCard() {
        festival.recordDrawCard();
    }

    public Card peekAtFestivalCard() {
        return festival.peekAtFestivalCard();
    }

    public Card drawFestivalCard() { return festival.drawFestivalCard(); }
    public Card drawDeckCard() { return festival.drawDeckCard(); }
    public void discard(Card card) { festival.discard(card); }

    @Override
    public void beginPalaceFestival(PalaceTileComponent palaceTileComponent, int bid, PalaceFestivalPlayer player) {
        //todo added methods from GameModel
    }

    @Override
    public void setHighestBid(int bid) {
        //todo added methods from GameModel
    }

    @Override
    public int getHighestBid() {
        return 0;  //todo added methods from GameModel
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
        //todo for Sachit, my sweetie
        return null;
    }

	@Override
	public void resetGame() {
		int numPlayers = javaPlayers.getPlayers().size();

		resources = new SharedResources();
		board = new JavaBoard();
		javaPlayers = new JavaPlayers(numPlayers);
		finalRoundTurns = -1;
		turn = new NonFinalTurn();
	}

}
