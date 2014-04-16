package model.potentialactions;

import model.GameModel;
import model.actions.ActionResult;
import model.board.HexLocation;

/**
 * Created by idinamenzel on 4/15/14.
 */
public abstract class PotentialThreeSpaceMovement extends PotentialAction implements HexComponentMovement{


    private HexLocation centerLocation;
    private HexLocation[] otherLocations;

    public PotentialThreeSpaceMovement(GameModel game){
        super(game);
    }

    @Override
    public ActionResult moveNorth() {
        HexLocation newCenterLocation = centerLocation.getNeighbor(0);
        HexLocation newOtherLocation = otherLocations[0].getNeighbor(0);
        HexLocation newOtherOtherLocation = otherLocations[1].getNeighbor(0);

        if (game.getBoard().areLocationsOnBoard(newCenterLocation, newOtherLocation, newOtherOtherLocation)) {
            centerLocation = newCenterLocation;
            otherLocations[0] = newOtherLocation;
            otherLocations[1] = newOtherLocation;
            this.setComponentsOnHoverBoard();
        }
        return this.getActionResult();
    }

    @Override
    public ActionResult moveNortheast() {
        HexLocation newCenterLocation = centerLocation.getNeighbor(1);
        HexLocation newOtherLocation = otherLocations[0].getNeighbor(1);
        HexLocation newOtherOtherLocation = otherLocations[1].getNeighbor(1);

        if (game.getBoard().areLocationsOnBoard(newCenterLocation, newOtherLocation, newOtherOtherLocation)) {
            centerLocation = newCenterLocation;
            otherLocations[0] = newOtherLocation;
            otherLocations[1] = newOtherLocation;
            this.setComponentsOnHoverBoard();
        }
        return this.getActionResult();
    }

    @Override
    public ActionResult moveSoutheast() {
        HexLocation newCenterLocation = centerLocation.getNeighbor(2);
        HexLocation newOtherLocation = otherLocations[0].getNeighbor(2);
        HexLocation newOtherOtherLocation = otherLocations[1].getNeighbor(2);

        if (game.getBoard().areLocationsOnBoard(newCenterLocation, newOtherLocation, newOtherOtherLocation)) {
            centerLocation = newCenterLocation;
            otherLocations[0] = newOtherLocation;
            otherLocations[1] = newOtherLocation;
            this.setComponentsOnHoverBoard();
        }
        return this.getActionResult();
    }

    @Override
    public ActionResult moveSouth() {
        HexLocation newCenterLocation = centerLocation.getNeighbor(3);
        HexLocation newOtherLocation = otherLocations[0].getNeighbor(3);
        HexLocation newOtherOtherLocation = otherLocations[1].getNeighbor(3);

        if (game.getBoard().areLocationsOnBoard(newCenterLocation, newOtherLocation, newOtherOtherLocation)) {
            centerLocation = newCenterLocation;
            otherLocations[0] = newOtherLocation;
            otherLocations[1] = newOtherLocation;
            this.setComponentsOnHoverBoard();
        }
        return this.getActionResult();
    }

    @Override
    public ActionResult moveSouthwest() {
        HexLocation newCenterLocation = centerLocation.getNeighbor(4);
        HexLocation newOtherLocation = otherLocations[0].getNeighbor(4);
        HexLocation newOtherOtherLocation = otherLocations[1].getNeighbor(4);

        if (game.getBoard().areLocationsOnBoard(newCenterLocation, newOtherLocation, newOtherOtherLocation)) {
            centerLocation = newCenterLocation;
            otherLocations[0] = newOtherLocation;
            otherLocations[1] = newOtherLocation;
            this.setComponentsOnHoverBoard();
        }
        return this.getActionResult();
    }


    @Override
    public ActionResult moveNorthwest() {
        HexLocation newCenterLocation = centerLocation.getNeighbor(5);
        HexLocation newOtherLocation = otherLocations[0].getNeighbor(5);
        HexLocation newOtherOtherLocation = otherLocations[1].getNeighbor(5);

        if (game.getBoard().areLocationsOnBoard(newCenterLocation, newOtherLocation, newOtherOtherLocation)) {
            centerLocation = newCenterLocation;
            otherLocations[0] = newOtherLocation;
            otherLocations[1] = newOtherLocation;
            this.setComponentsOnHoverBoard();
        }
        return this.getActionResult();
    }

    protected HexLocation getCenterLocation(){
        return centerLocation;
    }

    protected HexLocation getOtherLocation( int i){
        return otherLocations[i];
    }
}
