package model.potentialactions;

import model.actions.ActionResult;
import model.board.Location;
import model.palacefestival.PalaceCard;
import model.tiles.PalaceTileComponent;

import java.util.ArrayList;

/**
 * Created by Baker on 4/14/2014.
 */
public class PotentialBeginPalaceFestival {

    private ArrayList<PalaceTileComponent> palacesValidForFestival;
    private ArrayList<Location> locationsValidForFestival;
    private ArrayList<PalaceCard> cardsValidToBeginFestival;
    private ArrayList<Integer> indexOfCardsToBid;

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

}
