package model.turn;

/**
 * Created by Baker on 4/14/2014.
 */
public abstract class Turn {
    private boolean isFinalTurn;
    public abstract boolean canEndTurn();
    public abstract boolean hasUsedActionToken();
    public boolean isFinalTurn() {
        return isFinalTurn;
    }
    public abstract void useActionPoints(int actionPoints);

    public abstract boolean canUseAPForLandTileAction(int pointsToSpend);

    public abstract boolean cauUseAPForNonLandTileAction(int pointsToSpend);
}
