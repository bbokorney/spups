package model;

import model.board.Board;
import model.board.JavaBoard;
import model.board.Location;
import model.palacefestival.Card;
import model.palacefestival.PalaceFestivalPlayer;
import model.player.Developer;
import model.player.JavaPlayer;
import model.player.JavaPlayerResourceType;
import model.player.Player;
import model.sharedresources.SharedResourceType;
import model.tiles.TileComponent;

import java.util.List;

/**
 * Created by Baker on 4/14/2014.
 */
public class JavaGameModel extends GameModel {

    
    public int getCount(SharedResourceType res) {
        return 0;
    }

    
    public void useResource(SharedResourceType res) {

    }

    
    public int getCount(JavaPlayerResourceType res) {
        return 0;
    }

    
    public void useResource(JavaPlayerResourceType res) {

    }

    
    public int getAvailableAPPoints(boolean isLandTileAction) {
        return 0;
    }

    
    public boolean hasUsedActionToken() {
        return false;
    }

    
    void advanceTurn() {

    }

    
    boolean canAdvanceTurn() {
        return false;
    }

    
    public void beginFinalRound() {

    }

    public JavaPlayer getCurrentPlayer() {

        return null;
    }

    
    public boolean placeTopTileComponent(Location loc, TileComponent tile) {
        return false;
    }

    
    public void getTopTileComponent(Location loc) {

    }

    
    public String getName() {
        return null;
    }

    
    void adjustScore(int score) {

    }

    
    public List<Developer> getDevelopers() {
        return null;
    }

    public JavaBoard getJavaBoard() {
        return null;
    }


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
}
