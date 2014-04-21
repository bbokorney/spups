package pathfinding;

import model.board.HexLocation;
import model.board.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Baker on 4/20/2014.
 */
class JavaNode implements PathNode<JavaNode> {

    private Location location;
    private ArrayList<PathEdge<JavaNode>> edges;

    public JavaNode(Location location) {
        this.location = location;
    }

    public boolean equals(PathNode pathNode) {
        if(pathNode instanceof JavaNode) {
            JavaNode other = (JavaNode) pathNode;
            return this.location.equals(other.location);
        }
        return false;
    }

    public List<PathEdge<JavaNode>> getEdges() {
        return edges;
    }

    public void addEdge(PathEdge<JavaNode> edge) {
        edges.add(edge);
    }

    public Location getLocation() { return location; }
}
