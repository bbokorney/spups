package model.rules.palace;

import model.board.Board;
import model.board.BoardRuleHelper;
import model.board.City;
import model.board.Location;
import model.player.JavaPlayer;

import java.util.Collection;
import java.util.Map;

/**
 * Created by Owner on 4/19/14.
 */
public class HasDeveloperInCityRule {

    public static boolean hasDeveloperInCity(JavaPlayer player, Location palaceLocation, BoardRuleHelper helper, Board board) {
        Collection<City> cities = board.getCityContainer().getCityCollection();
        for( City city : cities ) {
            if( city.getCity().contains( palaceLocation ) ) {
                Map<JavaPlayer, Integer> ranks = helper.getPlayerRanksIn( city.getCity() );
                // if this player has developers in this area
                if( ranks.containsKey(player) )
                    return true;
            }
        }

        return false;
    }

}

