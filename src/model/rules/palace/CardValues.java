package model.rules.palace;

import model.palacefestival.Card;
import model.palacefestival.PalaceCardComponent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Owner on 4/19/14.
 */
public class CardValues {

    public static int getMatchValue(Card card1, Card card2) {

        List<PalaceCardComponent> cardComponentList1 = card1.getComponents();
        List<PalaceCardComponent> cardComponentList2 = card2.getComponents();

        int matchValue = 0;
        List<Integer> list1Indices = new ArrayList<Integer>();
        List<Integer> list2Indices = new ArrayList<Integer>();

        for (int i = 0; i < cardComponentList1.size(); i++) {
            for (int j = 0; j < cardComponentList2.size(); j++) {
                if(!list1Indices.contains(i) && !list2Indices.contains(j)) {
                    if (cardComponentList1.get(i).equals(cardComponentList2.get(j))) {
                        matchValue++;
                        list1Indices.add(i);
                        list2Indices.add(j);
                    }
                }
            }
        }

        return matchValue;

    }

}
