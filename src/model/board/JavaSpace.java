package model.board;

import java.util.Stack;
import java.util.Iterator;
import model.tiles.TileComponent;

/**
 * Created by Baker on 4/14/2014.
 */
public class JavaSpace extends Space{

	private Stack<TileComponent> tiles;
	
	public JavaSpace() {
		tiles = new Stack<TileComponent>();
	}
	
	public void accept(TileComponent tile) {
		tiles.push(tile);
	}
	
	public TileComponent getTopTileComponent() {
        return tiles.isEmpty() ? null : tiles.peek();
	}
	
	public int getHeight() {
		int height = 0;
		Iterator<TileComponent> iter = tiles.iterator();
		while (iter.hasNext()) {
			height += iter.next().getHeight();
		}
		return height;
	}
}
