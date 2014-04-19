package model.rules.palace;

import model.board.*;
import model.player.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * Created by Baker on 4/14/2014.
 */
public class HighestRankingPlayerInCityRule {
    public static boolean highestRankingPlayerInCityRule(Player player,
                             Location location, BoardRuleHelper helper, Board board) {
        Collection<City> cities = board.getCityContainer().getCityCollection();
        City containingCity = null;
        for(City city : cities) {
            if(city.getCity().contains(location)) {
                Map<Player, Integer> ranks = helper.getPlayerRanksIn(city.getCity());
                // if this player doesn't have developers in this area or isn't ranked first
                if(!ranks.containsKey(player) || ranks.get(player) != 1) {
                    return false;
                }
                // check for ties
                int oneCount = 0;
                for(Player p : ranks.keySet()) {
                    if(ranks.get(p) == 1) {
                        ++oneCount;
                    }
                }
                if(oneCount > 1) { // there was a tile
                    return false;
                }
                return true;
            }
        }

        if(containingCity == null) {
            return false;
        }

        return false;
    }
}
