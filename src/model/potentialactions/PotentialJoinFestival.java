package model.potentialactions;

import model.GameModel;
import model.actions.ActionResult;
import model.actions.palacefestival.JoinFestival;
import model.actions.palacefestival.Withdraw;
import model.board.Location;
import model.palacefestival.Card;
import model.palacefestival.PalaceFestival;
import model.rules.palace.CardValues;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Baker on 4/14/2014.
 */
public class PotentialJoinFestival extends PotentialAction {

    private ArrayList<Card> cardsValidToBeginFestival;
    private ArrayList<Integer> indexOfCardsToBid;
    private int currentIndex;
    private Location palaceLoc;

	GameModel model;
	PalaceFestival paFes;

    public PotentialJoinFestival(GameModel model, PalaceFestival paFes, Location palaceLocation) {
        currentIndex = 0;
        indexOfCardsToBid = new ArrayList<Integer>();
        cardsValidToBeginFestival = new ArrayList<Card>();
        this.palaceLoc = palaceLocation;

	    this.model = model;
	    this.paFes = paFes;

        Collection<Card> hand = paFes.getCurrentPlayer().getHand();
        for (Card card : hand) {
            if (CardValues.getMatchValue(card, paFes.peekAtFestivalCard()) > 0)
                cardsValidToBeginFestival.add(card);
        }
    }

	public List<Integer> getIndexOfCardsToBid() {
		return indexOfCardsToBid;
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
        return new Withdraw(paFes).tryAction();
    }

    public ActionResult confirmBid() {
        ArrayList<Card> bid = new ArrayList<Card>();
        for (int i : indexOfCardsToBid) {
            bid.add(cardsValidToBeginFestival.get(i));
        }

        return new JoinFestival(palaceLoc, bid, model, paFes).tryAction();
    }

    @Override
    public ActionResult getActionResult() {
        return confirmBid();
    }

}
