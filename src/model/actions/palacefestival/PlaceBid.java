package model.actions.palacefestival;

import model.GameModel;
import model.actions.Action;
import model.actions.ActionResult;
import model.actions.serialization.JsonObject;
import model.palacefestival.Card;
import model.palacefestival.PalaceFestivalPlayer;
import model.rules.palace.BidRequirementsRule;
import model.rules.palace.CardValues;

import java.util.List;

/**
 * Created by Baker on 4/14/2014.
 */
public class PlaceBid extends Action {

    private List<Card> bid;

    public PlaceBid(List<Card> bid) {
        this.bid = bid;
    }

    @Override
    public ActionResult tryAction() {
        boolean valid = BidRequirementsRule.bidMeetsRequirements(game.getHighestBid(), game.peekAtFestivalCard(), bid);
        String message = valid ? "bid successful" : "bid unsuccessful";
        return new ActionResult(valid, 0, 0, message, this);
    }

    @Override
    public ActionResult doAction(GameModel game) {
        ActionResult result = tryAction();
        if(result.isSuccess()) {
            PalaceFestivalPlayer player = game.getCurrentPalaceFestivalPlayer();
            int total = 0;
            for (Card card : bid) {
                player.playCard(card);
                game.discard(card);
                total += CardValues.getMatchValue(card, game.peekAtFestivalCard());
            }

            if (total > game.getHighestBid()) {
                game.setHighestBid(total);
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
