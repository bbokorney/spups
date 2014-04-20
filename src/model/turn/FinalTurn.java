package model.turn;

import model.board.Location;

import java.util.ArrayList;

/**
 * Created by Baker on 4/14/2014.
 */
public class FinalTurn extends Turn {
    private final boolean isFinalTurn = true;
    private final int startingAP;
    private boolean actionTokenUsed;
    private int ap;
    private ArrayList<Location> palacesInteracted;

    public FinalTurn() {
        startingAP = 6;
        ap = startingAP;
        actionTokenUsed = false;
        palacesInteracted = new ArrayList<Location>();
    }

    //Never used
    public FinalTurn(int startingAP) {
        this.startingAP = startingAP;
        ap = startingAP;
        actionTokenUsed = false;
        palacesInteracted = new ArrayList<Location>();
    }

    @Override
    public boolean canEndTurn() {
        return true;
    }


    @Override
    public boolean hasUsedActionToken() {
        return actionTokenUsed;
    }

    @Override
    public boolean isFinalTurn() {
        return true;
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
        return ap >= pointsToSpend;
    }

    public void addPalaceToList(Location loc) {
        palacesInteracted.add(loc);
    }

    public boolean hasPalaceBeenUsed(Location loc) {
        return palacesInteracted.contains(loc);
    }
}
