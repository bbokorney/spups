package model.board;

import model.tiles.TileComponent;
/**
 * Created by Baker on 4/14/2014.
 */
public abstract class Space {

	//Allows you to place a new tile component on this space
	public abstract void accept(TileComponent tile);
	
	//Shows (but does not remove) top tile component at space
	public abstract TileComponent getTopTileComponent();
	
	//Retrieves the height at the space
	public abstract int getHeight();
}
