package model.rules.developer;

import model.palacefestival.PalaceCardComponent;
import model.player.Developer;
import model.rules.tiles.Visitor;
import model.tiles.IrrigationTileComponent;
import model.tiles.RiceTileComponent;
import model.tiles.VillageTileComponent;

/**
 * Created by Baker on 4/14/2014.
 */
public class DeveloperPassThroughRule implements Visitor {
    private boolean allowed;
    private Developer developer;

    public DeveloperPassThroughRule(Developer developer) {
        this.developer = developer;
    }

    public boolean allowed() {
        return allowed;
    }

    public void visit(VillageTileComponent component) {

    }

    public void visit(RiceTileComponent component) {

    }

    public void visit(PalaceCardComponent component) {

    }

    public void visit(IrrigationTileComponent component) {

    }
}
