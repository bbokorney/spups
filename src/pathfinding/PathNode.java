package pathfinding;

import java.util.Set;

/**
 * Created by Baker on 4/14/2014.
 */
public interface PathNode {
    Set<PathEdge> getNeighbors();
    boolean equals(PathNode pathNode);
}
