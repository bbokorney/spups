package model.turn;

/**
 * Created by Baker on 4/14/2014.
 */
public class NonFinalTurn extends Turn {
    private final boolean isFinalTurn = false;
    private final int startingAP;
    private boolean actionTokenUsed;
    private boolean landTilePlaced;
    private int ap;

    public NonFinalTurn() {
        startingAP = 6;
        ap = startingAP;
        actionTokenUsed = false;
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

    // Why does the turn object ask whether a land tile has been placed this turn? It should be the one who knows that. - Jonathan
    @Override
    public int getAvailableAPPoints(boolean isLandTileAction) {
        return ap;
    }

    @Override
    public boolean hasUsedActionToken() {
        return actionTokenUsed;
    }

    private boolean hasPlacedLandTile() {
        return landTilePlaced;
    }
}
