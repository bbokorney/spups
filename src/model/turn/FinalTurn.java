package model.turn;

import model.board.Location;

import java.util.ArrayList;

/**
 * Created by Baker on 4/14/2014.
 */
public class FinalTurn extends Turn {

    private int turnsLeft;

    public FinalTurn(int numPlayers) {
        turnsLeft = numPlayers - 1;
        this.setActionPoints(6);
        this.setHasPlacedLandTile(false);
        this.setActionTokenUsed(false);
        this.setPalacesInteracted(new ArrayList<Location>());
    }

    @Override
    public boolean canEndTurn() {
        return (turnsLeft > 0);
    }

    public void advanceTurn() {
        turnsLeft--;
        this.setActionPoints(6);
        this.setHasPlacedLandTile(false);
        this.setActionTokenUsed(false);
        this.setPalacesInteracted(new ArrayList<Location>());
    }

    @Override
    public boolean isFinalTurn() {
        return true;
    }

    @Override
    public boolean canUseAPForLandTileAction(int pointsToSpend) {
        return this.getActionPoints() >= pointsToSpend;
    }

    @Override
    public boolean canUseAPForNonLandTileAction(int pointsToSpend) {
        return this.getActionPoints() >= pointsToSpend;
    }

}
