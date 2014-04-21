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

    private int numPlayers;
    private SharedResources resources;
    private Board board;
    private JavaPlayers javaPlayers;
    private Turn turn;

    /*
        Use for testing the view only
     */
    public JavaGameModel(int numberOfPlayers) {
        resetStates();
        javaPlayers = new JavaPlayers();

        String[] playerNames = new String[numberOfPlayers];
        for(int i = 0; i < numberOfPlayers; i++){
            playerNames[0] = "Player " + (i+1);
        }
        setPlayersInGame(playerNames);

        numPlayers = numberOfPlayers;

    }

    /*
        Used for when we incorporate the StartGame Action
     */
    public JavaGameModel() {
       resetStates();
    }

    @Override
    public void setPlayersInGame(String[] playerNames) {

        for(String name: playerNames) {
            javaPlayers.addPlayer(new JavaPlayer(name));
        }
    }

    @Override
    public void resetStates() {
        /*
            This method will reset the Game and the rest of this model
            This will be utilized in Replay, Undo, etc...

            This may not be needed depending on how replay mode stuff works!
            //todo find out if I need this from Jonathan/Mau
         */
        resources = new SharedResources();
        BoardCreator creator = new BoardCreator();
        board = creator.createBoard();
        turn = new NonFinalTurn();

    }

    @Override
    public int getCount(SharedResourceType res) {
        return resources.getCount(res);
    }

    @Override
    public void useResource(SharedResourceType res) {
        resources.useResource(res);
    }

    @Override
    public int getCount(JavaPlayerResourceType res) {
        return getCurrentJavaPlayer().getCount(res);
    }

    @Override
    public void useResource(JavaPlayerResourceType res) {
        getCurrentJavaPlayer().useResource(res);
    }

    @Override
    public boolean canUseAPForLandTileAction(int pointsToSpend) {
        return turn.canUseAPForLandTileAction(pointsToSpend);
    }

    @Override
    public boolean canUseAPForNonLandTileAction(int pointsToSpend) {
        return turn.canUseAPForNonLandTileAction(pointsToSpend);
    }

    @Override
    public boolean hasUsedActionToken() {
        return turn.hasUsedActionToken();
    }

    @Override
    public void advanceJavaTurn() {
        if (canAdvanceJavaTurn()) {
            turn.advanceTurn();
            javaPlayers.advanceTurn();
        }
    }

    @Override
    public boolean canAdvanceJavaTurn() {
       return turn.canEndTurn();
    }

    @Override
    public void beginFinalRound() {
        turn = new FinalTurn(numPlayers);
    }

    @Override
    public JavaPlayer getCurrentJavaPlayer() {
        return javaPlayers.getCurrentPlayer();
    }

    @Override
    public Collection<JavaPlayer> getJavaPlayers() {
        return javaPlayers.getPlayers();
    }

    //NEVER USED.
/*    public void placeTopTileComponent(Location loc, TileComponent tile) {
        board.placeTopTileComponent(loc, tile);
    }*/

    @Override
    public void getTopTileComponent(Location loc) {
        board.getTopTileComponent(loc);
    }

    @Override
    public String getName() {
        return javaPlayers.getCurrentPlayer().getName();
    }

    @Override
    public void incrementScore(int score) {
        int currentScore = getCurrentJavaPlayer().getScore();
        getCurrentJavaPlayer().adjustScore(currentScore + score);
    }

    @Override
    public List<Developer> getDevelopers() {
        return getCurrentJavaPlayer().getDevelopers();
    }

    @Override
    public Board getBoard() {
        return board;
    }

    @Override
    public void placeIrrigationTileComponent(Location loc, TileComponent tile) {
        board.placeIrrigationTileComponent(loc, tile);
    }

    @Override
    public void placeRiceTileComponent(Location loc, TileComponent tile) {
        board.placeRiceTileComponent(loc, tile);
    }

    @Override
    public void placeVillageTileComponent(Location loc, TileComponent tile) {
        board.placeVillageTileComponent(loc, tile);
    }

    public void buildPalace(Location loc, PalaceTileComponent tile) {
        board.buildPalace(loc, tile);
    }
    public void upgradePalace(Location loc, PalaceTileComponent tile) {
        board.upgradePalace(loc, tile);
    }

    @Override
    public void addPalaceToCurrentTurnList(Location loc) {
        turn.addPalaceToList(loc);
    }

    @Override
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
    public List<Location> getLocationsOfCurrentPlayersDevelopers() {
        return getCurrentJavaPlayer().getDeveloperLocations();
    }

	public void resetGame() {
		int numPlayers = javaPlayers.getPlayers().size();

		resources = new SharedResources();
		board = new JavaBoard();
		javaPlayers = new JavaPlayers(numPlayers);
		finalRoundTurns = -1;
		turn = new NonFinalTurn();
	}

    @Override
    public void setHasPlacedLandTile(boolean hasPlacedLandTile) {
        turn.setHasPlacedLandTile(hasPlacedLandTile);
    }

    @Override
    public void placeDeveloperOnBoard(Location locationOfDeveloperPlaced) {
            getCurrentJavaPlayer().addDeveloper(locationOfDeveloperPlaced);
    }

    @Override
    public boolean isLocationInCity(Location loc) {
        return board.isLocationInCity(loc);
    }
}
