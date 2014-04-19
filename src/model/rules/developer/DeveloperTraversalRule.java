package model.rules.developer;

import model.rules.tiles.Visitor;
import model.tiles.*;

/**
 * Created by Baker on 4/14/2014.
 */
public class DeveloperTraversalRule {
    private TileComponent source;
    private TileComponent destination;

    public DeveloperTraversalRule(TileComponent source, TileComponent destination) {
        this.source = source;
        this.destination = destination;
    }

    public int getCost() {
        TraversalVisitor sourceVisitor = new TraversalVisitor();
        TraversalVisitor destinationVisitor = new TraversalVisitor();
        source.accept(sourceVisitor);
        destination.accept(destinationVisitor);

        return sourceVisitor.getType() == destinationVisitor.getType() ? 0 : 1;
    }

    private class TraversalVisitor implements Visitor {

        TileType type;

        public TileType getType() { return type; }

        public void visit(VillageTileComponent component) {
            type = TileType.Village;
        }

        public void visit(RiceTileComponent component) {
            type = TileType.Rice;
        }

        public void visit(PalaceTileComponent component) {
            type = TileType.Palace;
        }

        public void visit(IrrigationTileComponent component) {
            type = TileType.Irrigation;
        }
    }

    private enum TileType {
        Village, Rice, Palace, Irrigation;
    }
}
