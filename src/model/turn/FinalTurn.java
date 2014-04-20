package model.turn;

import model.board.Location;

import java.util.ArrayList;

/**
 * Created by Baker on 4/14/2014.
 */
public class FinalTurn extends Turn {

    public FinalTurn() {
        this.setActionPoints(6);
        this.setHasPlacedLandTile(false);
        this.setActionTokenUsed(false);
        this.setPalacesInteracted(new ArrayList<Location>());
    }

    @Override
    public boolean canEndTurn() {
        return true;
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
