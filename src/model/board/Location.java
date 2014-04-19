package model.board;

import model.actions.serialization.Serializable;

/**
 * Created by Baker on 4/14/2014.
 */
public interface Location extends Serializable{

	public Location getOrigin();
	
	public int hashCode();
	
	public boolean equals(Location loc);

}
