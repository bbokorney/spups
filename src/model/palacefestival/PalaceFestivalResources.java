package model.palacefestival;

import java.util.Stack;

/**
 * Created by Baker on 4/14/2014.
 */
public class PalaceFestivalResources implements CardGameResources<Card> {

    private Stack<Card> deck;
    private Stack<Card> discard;
    private Card festivalCard;

    public PalaceFestivalResources(Stack<Card> deck) {
        this.deck = deck;
        this.discard = new Stack<Card>();
        this.festivalCard = this.deck.pop();
    }

    @Override
    public Card peekAtFaceUpCard() {
        return festivalCard;
    }

    @Override
    public Card drawFaceUpCard() {
        Card currentFestivalCard = festivalCard;
        festivalCard = deck.pop();
        return currentFestivalCard;
    }

    @Override
    public Card drawCardFromDeck() {
        Card drawnCard = deck.pop();
        if (deck.isEmpty()) {
            deck.addAll(discard);
            discard.clear();
        }

        return drawnCard;
    }

    @Override
    public void discard(Card card) {
        discard.push(card);
    }

}
