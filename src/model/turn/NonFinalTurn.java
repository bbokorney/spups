package model.turn;

import model.board.Location;

import java.util.ArrayList;

/**
 * Created by Baker on 4/14/2014.
 */
public class NonFinalTurn extends Turn {
    private final int startingAP;
    private boolean actionTokenUsed;
    private int ap;
    private ArrayList<Location> palacesInteracted;

    public NonFinalTurn() {
        startingAP = 6;
        ap = startingAP;
        this.setHasPlacedLandTile(false);
        actionTokenUsed = false;
        palacesInteracted = new ArrayList<Location>();
    }

    //Never used
    public NonFinalTurn(int startingAP) {
        this.startingAP = startingAP;
        ap = startingAP;
        actionTokenUsed = false;
        palacesInteracted = new ArrayList<Location>();
    }

    @Override
    public boolean canEndTurn() {
        if(!hasPlacedLandTile()) {
            return false;
        }
        return true;
    }


    @Override
    public boolean hasUsedActionToken() {
        return actionTokenUsed;
    }

    @Override
    public boolean isFinalTurn() {
        return false;
    }

    @Override
    public void useActionPoints(int actionPoints) {
        ap -= actionPoints;
    }

    @Override
    public boolean canUseAPForLandTileAction(int pointsToSpend) {
        return ap >= pointsToSpend;
    }

    @Override
    public boolean canUseAPForNonLandTileAction(int pointsToSpend) {
        if(hasPlacedLandTile()){
            return ap >= pointsToSpend;
        }
        return (ap-1) >= pointsToSpend;
    }

    public void addPalaceToList(Location loc) {
        palacesInteracted.add(loc);
    }

    public boolean hasPalaceBeenUsed(Location loc) {
        return palacesInteracted.contains(loc);
    }
}
