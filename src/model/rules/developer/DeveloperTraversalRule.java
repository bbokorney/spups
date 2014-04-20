package model.rules.developer;

import model.palacefestival.PalaceCardComponent;
import model.rules.tiles.Visitor;
import model.tiles.IrrigationTileComponent;
import model.tiles.RiceTileComponent;
import model.tiles.TileComponent;
import model.tiles.VillageTileComponent;

import javax.rmi.CORBA.Tie;

/**
 * Created by Baker on 4/14/2014.
 */
public class DeveloperTraversalRule implements Visitor {
    private int cost;
    private TileComponent source;
    private TileComponent destination;
    public DeveloperTraversalRule(TileComponent source, TileComponent destination) {
        this.source = source;
        this.destination = destination;
    }

    public int getCost() { return cost; }

    public void visit(VillageTileComponent component) {

    }

    public void visit(RiceTileComponent component) {

    }

    public void visit(PalaceCardComponent component) {

    }

    public void visit(IrrigationTileComponent component) {

    }
}
