package pathfinding;

/**
 * Created by Baker on 4/14/2014.
 */
public interface PathEdge {
    PathNode getSource();
    PathNode getDestination();
    boolean equals(PathEdge edge);
    int getCost();
}
