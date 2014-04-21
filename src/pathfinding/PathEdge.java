package pathfinding;

/**
 * Created by Baker on 4/14/2014.
 */
public interface PathEdge<T> {
    T getSource();
    T getDestination();
    int getCost();
    boolean equals(Object o);
    int hashCode();
}
