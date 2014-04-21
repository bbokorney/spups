package model.potentialactions;

import model.actions.ActionResult;
import model.actions.palacefestival.BeginPalaceFestival;
import model.board.City;
import model.board.CityContainer;
import model.board.Location;
import model.palacefestival.Card;
import model.palacefestival.PalaceFestivalPlayer;
import model.rules.palace.CardValues;
import model.tiles.PalaceTileComponent;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Baker on 4/14/2014.
 */
public class PotentialBeginPalaceFestival extends PotentialAction {

    private ArrayList<PalaceTileComponent> palacesValidForFestival;
    private ArrayList<Location> locationsValidForFestival;
    private ArrayList<Card> cardsValidToBeginFestival;
    private ArrayList<Integer> indexOfCardsToBid;
    private int cardIndex;
    private int palaceIndex;
    private PalaceTileComponent selectedPalace;
    private Location selectedPalaceLocation;

    public PotentialBeginPalaceFestival() {
        this.palacesValidForFestival = new ArrayList<PalaceTileComponent>();
        this.locationsValidForFestival = new ArrayList<Location>();
        this.cardsValidToBeginFestival = new ArrayList<Card>();
        this.indexOfCardsToBid = new ArrayList<Integer>();
        this.cardIndex = 0;
        this.palaceIndex = 0;
        this.selectedPalace = null;
        this.selectedPalaceLocation = null;

        // Calculate valid cards
        PalaceFestivalPlayer player = getPalaceFestival().getCurrentPlayer();
        Collection<Card> hand = player.getHand();
        for (Card card : hand) {
            if (CardValues.getMatchValue(card, getPalaceFestival().peekAtFestivalCard()) > 0)
                cardsValidToBeginFestival.add(card);
        }

        // calculate valid palaces & locations
        CityContainer cityContainer = getGameModel().getBoard().getCityContainer();
        for(City city : cityContainer.getCityCollection()) {
            PalaceTileComponent palaceTileComponent = city.getPalaceTile();
            if (palaceTileComponent.isFaceUp()) {
                palacesValidForFestival.add(palaceTileComponent);
                locationsValidForFestival.add(city.getPalaceLocation());
            }
        }
    }

    public boolean tabToNextPalace() {
        palaceIndex++;
        palaceIndex %= palacesValidForFestival.size();
        return true;
    }

    public boolean tabToNextCard() {
        palaceIndex++;
        palaceIndex %= palacesValidForFestival.size();
        return true;
    }

    public boolean tabToPreviousCard() {
        palaceIndex--;
        palaceIndex %= palacesValidForFestival.size();
        return true;
    }

    public boolean chooseCurrentPalace() {
        selectedPalace = palacesValidForFestival.get(palaceIndex);
        selectedPalaceLocation = locationsValidForFestival.get(palaceIndex);
        return true;
    }

    public boolean chooseCurrentCard() {
        if (!indexOfCardsToBid.contains(cardIndex)) {
            indexOfCardsToBid.add(cardIndex);
        }

        return true;
    }

    public boolean removeCurrentCardFromBid() {
        if (!indexOfCardsToBid.contains(cardIndex)) {
            indexOfCardsToBid.remove(cardIndex); // might be a bug
        }

        return true;
    }

    public ActionResult confirmBid() {
        boolean palaceSelected = selectedPalace != null;
        boolean bidSelected = indexOfCardsToBid.size() > 0;
        if(!palaceSelected) {
            return new ActionResult(false, 0, 0, "no palace has been selected for the festival");
        }

        if (!bidSelected) {
            return new ActionResult(false, 0, 0, "no bid has been selected for the festival");
        }

        ArrayList<Card> bid = new ArrayList<Card>();
        for (int index : indexOfCardsToBid) {
            bid.add(cardsValidToBeginFestival.get(index));
        }
        return new BeginPalaceFestival(getGameModel(), getPalaceFestival(), selectedPalace.getLevel(), selectedPalaceLocation ,bid).tryAction();
    }

    private void setComponentsOnHoverBoard() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ActionResult getActionResult() {
        return confirmBid();
    }

}
