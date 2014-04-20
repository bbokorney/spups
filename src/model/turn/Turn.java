package model.turn;

import model.board.Location;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Baker on 4/14/2014.
 */
public abstract class Turn {
    private boolean hasPlacedLandTile;
    private boolean hasUsedActionToken;
    private int actionPoints;
    private Collection<Location> palacesInteracted;


    public abstract boolean canEndTurn();
    public abstract boolean isFinalTurn();
    public abstract boolean canUseAPForLandTileAction(int pointsToSpend);
    public abstract boolean canUseAPForNonLandTileAction(int pointsToSpend);


    public boolean hasUsedActionToken(){ return hasUsedActionToken;}

    public void useActionPoints(int actionPoints){
        this.actionPoints -= actionPoints;
    }

    protected void setActionPoints(int actionPoints){
        this.actionPoints = actionPoints;
    }

    protected void setActionTokenUsed(boolean hasUsedActionToken){
        this.hasUsedActionToken = hasUsedActionToken;
    }


    public void addPalaceToList(Location loc){
        palacesInteracted.add(loc);
    }

    public void setHasPlacedLandTile(boolean hasPlacedLandTile){ this.hasPlacedLandTile = hasPlacedLandTile;}
    protected void setPalacesInteracted(Collection<Location> palacesInteracted){
        this.palacesInteracted = palacesInteracted;
    }

    protected int getActionPoints(){ return actionPoints;}

    public boolean hasPlacedLandTile() {
        return hasPlacedLandTile;
    }

    public boolean hasPalaceBeenUsed(Location loc) {
        return palacesInteracted.contains(loc);
    }
}
