package model.rules.tiles;

import model.board.Board;
import model.board.Location;
import model.tiles.IrrigationTileComponent;
import model.tiles.PalaceTileComponent;
import model.tiles.RiceTileComponent;
import model.tiles.VillageTileComponent;

/**
 * Created by Baker on 4/14/2014.
 */
public class PalacePlacementRule {
    private boolean allowed;
    private Location location;
    private Board board;

    public PalacePlacementRule(Location location, Board board) {
        allowed = false;
        this.location = location;
        this.board = board;
    }

    public boolean buildAllowed() {
        if(board.getSpace(location).getTopTileComponent() != null) {
            board.getSpace(location).getTopTileComponent().accept(new BuildVisitor());
            return allowed;
        }
        return true;
    }

    public boolean upgradeAllowed(int value) {
        if(board.getSpace(location).getTopTileComponent() != null) {
            board.getSpace(location).getTopTileComponent().accept(new UpgradeVisitor());
            return allowed;
        }
        return true;
    }

    private class BuildVisitor implements Visitor {

        public void visit(VillageTileComponent component) {
            allowed = true;
        }

        public void visit(RiceTileComponent component) {
            allowed = false;
        }

        public void visit(PalaceTileComponent component) {
            allowed = false;
        }

        public void visit(IrrigationTileComponent component) {
            allowed = false;
        }
    }

    private class UpgradeVisitor implements Visitor {
        public void visit(VillageTileComponent component) {
            allowed = true;
        }

        public void visit(RiceTileComponent component) {
            allowed = false;
        }

        public void visit(PalaceTileComponent component) {
            allowed = true;
        }

        public void visit(IrrigationTileComponent component) {
            allowed = false;
        }
    }
}
