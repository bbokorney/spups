package pathfinding;

import java.util.List;

/**
 * Created by Baker on 4/14/2014.
 */
public class Path<Node extends PathNode> {

    private boolean valid;
    private int cost;
    private List<Node> path;

    public Path(boolean valid, int cost, List<Node> path) {
        this.valid = valid;
        this.cost = cost;
        this.path = path;
    }

    public boolean valid() {
        return valid;
    }

    public int getCost() {
        return cost;
    }

    public List<Node> getPath() {
        return path;
    }
}
