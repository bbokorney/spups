package pathfinding;

import model.board.HexLocation;
import model.board.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Baker on 4/14/2014.
 */
public class JavaPath {
    private Path<JavaNode> path;

    public boolean valid() {
        return path.valid();
    }

    public int getCost() {
        return path.getCost();
    }

    public List<Location> getPath() {
        List<Location> locations = new ArrayList<Location>();
        for(int i = 0; i < path.getPath().size(); ++i) {
            locations.add(path.getPath().get(i).getLocation());
        }
        return locations;
    }
}
