package model.rules.developer;

import model.palacefestival.PalaceCardComponent;
import model.player.Developer;
import model.rules.tiles.Visitor;
import model.tiles.IrrigationTileComponent;
import model.tiles.PalaceTileComponent;
import model.tiles.RiceTileComponent;
import model.tiles.VillageTileComponent;

/**
 * Created by Baker on 4/14/2014.
 */
public class DeveloperPlaecmentRule implements Visitor {
    private boolean allowed;
    private Developer developer;

    public DeveloperPlaecmentRule(Developer developer) {
        this.developer = developer;
    }

    public boolean allowed() {
        return allowed;
    }

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
