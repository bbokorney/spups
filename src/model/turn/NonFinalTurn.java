package model.turn;

import model.board.Location;

import java.util.ArrayList;

/**
 * Created by Baker on 4/14/2014.
 */
public class NonFinalTurn extends Turn {
    private final boolean isFinalTurn = false;
    private final int startingAP;
    private boolean actionTokenUsed;
    private boolean landTilePlaced;
    private int ap;
    private ArrayList<Location> palacesInteracted;

    public NonFinalTurn() {
        startingAP = 6;
        ap = startingAP;
        actionTokenUsed = false;
        palacesInteracted = new ArrayList<Location>();
    }

    public NonFinalTurn(int startingAP) {
        this.startingAP = startingAP;
        ap = startingAP;
        actionTokenUsed = false;
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
    public void useActionPoints(int actionPoints) {
        ap -= actionPoints;
    }

    @Override
    public boolean canUseAPForLandTileAction(int pointsToSpend) {
        return ap >= pointsToSpend;
    }

    @Override
    public boolean canUseAPForNonLandTileAction(int pointsToSpend) {
        if(landTilePlaced){
            return ap >= pointsToSpend;
        }
        return (ap-1) >= pointsToSpend;
    }

    private boolean hasPlacedLandTile() {
        return landTilePlaced;
    }

    public void addPalaceToList(Location loc) {
        palacesInteracted.add(loc);
    }

    public boolean hasPalaceBeenUsed(Location loc) {
        return palacesInteracted.contains(loc);
    }
}
