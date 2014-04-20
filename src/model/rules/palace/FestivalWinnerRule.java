package model.rules.palace;

import model.palacefestival.PalaceFestivalPlayer;

import java.util.Collection;
import java.util.Map;

/**
 * Created by Owner on 4/20/14.
 */
public class FestivalWinnerRule {

    Map<Integer, Integer> winnerPoints;
    Map<Integer, Integer> tiePoints;

    public FestivalWinnerRule() {
        winnerPoints.put(2, 1);
        tiePoints.put(2, 0);
        winnerPoints.put(4, 2);
        tiePoints.put(4, 1);
        winnerPoints.put(6, 3);
        tiePoints.put(6, 2);
        winnerPoints.put(8, 4);
        tiePoints.put(8, 2);
        winnerPoints.put(10, 5);
        tiePoints.put(10, 3);
    }

    public int pointsToAward( boolean tie, int palaceLevel ) {
        return tie ? tiePoints.get(palaceLevel) : winnerPoints.get(palaceLevel);
    }

}
