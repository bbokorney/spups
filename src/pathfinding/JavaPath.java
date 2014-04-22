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

    public JavaPath(Path<JavaNode> path) {
        this.path = path;
    }

    public boolean valid() {
        return path.valid();
    }

    public int getCost() {
        return path.getCost();
    }

    public void setCost(int cost) { path.setCost(cost);}

    public List<Location> getPath() {
        List<Location> locations = new ArrayList<Location>();
        for(int i = 0; i < path.getPath().size(); ++i) {
            locations.add(path.getPath().get(i).getLocation());
        }
        return locations;
    }

    public String toString() {
        return String.format("%s, %s, %s", valid(), getCost(), getPath().size());
    }
}
