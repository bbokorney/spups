package model.potentialactions;

import model.actions.ActionResult;
import model.actions.palacefestival.PlaceBid;
import model.palacefestival.Card;
import model.rules.palace.CardValues;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Baker on 4/14/2014.
 */
public class PotentialPlaceBid extends PotentialAction {

    private ArrayList<Card> cardsValidForFestival;
    private ArrayList<Integer> indexOfCardsToBid;
    private int currentIndex;

    public PotentialPlaceBid() {
        currentIndex = 0;
        indexOfCardsToBid = new ArrayList<Integer>();
        cardsValidForFestival = new ArrayList<Card>();
        Collection<Card> hand = this.getPalaceFestival().getCurrentPlayer().getHand();
        for (Card card : hand) {
            if (CardValues.getMatchValue(card, getPalaceFestival().peekAtFestivalCard()) > 0)
                cardsValidForFestival.add(card);
        }
    }

    public boolean tabToNextElement() {
        currentIndex++;
        currentIndex %= cardsValidForFestival.size();
        return true;
    }

    public boolean chooseCurrentCard() {
        indexOfCardsToBid.add(currentIndex);
        return true;
    }

    public boolean removeCurrentCardFromBid() {
        indexOfCardsToBid.remove(currentIndex); //TODO: test this.. potential bug
        return true;
    }

    public ActionResult confirmBid() {
        ArrayList<Card> bid = new ArrayList<Card>();
        for (int index : indexOfCardsToBid) {
            bid.add(cardsValidForFestival.get(index));
        }

        return new PlaceBid(getPalaceFestival(), bid).tryAction();
    }

    @Override
    protected void setComponentsOnHoverBoard() {
        // nothing to set
    }

    @Override
    protected ActionResult getActionResult() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

}
