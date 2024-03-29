package model.board;

import model.actions.serialization.Serializable;

import java.util.List;

/**
 * Created by Baker on 4/14/2014.
 */
public interface Location extends Serializable {

	public Location getOrigin();
	
	public int hashCode();
	
	public boolean equals(Object loc);

    public List<Location> getNeighbors();

    public int[] getDistanceFromOrigin();

}
