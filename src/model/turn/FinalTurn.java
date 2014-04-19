package model.turn;

/**
 * Created by Baker on 4/14/2014.
 */
public class FinalTurn extends Turn {
    private final boolean isFinalTurn = true;
    private final int startingAP;
    private boolean actionTokenUsed;
    private int ap;

    public FinalTurn() {
        startingAP = 6;
        ap = startingAP;
        actionTokenUsed = false;
    }

    public FinalTurn(int startingAP) {
        this.startingAP = startingAP;
        ap = startingAP;
        actionTokenUsed = false;
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
    public void useActionPoints(int actionPoints) {
        ap -= actionPoints;
    }

    @Override
    public boolean canUseAPForLandTileAction(int pointsToSpend) {
        return ap >= pointsToSpend;
    }

    @Override
    public boolean cauUseAPForNonLandTileAction(int pointsToSpend) {
        return ap >= pointsToSpend;
    }
}
