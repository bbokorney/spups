package model.board;

import pathfinding.PathEdge;
import pathfinding.PathNode;

import java.util.Set;

/**
 * Created by Baker on 4/14/2014.
 */
public class HexLocation implements Location, PathNode {

    public Set<PathEdge> getNeighbors() {
        return null;
    }

    public boolean equals(PathNode pathNode) {
        return false;
    }
}
