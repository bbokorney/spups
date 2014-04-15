package model.rules.tiles;

import model.palacefestival.PalaceCardComponent;
import model.tiles.IrrigationTileComponent;
import model.tiles.RiceTileComponent;
import model.tiles.VillageTileComponent;

/**
 * Created by Baker on 4/14/2014.
 */
public class PalacePlacementRule implements Visitor {
    private boolean allowed;

    public PalacePlacementRule() {
        allowed = false;
    }

    public boolean allowed() { return allowed; }

    public void visit(VillageTileComponent component) {
        allowed = true;
    }

    public void visit(RiceTileComponent component) {
        allowed = false;
    }

    public void visit(PalaceCardComponent component) {
        allowed = false;
    }

    public void visit(IrrigationTileComponent component) {
        allowed = false;
    }
}
