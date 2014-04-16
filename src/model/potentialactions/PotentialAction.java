package model.potentialactions;

import model.GameModel;
import model.JavaGameModel;
import model.actions.ActionResult;

/**
 * Created by idinamenzel on 4/14/14.
 */
public abstract class PotentialAction {

    HoverBoard hoverBoard;
    GameModel game;

    public PotentialAction(GameModel game){

        this.game = game;
    }

    public PotentialAction(){

        this.hoverBoard = new HoverBoard();
    }

    public HoverBoard getHoverBoard(){

        return this.hoverBoard;
    }

    protected abstract void setComponentsOnHoverBoard();

    protected abstract ActionResult getActionResult();

    protected GameModel getGameModel(){

        return this.game;
    }


}
