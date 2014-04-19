package model.turn;

/**
 * Created by Baker on 4/14/2014.
 */
public abstract class Turn {
    private boolean isFinalTurn;
    public abstract boolean endTurn();
    public abstract int getAvailableAPPoints(boolean isLandTileAction);
    public abstract boolean hasUsedActionToken();
    public boolean isFinalTurn() {
        return isFinalTurn;
    }
}
