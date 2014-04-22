package model.potentialactions;

import model.Pair;
import model.actions.Action;
import model.actions.ActionResult;
import model.board.Board;
import model.board.JavaBoard;
import model.board.Location;
import model.tiles.TileComponent;

import java.util.List;
import java.util.Map;

/**
 * Created by idinamenzel on 4/15/14.
 */
public interface HexComponentPotentialAction {

    public ActionResult moveNorth();
    public ActionResult moveSouth();
    public ActionResult moveNortheast();
    public ActionResult moveNorthwest();
    public ActionResult moveSoutheast();
    public ActionResult moveSouthwest();
    public ActionResult getActionResult();
    public Pair<ActionResult, Action> confirmAction();

}
