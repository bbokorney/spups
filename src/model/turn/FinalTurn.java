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

    // Why does the turn object ask whether a land tile has been placed this turn? It should be the one who knows that. - Jonathan
    @Override
    public int getAvailableAPPoints(boolean isLandTileAction) {
        return ap;
    }

    @Override
    public boolean hasUsedActionToken() {
        return actionTokenUsed;
    }
}
