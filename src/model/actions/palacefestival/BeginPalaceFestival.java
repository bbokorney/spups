package model.actions.palacefestival;

import model.GameModel;
import model.Pair;
import model.actions.Action;
import model.actions.ActionResult;
import model.actions.serialization.JsonObject;
import model.board.Board;
import model.board.City;
import model.board.CityContainer;
import model.board.Location;
import model.palacefestival.Card;
import model.palacefestival.PalaceFestivalPlayer;
import model.rules.palace.CardValues;
import model.rules.palace.HostPalaceFestivalEligibilityRule;
import model.tiles.PalaceTileComponent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Baker on 4/14/2014.
 */
public class BeginPalaceFestival extends Action {

    private int palaceValueForFestival;
    private Location palaceLocation;
    private List<Card> cardsBidded;

    public BeginPalaceFestival(int palaceValueForFestival, Location palaceLocation, List<Card> cardsBidded) {
        this.palaceValueForFestival = palaceValueForFestival;
        this.palaceLocation = palaceLocation;
        this.cardsBidded = cardsBidded;
    }

    private PalaceTileComponent getPalace(GameModel game, Location location) {
        Board board = game.getBoard();
        CityContainer cityContainer = board.getCityContainer();
        Collection<City> cities = cityContainer.getCityCollection();
        for (City city : cities) {
            if (city.getPalaceLocation().equals(location))
                return city.getPalaceTile();
        }

        return null;
    }

    @Override
    public ActionResult tryAction(GameModel game) {
        PalaceFestivalPlayer player = game.getCurrentPalaceFestivalPlayer();
        boolean canBegin = HostPalaceFestivalEligibilityRule.hostPalaceFestivalEligibilityRule(player, palaceLocation, game.peekAtFestivalCard());
        String message = canBegin ? "starting palace festival..." : "not eligible to begin festival";
        return new ActionResult(false, 0, 0, message, this);
    }

    @Override
    public ActionResult doAction(GameModel game) {
        ActionResult result = tryAction(game);
        if (result.isSuccess()) {
            PalaceTileComponent palace = getPalace(game, palaceLocation);
            PalaceFestivalPlayer player = game.getCurrentPalaceFestivalPlayer();
            int totalBid = 0;
            for (Card card : cardsBidded) {
                player.playCard(card);
                game.discard(card);
                int bid = CardValues.getMatchValue(card, game.peekAtFestivalCard());
                totalBid += bid;
            }

            game.beginPalaceFestival(palace, totalBid);
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
