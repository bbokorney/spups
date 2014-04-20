package model.rules.palace;

import model.palacefestival.Card;

import java.util.Collection;

/**
 * Created by Owner on 4/19/14.
 */
public class BidRequirementsRule {

    public static boolean bidMeetsRequirements(int bidToMatch, Card festivalCard, Collection<Card> bid) {

        int totalBid = 0;
        for (Card bidCard : bid) {
            totalBid += CardValues.getMatchValue(bidCard, festivalCard);
        }

        return totalBid >= bidToMatch;

    }

}
