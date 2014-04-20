package model.potentialactions;

import model.actions.ActionResult;
import model.actions.palacefestival.JoinFestival;
import model.board.Location;
import model.palacefestival.Card;
import model.rules.palace.CardValues;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Baker on 4/14/2014.
 */
public class PotentialJoinFestival extends PotentialAction {

    private ArrayList<Card> cardsValidToBeginFestival;
    private ArrayList<Integer> indexOfCardsToBid;
    private int currentIndex;
    private Location palaceLoc;

    public PotentialJoinFestival(Location palaceLocation) {
        currentIndex = 0;
        indexOfCardsToBid = new ArrayList<Integer>();
        cardsValidToBeginFestival = new ArrayList<Card>();
        this.palaceLoc = palaceLocation;
        Collection<Card> hand = this.getPalaceFestival().getCurrentPlayer().getHand();
        for (Card card : hand) {
            if (CardValues.getMatchValue(card, getPalaceFestival().peekAtFestivalCard()) > 0)
                cardsValidToBeginFestival.add(card);
        }
    }

    public boolean tabToNextElement() {
        currentIndex++;
        currentIndex %= cardsValidToBeginFestival.size();
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
    protected ActionResult getActionResult() {
        ArrayList<Card> bid = new ArrayList<Card>();
        for (int i : indexOfCardsToBid) {
            bid.add(cardsValidToBeginFestival.get(i));
        }

        return new JoinFestival(palaceLoc, bid, getGameModel(), getPalaceFestival()).tryAction();
    }
}
