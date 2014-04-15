package model.board;

import pathfinding.PathEdge;
import pathfinding.PathNode;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

/**
 * Created by Baker on 4/14/2014.
 */
public class HexLocation implements Location, PathNode {

    public boolean equals(PathNode pathNode) {
        return false;
    }
	
		private List<Directions> pathFromOrigin; 
	
	public HexLocation(List<Directions> path) {
		pathFromOrigin = path;
	}
	
	//Return origin location (a location with empty path)
	public Location getOrigin() {
		return new HexLocation(new ArrayList<Directions>());
	}
	
	public int hashcode() {
	
		return 0; //for testing
	}
	
	public boolean equals(Location loc) {
		if (loc instanceof HexLocation) {
			HexLocation hexloc = (HexLocation) loc;
			return pathFromOrigin == hexloc.getPathFromOrigin();
		}
		else 
			return false;
	}
	
	//Returns an ordered list of all neighbors in clockwise direction, starting
	//from up
	public List<Location> getNeighbors() {
		//TODO: ask if this is runtime type checking or whatever
		List<Location> neighbors = new ArrayList<Location>();
		
		//For each direction, append our own path with that direction,
		//create a new Location object with that new path, and add it to our
		//list of neighbors
		for (Directions direction : Directions.values()) {
			List<Directions> path = pathFromOrigin;
			path.add(direction);
			Location neighbor = new HexLocation(path);
			neighbors.add(neighbor);
		}
		
		return neighbors;
	}
	
	public List<Directions> getPathFromOrigin() {
		return pathFromOrigin;
	}

    public List<PathEdge> getEdges() { return null; }
}
