package model.rules.tiles;

import model.board.Board;
import model.board.Location;
import model.palacefestival.PalaceCardComponent;
import model.tiles.IrrigationTileComponent;
import model.tiles.PalaceTileComponent;
import model.tiles.RiceTileComponent;
import model.tiles.VillageTileComponent;

/**
 * Created by Baker on 4/14/2014.
 */
public class RicePlacementRule {
    private boolean allowed;
    private Location location;
    private Board board;

    public RicePlacementRule(Location location, Board board) {
        allowed = false;
        this.location = location;
        this.board = board;
    }

    public boolean allowed() {
        if(board.getSpace(location).getTopTileComponent() != null) {
            board.getSpace(location).getTopTileComponent().accept(new PlacementVisitor());
            return allowed;
        }
        return true;
    }

    private class PlacementVisitor implements Visitor {

        public void visit(VillageTileComponent component) {
            allowed = true;
        }

        public void visit(RiceTileComponent component) {
            allowed = true;
        }

        public void visit(PalaceTileComponent component) {
            allowed = false;
        }

        public void visit(IrrigationTileComponent component) {
            allowed = false;
        }
    }
}
