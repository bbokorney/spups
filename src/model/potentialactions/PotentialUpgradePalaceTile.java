package model.potentialactions;

import controller.keylistener.InternalListener;
import model.GameModel;
import model.Pair;
import model.actions.ActionResult;
import model.actions.tiles.UpgradePalaceTile;
import model.board.BoardRuleHelper;
import model.board.Location;
import model.palacefestival.PalaceFestival;
import model.tiles.PalaceTileComponent;

import java.util.List;

/**
 * Created by Baker on 4/14/2014.
 */
public class PotentialUpgradePalaceTile extends PotentialAction{

    List<Location> palacesLegalForUpgrading;
    int indexOfCurrentPalace;
    BoardRuleHelper helper = new BoardRuleHelper(getGameModel());
    int value;

    public PotentialUpgradePalaceTile(GameModel game, PalaceFestival festival) {
        super(game, festival);
        palacesLegalForUpgrading = helper.getPalacesLegalForUpgrading();
        indexOfCurrentPalace = 0;
        System.out.println(palacesLegalForUpgrading);
        value = 2;

    }

    public int getLevel() {
        return value;
    }

    public void tabToNextPalace(){
        indexOfCurrentPalace += 1;
        indexOfCurrentPalace %= palacesLegalForUpgrading.size();
    }

    public Location getLocation() {
        if(palacesLegalForUpgrading.size() == 0) {
            return null;
        }
        return palacesLegalForUpgrading.get(indexOfCurrentPalace);
    }

    @Override
    public ActionResult getActionResult() {
        if(palacesLegalForUpgrading.size() == 0) {
            return new ActionResult(false, 0, 0, "No palaces available for upgrade.");
        }
        return new UpgradePalaceTile(palacesLegalForUpgrading.get(indexOfCurrentPalace), value, getGameModel()).tryAction();
    }

    public Pair<ActionResult, UpgradePalaceTile> chooseCurrentPlaceToUpgrade(){
        UpgradePalaceTile result = new UpgradePalaceTile(palacesLegalForUpgrading.get(indexOfCurrentPalace), value, getGameModel());
        return new Pair<ActionResult, UpgradePalaceTile>(result.doAction(), result);

    }

    public void incrementLevel() {
        if(value != 10) {
            value += 2;
        }
    }
    public void decrementLevel() {
        if(value != 2) {
            value -= 2;
        }
    }
}
