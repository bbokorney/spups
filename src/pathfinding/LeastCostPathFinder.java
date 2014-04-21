package pathfinding;

import model.board.Board;
import model.board.HexLocation;
import model.board.Location;
import model.player.Developer;
import model.player.JavaPlayer;

import java.util.*;

/**
 * Created by Baker on 4/14/2014.
 */
public class LeastCostPathFinder {
    public JavaPath findShortestPath(Location src, Location destination, JavaPlayer player, Board board) {
        PathFinder<JavaNode, JavaEdge> pathFinder = new PathFinder<JavaNode, JavaEdge>();

        Map<Location, JavaNode> visited = new HashMap<Location, JavaNode>();
        Queue<JavaNode> queue = new LinkedList<JavaNode>();
        JavaNode source = new JavaNode(src);
        visited.put(src, source);
        // start the BFS from the developer's starting location
        queue.add(source);
        while(!queue.isEmpty()) {
            JavaNode curr = queue.poll();

            // get all of the valid edges
            for(Location neighbor : curr.getLocation().getNeighbors()) {
                JavaEdge edge = getEdgeBetween(neighbor, player, board);
                if(edge != null) {
                    curr.addEdge(edge);
                    if(!visited.containsKey(edge.getDestination().getLocation())) {
                        queue.add(edge.getDestination());
                    }
                }
            }
        }


        return null;
    }

    public JavaPath findShortestPlacementPath(Location placementLocation, JavaPlayer player, Board board) {
        return null;
    }

    public JavaPath findShortestRemovalPath(Location removalLocation, JavaPlayer player, Board board) {
        return null;
    }

    private JavaEdge getEdgeBetween(Location location, JavaPlayer player, Board board) {
        return null;
    }
}
