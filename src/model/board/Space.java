package model.board;

/**
 * Created by Baker on 4/14/2014.
 */
abstract class Space {

	//Allows you to place a new tile component on this space
	abstract void accept(TileComponent tile);
	
	//Shows (but does not remove) top tile component at space
	abstract TileComponent getTopTileComponent();
	
	//Retrieves the height at the space
	abstract int getHeight();
}
