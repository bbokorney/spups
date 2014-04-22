package pathfinding;

import model.board.Location;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Baker on 4/20/2014.
 */
class JavaNode implements PathNode<JavaNode> {

    private Location location;
    private HashSet<PathEdge<JavaNode>> edges;

    public JavaNode(Location location) {
        this.location = location;
        edges = new HashSet<PathEdge<JavaNode>>();
    }

    public boolean equals(PathNode pathNode) {
        if(pathNode instanceof JavaNode) {
            JavaNode other = (JavaNode) pathNode;
            return this.location.equals(other.location);
        }
        return false;
    }

    public Set<PathEdge<JavaNode>> getEdges() {
        return edges;
    }

    public void addEdge(PathEdge<JavaNode> edge) {
        edges.add(edge);
    }

    public Location getLocation() { return location; }

    public String toString() { return location.toString(); }
}
