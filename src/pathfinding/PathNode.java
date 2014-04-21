package pathfinding;

import java.util.List;
import java.util.Set;

/**
 * Created by Baker on 4/14/2014.
 */
public interface PathNode<E> {
    List<PathEdge<E>> getEdges();
    boolean equals(PathNode<E> pathNode);
    void addEdge(PathEdge<E> edge);
}
