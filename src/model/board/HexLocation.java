package model.board;

import pathfinding.JavaEdge;
import pathfinding.Path;
import pathfinding.PathEdge;
import pathfinding.PathNode;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Baker on 4/14/2014.
 */
public class HexLocation implements Location {

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
//        String directions = "";
//        int hashCode = 0;
//	    for (Directions d : pathFromOrigin) {
//            directions = directions.concat(d.toString());
//        }
//        hashCode = directions.hashCode();
//		return hashCode;
        return (getDistanceFromOrigin()[0] + "," + getDistanceFromOrigin()[1])
                .hashCode();
    }
	
	public boolean equals(Object loc) {
        System.out.println("HexLocation equals(...)");
        if (loc instanceof HexLocation) {
			HexLocation hexloc = (HexLocation) loc;
            int[] myDistance = getDistanceFromOrigin();
            int[] theirDistance = hexloc.getDistanceFromOrigin();
			return ((myDistance[0] == theirDistance[0])
                    &&
                    (myDistance[1] == theirDistance[1]));
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
			List<Directions> path = new ArrayList<Directions>(pathFromOrigin);
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

    public void appendPath(Directions d) {
        pathFromOrigin.add(d);
    }

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
        HexLocation loc = new HexLocation(new ArrayList<Directions>(pathFromOrigin));
        switch (i) {
            case 0:
                loc.appendPath(Directions.NORTH);
                break;
            case 1:
                loc.appendPath(Directions.NORTHEAST);
                break;
            case 2:
                loc.appendPath(Directions.SOUTHEAST);
                break;
            case 3:
                loc.appendPath(Directions.SOUTH);
                break;
            case 4:
                loc.appendPath(Directions.SOUTHWEST);
                break;
            case 5:
                loc.appendPath(Directions.NORTHWEST);
                break;
        }


        return loc;
    }

    /* This awesomely awesome algorithm will identify the distance from
     * this tile to the origin based on a magical mix of the current path
     * and geometry. Prepare to be amazed.
     */
    public int[] getDistanceFromOrigin() {
        int xdistance = 0;
        int ydistance = 0;
        for (Directions d : pathFromOrigin) {
            switch (d) {
                case SOUTH:
                    ydistance-=60;
                    break;
                case NORTH:
                    ydistance+=60;
                    break;
                case NORTHEAST:
                    ydistance+=30;
                    xdistance+=52;
                    break;
                case SOUTHEAST:
                    ydistance-=30;
                    xdistance+=52;
                    break;
                case SOUTHWEST:
                    ydistance-=30;
                    xdistance-=52;
                    break;
                case NORTHWEST:
                    ydistance+=30;
                    xdistance-=52;
                    break;
            }
        }
        int[] vectorDistance = new int[2];
        vectorDistance[0] = xdistance;
        vectorDistance[1] = ydistance;
        return vectorDistance;
    }

}
