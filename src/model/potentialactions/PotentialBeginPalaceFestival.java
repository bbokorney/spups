package model.potentialactions;

import model.actions.ActionResult;
import model.board.Location;
import model.palacefestival.Card;
import model.tiles.PalaceTileComponent;

import java.util.ArrayList;

/**
 * Created by Baker on 4/14/2014.
 */
public class PotentialBeginPalaceFestival extends PotentialAction {

    private ArrayList<PalaceTileComponent> palacesValidForFestival;
    private ArrayList<Location> locationsValidForFestival;
    private ArrayList<Card> cardsValidToBeginFestival;
    private ArrayList<Integer> indexOfCardsToBid;

    public PotentialBeginPalaceFestival(ArrayList<PalaceTileComponent> palacesValidForFestival, ArrayList<Location> locationsValidForFestival, ArrayList<Card> cardsValidToBeginFestival, ArrayList<Integer> indexOfCardsToBid) {
        this.palacesValidForFestival = palacesValidForFestival;
    }

    public boolean tabToNextElement() {
        // TODO:Sara
        throw new UnsupportedOperationException("Tell Sara to implement me!");
    }

    public boolean chooseCurrentElement() {
        // TODO:Sara
        throw new UnsupportedOperationException("Tell Sara to implement me!");
    }

    public boolean removeCurrentCardFromBid() {
        // TODO:Sara
        throw new UnsupportedOperationException("Tell Sara to implement me!");
    }

    public ActionResult withdraw() {
        // TODO:Sara
        throw new UnsupportedOperationException("Tell Sara to implement me!");
    }

    public ActionResult confirmBid() {
        // TODO:Sara
        throw new UnsupportedOperationException("Tell Sara to implement me!");
    }

    private void setComponentsOnHoverBoard() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ActionResult getActionResult() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
