package model.board;

/**
 * Created by Baker on 4/14/2014.
 */
public interface Location {

	public Location getOrigin();
	
	public int hashcode();
	
	public boolean equals(Location loc);
}
