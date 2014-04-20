package model.potentialactions;

import model.actions.ActionResult;
import model.palacefestival.Card;

import java.util.ArrayList;

/**
 * Created by Baker on 4/14/2014.
 */
public class PotentialPlaceBid extends PotentialAction {

    private Card[] cardsValidForFestival;
    private ArrayList<Integer> indexOfCardsToBid;

    public boolean chooseCurrentCard() {
        // TODO: Sara
        throw new UnsupportedOperationException("Tell Sara to implement me!");
    }

    public boolean removeCurrentCardFromBid() {
        // TODO: Sara
        throw new UnsupportedOperationException("Tell Sara to implement me!");
    }

    public ActionResult confirmBid() {
        // TODO: Sara
        throw new UnsupportedOperationException("Tell Sara to implement me!");
    }

    private void setComponentsOnHoverBoard() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected ActionResult getActionResult() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
