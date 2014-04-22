package model.palacefestival;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
        if(!deck.empty()){
            festivalCard = deck.pop();
        }
        else{
            replaceUnusedDeck();
            if(!deck.empty()){
                festivalCard = deck.pop();
            }
            else{
                return null;
            }
        }
        return currentFestivalCard;
    }

    @Override
    public Card drawCardFromDeck() {
        if(!deck.isEmpty()) {
            Card drawnCard = deck.pop();
            if (deck.isEmpty()) {
                replaceUnusedDeck();
            }

            return drawnCard;
        }
        return null;
    }

    @Override
    public boolean drawSpecificCardFromDeck(Card card) {
        boolean deckContainsCard = deck.contains(card);
        if (deckContainsCard) {
            deck.remove(card);
        }

        return deckContainsCard;
    }

    @Override
    public void discard(Card card) {
        discard.push(card);
    }

    public void shuffleUnusedDeck(){
        shuffleDeck(deck);
    }

    private void shuffleDiscardDeck(){
        shuffleDeck(discard);
    }

    private void replaceUnusedDeck(){
        if (!discard.isEmpty()) {
            shuffleDiscardDeck();
            deck.addAll(discard);
            discard.clear();
            deck = discard;
        }
    }

    private void shuffleDeck(Stack<Card> deck) {
       ArrayList<Card> cards = new ArrayList<Card>();
       while(!deck.isEmpty()){
           cards.add(deck.pop());
       }
       Collections.shuffle(cards);
       Card[] cardsArray = cards.toArray(new Card[0]);
      for(int i = 0; i < cardsArray.length; i++){
          deck.push(cardsArray[i]);
      }

    }

    public int getDeckSize() {
		return deck.size();
	}

    public boolean doesDeckHaveCard() {
        return deck != null;
    }
}
