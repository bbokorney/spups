package model.potentialactions;

import model.Pair;
import model.actions.Action;
import model.actions.ActionResult;
import model.board.Board;
import model.board.JavaBoard;

/**
 * Created by idinamenzel on 4/15/14.
 */
public interface HexComponentMovement {

    public ActionResult moveNorth();
    public ActionResult moveSouth();
    public ActionResult moveNortheast();
    public ActionResult moveNorthwest();
    public ActionResult moveSoutheast();
    public ActionResult moveSouthwest();

}
