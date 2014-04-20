package model.potentialactions;

import model.actions.ActionResult;
import model.palacefestival.Card;

import java.util.ArrayList;

/**
 * Created by Baker on 4/14/2014.
 */
public class PotentialJoinFestival extends PotentialAction {

    private Card[] cardsValidToBeginFestival;
    private ArrayList<Integer> indexOfCardsToBid;
    private int currentIndex;

    public PotentialJoinFestival() {
        currentIndex = 0;
        indexOfCardsToBid = new ArrayList<Integer>();
        this.getPalaceFestival().getCurrentPlayer().getHand();
    }

    public boolean tabToNextElement() {
        // TODO:Sara
        throw new UnsupportedOperationException("Tell Sara to implement me!");
    }

    public boolean chooseCurrentCard() {
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


    @Override
    protected void setComponentsOnHoverBoard() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected ActionResult getActionResult() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
