package model.tiles;

import model.rules.tiles.Visitor;

/**
 * Created by Baker on 4/14/2014.
 */
public class PalaceTileComponent extends TileComponent {
    private boolean isFaceUp;
    private int level;

    public PalaceTileComponent(Tile parent, int level) {
        super(parent);
        this.level = level;
	    isFaceUp = true;
    }

    public PalaceTileComponent(int level) {
        super(new Tile(1));
        this.level = level;
	    isFaceUp = true;
    }

    public void flip() {
        isFaceUp = !isFaceUp;
    }

    public int getLevel() {
        return level;
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void upgrade(int level) {
        //Written as a boolean variable in UML? Why?
        if (!isFaceUp)
            flip();
        this.level = level;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
