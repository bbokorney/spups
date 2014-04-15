package model.board;

import java.util.HashMap;
import model.tiles.TileComponent;

/**
 * Created by Baker on 4/14/2014.
 */
public abstract class Board {

	private HashMap<Location, Space> board;
	
	public Board() {
		board = new HashMap<Location, Space>();
	}
	
	public void placeSpace(Location loc, Space space) {
		board.put(loc, space);
	}
	
	public Space getSpace(Location loc) {
		return board.get(loc);
	}
	
	public void placeTopTileComponent(Location loc, TileComponent tile) {
		Space space = board.get(loc);
		space.accept(tile);
	}
	
	public TileComponent getTopTileComponent(Location loc) {
		Space space = board.get(loc);
		return space.getTopTileComponent();
	}
}
