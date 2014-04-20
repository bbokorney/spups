package model.potentialactions;

import model.GameModel;
import model.actions.ActionResult;
import model.palacefestival.PalaceFestival;

/**
 * Created by idinamenzel on 4/14/14.
 */
public abstract class PotentialAction {

    private HoverBoard hoverBoard;
    private GameModel game;
    private PalaceFestival festival;

    public PotentialAction(GameModel game, PalaceFestival festival){

        this.game = game;
        this.festival = festival;
    }

    public PotentialAction(){

        this.hoverBoard = new HoverBoard();
    }

    public HoverBoard getHoverBoard(){

        return this.hoverBoard;
    }

    protected abstract void setComponentsOnHoverBoard();

    protected GameModel getGameModel(){

        return this.game;
    }

    protected PalaceFestival getPalaceFestival(){

        return this.festival;
    }

}
