package pathfinding;

import model.board.HexLocation;

/**
 * Created by Baker on 4/14/2014.
 */
public class JavaEdge implements PathEdge<JavaNode> {
    private JavaNode source;
    private JavaNode destination;
    private int cost;

    public JavaEdge(JavaNode source, JavaNode destination, int cost) {
        this.source = source;
        this.destination = destination;
        this.cost = cost;
    }

    public JavaNode getSource() { return source; }

    public JavaNode getDestination() {
        return destination;
    }

    public int getCost() {
        return cost;
    }
}
