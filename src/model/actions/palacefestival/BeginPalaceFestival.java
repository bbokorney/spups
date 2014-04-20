package model.actions.palacefestival;

import model.GameModel;
import model.actions.Action;
import model.actions.ActionResult;
import model.actions.serialization.JsonObject;
import model.board.*;
import model.palacefestival.Card;
import model.palacefestival.PalaceFestival;
import model.palacefestival.PalaceFestivalPlayer;
import model.player.JavaPlayer;
import model.rules.palace.BidRequirementsRule;
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

    private GameModel game;
    private PalaceFestival festival;
    private int palaceValueForFestival;
    private Location palaceLocation;
    private List<Card> cardsBidded;

    public BeginPalaceFestival(GameModel game, PalaceFestival festival, int palaceValueForFestival, Location palaceLocation, List<Card> cardsBidded) {
        this.game = game;
        this.festival = festival;
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
    public ActionResult tryAction() {
        PalaceFestivalPlayer player = festival.getCurrentPlayer();
        boolean palaceIsEligible = PalaceHasNotAlreadyHostedFestivalRule.palaceHasNotAlreadyHostedFestival(getPalace(game, palaceLocation));
        Collection<JavaPlayer> javaPlayers = game.getJavaPlayers();
        JavaPlayer currentJavaPlayer = null;
        for (JavaPlayer javaPlayer : javaPlayers) {
            if(player.equals(javaPlayer)) {
                currentJavaPlayer = javaPlayer;
            }
        }

        boolean hasDeveloperInCity = HasDeveloperInCityRule.hasDeveloperInCity(currentJavaPlayer, palaceLocation, new BoardRuleHelper(game), game.getBoard());
        boolean bidMeetsRequirements = BidRequirementsRule.bidMeetsRequirements(festival.getHighestBid(),festival.peekAtFestivalCard(), cardsBidded);
        boolean canBegin = palaceIsEligible && hasDeveloperInCity && bidMeetsRequirements;
        String message = canBegin ? "starting palace festival..." : "not eligible to begin festival";
        return new ActionResult(false, 0, 0, message, this);
    }

    @Override
    public ActionResult doAction() {
        ActionResult result = tryAction();
        if (result.isSuccess()) {
            PalaceTileComponent palace = getPalace(game, palaceLocation);
            PalaceFestivalPlayer player = festival.getCurrentPlayer();
            int totalBid = 0;
            for (Card card : cardsBidded) {
                player.playCard(card);
                festival.discard(card);
                int bid = CardValues.getMatchValue(card, festival.peekAtFestivalCard());
                totalBid += bid;
            }

            festival.beginPalaceFestival(palace, totalBid, player);
        }

        festival.advanceTurn();
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
