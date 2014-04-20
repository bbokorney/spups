package model.actions.palacefestival;

import model.actions.Action;
import model.actions.ActionResult;
import model.actions.serialization.JsonObject;
import model.palacefestival.Card;
import model.palacefestival.PalaceFestival;
import model.palacefestival.PalaceFestivalPlayer;
import model.rules.palace.BidRequirementsRule;
import model.rules.palace.CardValues;

import java.util.List;

/**
 * Created by Baker on 4/14/2014.
 */
public class PlaceBid extends Action {

    private List<Card> bid;
    private PalaceFestival festival;

    public PlaceBid(PalaceFestival festival, List<Card> bid) {
        this.bid = bid;
        this.festival = festival;
    }

    @Override
    public ActionResult tryAction() {
        boolean valid = BidRequirementsRule.bidMeetsRequirements(festival.getHighestBid(), festival.peekAtFestivalCard(), bid);
        String message = valid ? "bid successful" : "bid unsuccessful";
        return new ActionResult(valid, 0, 0, message);
    }

    @Override
    public ActionResult doAction() {
        ActionResult result = tryAction();
        if(result.isSuccess()) {
            PalaceFestivalPlayer player = festival.getCurrentPlayer();
            int total = 0;
            for (Card card : bid) {
                player.playCard(card);
                festival.discard(card);
                total += CardValues.getMatchValue(card, festival.peekAtFestivalCard());
            }

            if (total > festival.getHighestBid()) {
                festival.setHighestBid(total);
            }
        }

        return result;
    }

    @Override
    public String serialize() {
        // TODO: Sara
        throw new UnsupportedOperationException("Tell Sara to implement me!");
    }

    @Override
    public Action restore(JsonObject actionToRestore) {
        // TODO: Sara
        throw new UnsupportedOperationException("Tell Sara to implement me!");
    }

    @Override
    public int getActionID() {
        // TODO: Sara
        throw new UnsupportedOperationException("Tell Sara to implement me!");
    }

}
