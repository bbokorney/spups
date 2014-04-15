package pathfinding;

import java.util.List;
import java.util.Set;

/**
 * Created by Baker on 4/14/2014.
 */
public interface PathNode {
    List<PathEdge> getEdges();
    boolean equals(PathNode pathNode);
}
