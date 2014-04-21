package model.potentialactions;

import model.GameModel;
import model.actions.ActionResult;
import model.palacefestival.PalaceFestival;

/**
 * Created by idinamenzel on 4/14/14.
 */
public abstract class PotentialAction {

    private GameModel game;
    private PalaceFestival festival;

    public PotentialAction(GameModel game, PalaceFestival festival){

        this.game = game;
        this.festival = festival;
    }

    public PotentialAction(){

    }

    public abstract ActionResult getActionResult();

    protected GameModel getGameModel(){

        return this.game;
    }

    protected PalaceFestival getPalaceFestival(){

        return this.festival;
    }

    protected boolean isValid(){
        return getActionResult().isSuccess();
    }


}
