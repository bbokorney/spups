package model.actions.palacefestival;

import model.GameModel;
import model.actions.Action;
import model.actions.ActionResult;
import model.actions.serialization.JsonObject;
import model.board.BoardRuleHelper;
import model.board.Location;
import model.palacefestival.Card;
import model.palacefestival.PalaceFestival;
import model.palacefestival.PalaceFestivalPlayer;
import model.player.JavaPlayer;
import model.rules.palace.BidRequirementsRule;
import model.rules.palace.HasDeveloperInCityRule;

import java.util.Collection;
import java.util.List;

/**
 * Created by Baker on 4/14/2014.
 */
public class JoinFestival extends Action {

    private Location palaceLocation;
    private List<Card> cardsBidded;
    private GameModel game;
    private PalaceFestival festival;

    public JoinFestival(Location palaceLocation, List<Card> cardsBidded, GameModel game, PalaceFestival festival) {
        this.palaceLocation = palaceLocation;
        this.cardsBidded = cardsBidded;
        this.game = game;
        this.festival = festival;
    }

    @Override
    public ActionResult tryAction() {
        PalaceFestivalPlayer player = festival.getCurrentPlayer();
        Collection<JavaPlayer> javaPlayers = game.getJavaPlayers();
        JavaPlayer currentJavaPlayer = null;
        for (JavaPlayer javaPlayer : javaPlayers) {
            if(player.equals(javaPlayer)) {
                currentJavaPlayer = javaPlayer;
            }
        }

        // check if the player has a developer in the city
        boolean hasDeveloperInCity = HasDeveloperInCityRule.hasDeveloperInCity(currentJavaPlayer, palaceLocation, new BoardRuleHelper(game), game.getBoard());
        // check if the player's bid is high enough
        boolean bidMeetsRequirements = BidRequirementsRule.bidMeetsRequirements(festival.getHighestBid(), festival.peekAtFestivalCard(), cardsBidded);

        boolean canBegin = hasDeveloperInCity && bidMeetsRequirements;
        String message = canBegin ? "action successful" : "not eligible to join festival";
        return new ActionResult(false, 0, 0, message);
    }

    @Override
    public ActionResult doAction() {
        ActionResult result = tryAction();

        if (!result.isSuccess()) {
            festival.removePlayer(festival.getCurrentPlayer());
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



}
