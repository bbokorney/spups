package model.rules.palace;

import model.board.*;
import model.player.JavaPlayer;
import model.player.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * Created by Baker on 4/14/2014.
 */
public class HighestRankingPlayerRule {
    public static boolean highestRankingPlayerInCityRule(JavaPlayer player,
                                                         Location location, BoardRuleHelper helper, Board board) {
        Collection<City> cities = board.getCityContainer().getCityCollection();
        City containingCity = null;
        for (City city : cities) {
            if (city.getCity().contains(location)) {
                return HighestRankingPlayerRule.isHighestRankingPlayerInCollection(player, city.getCity(), helper, board);
            }
        }

        if (containingCity == null) {
            return false;
        }

        return false;
    }

    public static boolean highestRankingPlayerInVillageRule(JavaPlayer player,
                                                            Location location, BoardRuleHelper helper, Board board) {
        Collection<Village> villages = board.getVillageContainer().getVillages();
        Village containingVillage = null;
        for (Village village : villages) {
            if (village.getLocations().contains(location)) {
                return HighestRankingPlayerRule.isHighestRankingPlayerInCollection(player, village.getLocations(), helper, board);
            }
        }

        if (containingVillage == null) {
            return false;
        }

        return false;
    }


    public static boolean isHighestRankingPlayerInCollection(JavaPlayer player, Collection<Location> locations , BoardRuleHelper helper, Board board){
        JavaPlayer highestRankedPlayer = HighestRankingPlayerRule.getHighestRankingPlayerInCollection(locations, helper, board);
        if(highestRankedPlayer != null ){
            if(highestRankedPlayer.equals(player)){
                return true;
            }
            System.out.println("Not the highest ranking");
        }
        else{
            System.out.println("Highest ranking player is null");
        }
        return false;
    }

    public static JavaPlayer getHighestRankingPlayerInCollection(Collection<Location> locations , BoardRuleHelper helper, Board board) {

        JavaPlayer highestRanked = null;
        Map<JavaPlayer, Integer> ranks = helper.getPlayerRanksIn(locations);
        // if this player doesn't have developers in this area or isn't ranked first
        if (ranks.isEmpty()) {
            return null;
        }
        // check for ties
        int oneCount = 0;
        for (JavaPlayer p : ranks.keySet()) {
            System.out.println(p.getName());
            if (ranks.get(p) == 1) {
                highestRanked = p;
                ++oneCount;
                System.out.println("ranks p was equal to one");
            }
        }
        if (oneCount > 1) { // there was a tile
            System.out.println("There was a tie");
            return null;

        }
        return highestRanked;
    }

}
