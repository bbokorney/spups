package pathfinding;

import model.board.HexLocation;

import java.util.List;

/**
 * Created by Baker on 4/14/2014.
 */
public class JavaPath {
    private Path<HexLocation> path;

    public boolean valid() {
        return path.valid();
    }

    public int getCost() {
        return path.getCost();
    }

    public List<HexLocation> getPath() {
        return path.getPath();
    }
}
