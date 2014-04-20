package model.potentialactions;

import model.GameModel;
import model.JavaGameModel;

/**
 * Created by idinamenzel on 4/14/14.
 */
public abstract class PotentialAction {

    HoverBoard hoverBoard;
    JavaGameModel game;

    public PotentialAction(JavaGameModel game){
        this.game = game;
    }

    public PotentialAction(){
        hoverBoard = new HoverBoard();
    }

    public HoverBoard getHoverBoard(){
        return this.hoverBoard;
    }

    public abstract void setHoverBoard();


}
