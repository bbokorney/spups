package pathfinding;

import model.board.HexLocation;

/**
 * Created by Baker on 4/14/2014.
 */
public class JavaEdge implements PathEdge {
    public HexLocation getSource() {
        return null;
    }

    public PathNode getDestination() {
        return null;
    }

    public boolean equals(PathEdge edge) {
        return false;
    }

    public int getCost() {
        return 0;
    }
}
