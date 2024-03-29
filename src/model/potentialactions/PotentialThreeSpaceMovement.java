package model.potentialactions;

import model.GameModel;
import model.actions.ActionResult;
import model.board.Directions;
import model.board.HexLocation;
import model.palacefestival.PalaceFestival;

import java.util.ArrayList;

/**
 * Created by idinamenzel on 4/15/14.
 */
public abstract class PotentialThreeSpaceMovement extends PotentialAction implements HexComponentPotentialAction, HexComponentRotation{


    private HexLocation centerLocation;
    private HexLocation[] otherLocations;
    private int rotationState;

    public PotentialThreeSpaceMovement(GameModel game, PalaceFestival palaceFestival){ //}), HoverBoard hoverboard){
        super(game, palaceFestival);
        this.rotationState = 0;
        otherLocations = new HexLocation[2];
        centerLocation = new HexLocation(new ArrayList<Directions>());
        otherLocations[0] = centerLocation.getNeighbor(0);
        otherLocations[1] = centerLocation.getNeighbor(1);

    }

    @Override
    public ActionResult moveNorth() {

        HexLocation newCenterLocation = centerLocation.getNeighbor(0);
        HexLocation newOtherLocation = otherLocations[0].getNeighbor(0);
        HexLocation newOtherOtherLocation = otherLocations[1].getNeighbor(0);

        if (getGameModel().getBoard().areLocationsOnBoard(newCenterLocation, newOtherLocation, newOtherOtherLocation)) {
            centerLocation = newCenterLocation;
            otherLocations[0] = newOtherLocation;
            otherLocations[1] = newOtherOtherLocation;
        }
        return this.getActionResult();
    }

    @Override
    public ActionResult moveNortheast() {
        HexLocation newCenterLocation = centerLocation.getNeighbor(1);
        HexLocation newOtherLocation = otherLocations[0].getNeighbor(1);
        HexLocation newOtherOtherLocation = otherLocations[1].getNeighbor(1);

        if (getGameModel().getBoard().areLocationsOnBoard(newCenterLocation, newOtherLocation, newOtherOtherLocation)) {
            centerLocation = newCenterLocation;
            otherLocations[0] = newOtherLocation;
            otherLocations[1] = newOtherOtherLocation;
        }
        return this.getActionResult();
    }

    @Override
    public ActionResult moveSoutheast() {
        HexLocation newCenterLocation = centerLocation.getNeighbor(2);
        HexLocation newOtherLocation = otherLocations[0].getNeighbor(2);
        HexLocation newOtherOtherLocation = otherLocations[1].getNeighbor(2);

        if (getGameModel().getBoard().areLocationsOnBoard(newCenterLocation, newOtherLocation, newOtherOtherLocation)) {
            centerLocation = newCenterLocation;
            otherLocations[0] = newOtherLocation;
            otherLocations[1] = newOtherOtherLocation;
        }
        return this.getActionResult();
    }

    @Override
    public ActionResult moveSouth() {
        HexLocation newCenterLocation = centerLocation.getNeighbor(3);
        HexLocation newOtherLocation = otherLocations[0].getNeighbor(3);
        HexLocation newOtherOtherLocation = otherLocations[1].getNeighbor(3);

        if (getGameModel().getBoard().areLocationsOnBoard(newCenterLocation, newOtherLocation, newOtherOtherLocation)) {
            centerLocation = newCenterLocation;
            otherLocations[0] = newOtherLocation;
            otherLocations[1] = newOtherOtherLocation;
        }
        return this.getActionResult();
    }

    @Override
    public ActionResult moveSouthwest() {
        HexLocation newCenterLocation = centerLocation.getNeighbor(4);
        HexLocation newOtherLocation = otherLocations[0].getNeighbor(4);
        HexLocation newOtherOtherLocation = otherLocations[1].getNeighbor(4);

        if (getGameModel().getBoard().areLocationsOnBoard(newCenterLocation, newOtherLocation, newOtherOtherLocation)) {
            centerLocation = newCenterLocation;
            otherLocations[0] = newOtherLocation;
            otherLocations[1] = newOtherOtherLocation;
        }
        return this.getActionResult();
    }


    @Override
    public ActionResult moveNorthwest() {
        HexLocation newCenterLocation = centerLocation.getNeighbor(5);
        HexLocation newOtherLocation = otherLocations[0].getNeighbor(5);
        HexLocation newOtherOtherLocation = otherLocations[1].getNeighbor(5);

        if (getGameModel().getBoard().areLocationsOnBoard(newCenterLocation, newOtherLocation, newOtherOtherLocation)) {
            centerLocation = newCenterLocation;
            otherLocations[0] = newOtherLocation;
            otherLocations[1] = newOtherOtherLocation;
        }
        return this.getActionResult();
    }

    public ActionResult rotateClockwise(){
        int newRotationState = (rotationState + 1) % 6;

        HexLocation[] newOtherLocations = { centerLocation.getNeighbor(newRotationState), centerLocation.getNeighbor((newRotationState + 1) % 6)};
        if(getGameModel().getBoard().areLocationsOnBoard(newOtherLocations[0], newOtherLocations[1])){
            this.otherLocations = newOtherLocations;
            this.rotationState = newRotationState;
        }
        return this.getActionResult();
    }

    public HexLocation getCenterLocation(){
        return centerLocation;
    }

    public HexLocation getOtherLocation( int i){
        return otherLocations[i];
    }
}
