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
        if(landTilePlaced){
            return ap >= pointsToSpend;
        }
        return (ap-1) >= pointsToSpend;
    }

    private boolean hasPlacedLandTile() {
        return landTilePlaced;
    }
}
