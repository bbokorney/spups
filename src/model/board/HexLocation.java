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

    //A unique list representing this location's semantic location
	private List<Directions> pathFromOrigin;
	
	public HexLocation(List<Directions> path) {
		pathFromOrigin = path;
	}
	
	//Return origin location (a location with empty path)
	public Location getOrigin() {
		return new HexLocation(new ArrayList<Directions>());
	}
	
	public int hashCode() {
        String directions = "";
        int hashCode = 0;
	    for (Directions d : pathFromOrigin) {
            directions = directions.concat(d.toString());
        }
        hashCode = directions.hashCode();
		return hashCode;
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

    @Override
    public String serialize() {
        return null;
    }

    @Override
    public HexLocation restore(String serial) {
        return null;
    }

    public HexLocation getNeighbor(int i) {
        /*
            0 is north
            1 is northeast
            2 is southeast
            3 is south
            4 is southwest
            5 is northwest
         */

        return null;
    }

}
