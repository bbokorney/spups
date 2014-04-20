package model.actions.palacefestival;

import model.GameModel;
import model.actions.Action;
import model.actions.ActionResult;
import model.actions.serialization.JsonObject;
import model.board.*;
import model.palacefestival.Card;
import model.palacefestival.PalaceFestivalPlayer;
import model.player.JavaPlayer;
import model.player.Player;
import model.rules.palace.CardValues;
import model.rules.palace.HasDeveloperInCityRule;
import model.rules.palace.PalaceHasNotAlreadyHostedFestivalRule;
import model.tiles.PalaceTileComponent;

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
        boolean palaceIsEligible = PalaceHasNotAlreadyHostedFestivalRule.palaceHasNotAlreadyHostedFestival(getPalace(game, palaceLocation));
        Collection<JavaPlayer> javaPlayers = game.getJavaPlayers();
        JavaPlayer currentJavaPlayer = null;
        for (JavaPlayer javaPlayer : javaPlayers) {
            if(player.equals(javaPlayer)) {
                currentJavaPlayer = javaPlayer;
            }
        }

        boolean hasDeveloperInCity = HasDeveloperInCityRule.hasDeveloperInCity(currentJavaPlayer, palaceLocation, new BoardRuleHelper(game), game.getBoard());

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
