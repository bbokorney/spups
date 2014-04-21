package model.turn;

import model.board.Location;

import java.util.ArrayList;

/**
 * Created by Baker on 4/14/2014.
 */
public class NonFinalTurn extends Turn {


    public NonFinalTurn() {
        this.setActionPoints(6);
        this.setHasPlacedLandTile(false);
        this.setActionTokenUsed(false);
        this.setPalacesInteracted(new ArrayList<Location>());
    }

    @Override
    public boolean canEndTurn() {
        if(!hasPlacedLandTile()) {
            return false;
        }
        return true;
    }

    public void advanceTurn() {
        this.setActionPoints(6);
        this.setHasPlacedLandTile(false);
        this.setActionTokenUsed(false);
        this.setPalacesInteracted(new ArrayList<Location>());
    }

  @Override
    public boolean canUseAPForLandTileAction(int pointsToSpend) {
        return this.getActionPoints() >= pointsToSpend;
    }

    @Override
    public boolean canUseAPForNonLandTileAction(int pointsToSpend) {
        if(hasPlacedLandTile()){
            return this.getActionPoints() >= pointsToSpend;
        }
        return (this.getActionPoints()-1) >= pointsToSpend;
    }
}
