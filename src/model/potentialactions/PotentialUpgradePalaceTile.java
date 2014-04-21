package model.potentialactions;

import model.GameModel;
import model.Pair;
import model.actions.ActionResult;
import model.actions.tiles.UpgradePalaceTile;
import model.board.BoardRuleHelper;
import model.board.Location;
import model.palacefestival.PalaceFestival;

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
    }

    public PotentialUpgradePalaceTile(GameModel game, PalaceFestival festival, int value) {
        super(game, festival);
        palacesLegalForUpgrading = helper.getPalacesLegalForUpgrading();
        indexOfCurrentPalace = 0;
        this.value = value;
    }

    public void tabToNextPalace(){
        indexOfCurrentPalace += 1;
        indexOfCurrentPalace %= indexOfCurrentPalace;
    }

    @Override
    public ActionResult getActionResult() {
        return new UpgradePalaceTile(palacesLegalForUpgrading.get(indexOfCurrentPalace), value, getGameModel()).tryAction();
    }

    public Pair<ActionResult, UpgradePalaceTile> chooseCurrentPlaceToUpgrade(){
        UpgradePalaceTile result = new UpgradePalaceTile(palacesLegalForUpgrading.get(indexOfCurrentPalace), value, getGameModel());
        return new Pair<ActionResult, UpgradePalaceTile>(result.doAction(), result);

    }
}
