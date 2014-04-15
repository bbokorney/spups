package model.palacefestival;

import java.util.Stack;

/**
 * Created by Baker on 4/14/2014.
 */
public class PalaceFestivalResources implements CardGameResources<PalaceCard> {

    private Stack<PalaceCard> deck;
    private Stack<PalaceCard> discard;
    private PalaceCard festivalCard;

    public PalaceFestivalResources(Stack<PalaceCard> deck) {
        this.deck = deck;
        this.discard = new Stack<PalaceCard>();
        this.festivalCard = this.deck.pop();
    }

    @Override
    public PalaceCard peekAtFaceUpCard() {
        return festivalCard;
    }

    @Override
    public PalaceCard drawFaceUpCard() {
        PalaceCard currentFestivalCard = festivalCard;
        festivalCard = deck.pop();
        return currentFestivalCard;
    }

    @Override
    public PalaceCard drawCardFromDeck() {
        PalaceCard drawnCard = deck.pop();
        if (deck.isEmpty()) {
            deck.addAll(discard);
            discard.clear();
        }

        return drawnCard;
    }

    @Override
    public void discard(PalaceCard card) {
        discard.push(card);
    }

}
