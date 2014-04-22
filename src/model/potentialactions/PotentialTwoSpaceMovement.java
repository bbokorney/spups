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
public abstract class PotentialTwoSpaceMovement extends PotentialAction implements HexComponentPotentialAction, HexComponentRotation {

    private HexLocation centerLocation;
    private HexLocation otherLocation;
    private int rotationState;

    public PotentialTwoSpaceMovement(GameModel game, PalaceFestival festival){
        super(game, festival);
        this.rotationState = 0;

        centerLocation = new HexLocation(new ArrayList<Directions>());
        otherLocation = centerLocation.getNeighbor(0);
    }

    @Override
    public ActionResult moveNorth() {
        HexLocation newCenterLocation = centerLocation.getNeighbor(0);
        HexLocation newOtherLocation = otherLocation.getNeighbor(0);
        if (getGameModel().getBoard().areLocationsOnBoard(newCenterLocation, newOtherLocation)) {
            centerLocation = newCenterLocation;
            otherLocation = newOtherLocation;
            //this.setComponentsOnHoverBoard();
        }
        return this.getActionResult();
    }

    @Override
    public ActionResult moveNortheast() {
        HexLocation newCenterLocation = centerLocation.getNeighbor(1);
        HexLocation newOtherLocation = otherLocation.getNeighbor(1);
        if (getGameModel().getBoard().areLocationsOnBoard(newCenterLocation, newOtherLocation)) {
            centerLocation = newCenterLocation;
            otherLocation = newOtherLocation;
            //this.setComponentsOnHoverBoard();
        }
        return this.getActionResult();
    }

    @Override
    public ActionResult moveSoutheast() {
        HexLocation newCenterLocation = centerLocation.getNeighbor(2);
        HexLocation newOtherLocation = otherLocation.getNeighbor(2);
        if (getGameModel().getBoard().areLocationsOnBoard(newCenterLocation, newOtherLocation)) {
            centerLocation = newCenterLocation;
            otherLocation = newOtherLocation;
            //this.setComponentsOnHoverBoard();
        }
        return this.getActionResult();
    }

    @Override
    public ActionResult moveSouth() {
        HexLocation newCenterLocation = centerLocation.getNeighbor(3);
        HexLocation newOtherLocation = otherLocation.getNeighbor(3);
        if (getGameModel().getBoard().areLocationsOnBoard(newCenterLocation, newOtherLocation)) {
            centerLocation = newCenterLocation;
            otherLocation = newOtherLocation;
            //this.setComponentsOnHoverBoard();
        }
        return this.getActionResult();
    }

    @Override
    public ActionResult moveSouthwest() {
        HexLocation newCenterLocation = centerLocation.getNeighbor(4);
        HexLocation newOtherLocation = otherLocation.getNeighbor(4);
        if (getGameModel().getBoard().areLocationsOnBoard(newCenterLocation, newOtherLocation)) {
            centerLocation = newCenterLocation;
            otherLocation = newOtherLocation;
            //this.setComponentsOnHoverBoard();
        }
        return this.getActionResult();
    }


    @Override
    public ActionResult moveNorthwest() {
        HexLocation newCenterLocation = centerLocation.getNeighbor(5);
        HexLocation newOtherLocation = otherLocation.getNeighbor(5);
        if (getGameModel().getBoard().areLocationsOnBoard(newCenterLocation, newOtherLocation)) {
            centerLocation = newCenterLocation;
            otherLocation = newOtherLocation;
            //this.setComponentsOnHoverBoard();
        }
        return this.getActionResult();
    }

    public ActionResult rotateClockwise(){
        int newRotationState = (rotationState + 1) % 6;

        HexLocation newOtherLocation = centerLocation.getNeighbor(newRotationState);
        if(getGameModel().getBoard().areLocationsOnBoard(newOtherLocation)){
            this.otherLocation = newOtherLocation;
            this.rotationState = newRotationState;
            //this.setComponentsOnHoverBoard();
        }
        return this.getActionResult();
    }

    public HexLocation getCenterLocation(){
        return centerLocation;
    }

    public HexLocation getOtherLocation(){
        return otherLocation;
    }




}
