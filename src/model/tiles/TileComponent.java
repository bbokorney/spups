package model.tiles;

import model.rules.tiles.Visitor;

/**
 * Created by Baker on 4/14/2014.
 */
public abstract class TileComponent implements Visitable {

	private int height;
    private Tile parent;
	
	public int getHeight() {
		return height;
	}

    public Tile getParent() {
        return parent;
    }

    public void accept(Visitor visitor) {}
}
