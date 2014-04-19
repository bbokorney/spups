package model.rules.tiles;

import model.tiles.IrrigationTileComponent;
import model.tiles.PalaceTileComponent;
import model.tiles.RiceTileComponent;
import model.tiles.VillageTileComponent;

/**
 * Created by Baker on 4/14/2014.
 */
public interface Visitor {
    void visit(VillageTileComponent component);
    void visit(RiceTileComponent component);
    void visit(PalaceTileComponent component);
    void visit(IrrigationTileComponent component);
}
