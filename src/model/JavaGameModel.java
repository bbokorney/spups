package model;

import model.board.Board;
import model.board.JavaBoard;
import model.board.Location;
<<<<<<< HEAD
import model.palacefestival.Card;
import model.palacefestival.PalaceFestivalPlayer;
=======
import model.palacefestival.*;
>>>>>>> master
import model.player.Developer;
import model.player.JavaPlayer;
import model.player.JavaPlayers;
import model.player.JavaPlayerResourceType;
import model.player.Player;
import model.sharedresources.SharedResourceType;
import model.sharedresources.SharedResources;
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

<<<<<<< HEAD
    
    public int getCount(SharedResourceType res) {
        return 0;
=======
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
>>>>>>> master
    }

    
    public void useResource(SharedResourceType res) {
<<<<<<< HEAD

=======
        resources.useResource(res);
>>>>>>> master
    }

    
    public int getCount(JavaPlayerResourceType res) {
<<<<<<< HEAD
        return 0;
=======
        return getCurrentJavaPlayer().getCount(res);
>>>>>>> master
    }

    
    public void useResource(JavaPlayerResourceType res) {
<<<<<<< HEAD
=======
        getCurrentJavaPlayer().useResource(res);
    }
>>>>>>> master

    @Override
    public boolean canUseAPForLandTileAction(int pointsToSpend) {
        return turn.canUseAPForLandTileAction(pointsToSpend);
    }

<<<<<<< HEAD
    
    public int getAvailableAPPoints(boolean isLandTileAction) {
        return 0;
=======
    @Override
    public boolean cauUseAPForNonLandTileAction(int pointsToSpend) {
        return turn.cauUseAPForNonLandTileAction(pointsToSpend);
>>>>>>> master
    }

    
    public boolean hasUsedActionToken() {
<<<<<<< HEAD
        return false;
=======
        return turn.hasUsedActionToken();
>>>>>>> master
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
<<<<<<< HEAD
=======
        finalRoundTurns = javaPlayers.getPlayers().size();
        turn = new FinalTurn();
    }
>>>>>>> master

    public JavaPlayer getCurrentJavaPlayer() {
        return javaPlayers.getCurrentPlayer();
    }

    public Collection<JavaPlayer> getJavaPlayers() {
        return javaPlayers.getPlayers();
    }

    public void placeTopTileComponent(Location loc, TileComponent tile) {
        board.placeTopTileComponent(loc, tile);
    }

    
<<<<<<< HEAD
    public boolean placeTopTileComponent(Location loc, TileComponent tile) {
        return false;
    }

    
    public void getTopTileComponent(Location loc) {

    }

    
    public String getName() {
        return null;
=======
    public void getTopTileComponent(Location loc) {
        board.getTopTileComponent(loc);
    }

    
    public String getName() {
        return javaPlayers.getCurrentPlayer().getName();
    }

    
    public void incrementScore(int score) {
        int currentScore = getCurrentJavaPlayer().getScore();
        getCurrentJavaPlayer().adjustScore(currentScore + score);
>>>>>>> master
    }

    
    public List<Developer> getDevelopers() {
        return getCurrentJavaPlayer().getDevelopers();
    }

    public Board getBoard() {
        return board;
    }

<<<<<<< HEAD
    
    public List<Developer> getDevelopers() {
        return null;
=======
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
>>>>>>> master
    }

    public Card drawFestivalCard() { return festival.drawFestivalCard(); }
    public Card drawDeckCard() { return festival.drawDeckCard(); }
    public void discard(Card card) { festival.discard(card); }

    @Override
    public void useActionPoints(int actionPoints) {
        turn.useActionPoints(actionPoints);
    }

<<<<<<< HEAD

	@Override
	public void advanceJavaTurn() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean canAdvanceJavaTurn() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public JavaPlayer getCurrentJavaPlayer() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void incrementScore(int score) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Board getBoard() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void addPlayer(PalaceFestivalPlayer player) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void removePlayer(PalaceFestivalPlayer player) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public PalaceFestivalPlayer getCurrentPalaceFestivalPlayer() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void advancePalaceFestivalTurn() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean canDrawCard() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void recordDrawCard() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Card peekAtFestivalCard() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Card drawFestivalCard() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Card drawDeckCard() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void discard(Card card) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Player[] getJavaPlayers() {
		// TODO Auto-generated method stub
		return null;
	}
=======
    @Override
    public boolean isHeightAtLocation(int i) {
        return board.isHeightAtLocation(i);
    }

>>>>>>> master
}
