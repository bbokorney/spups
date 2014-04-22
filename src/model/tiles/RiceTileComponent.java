package model.tiles;

import model.rules.tiles.Visitor;

/**
 * Created by Baker on 4/14/2014.
 */
public class RiceTileComponent extends TileComponent{


    public RiceTileComponent(Tile parent) {
        super(parent);
    }

    public RiceTileComponent() {
        super(new Tile(1));
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
