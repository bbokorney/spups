package model.tiles;

import model.rules.tiles.Visitor;

/**
 * Created by Baker on 4/14/2014.
 */
public class VillageTileComponent extends TileComponent {


    public VillageTileComponent(Tile parent) {
        super(parent);
    }

    public VillageTileComponent() {

    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
