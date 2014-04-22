package pathfinding;

import sun.security.util.PathList;

import java.util.*;

/**
 * Created by Baker on 4/14/2014.
 */
public class PathFinder<Node extends PathNode<Node>, Edge extends PathEdge<Node>> {
    public Path<Node> findShortestPath(Node src, Node dest) {
        PathListNode destNode = null;
        PriorityQueue<PathListNode> pq = new PriorityQueue<PathListNode>();
        Set<Node> inPath = new HashSet<Node>();
        // add the source node to start the search from
        pq.add(new PathListNode(src, null, 0));
        while(!pq.isEmpty()) {
            PathListNode curr = pq.poll();
            inPath.add(curr.node);

            // if we've found the destination, we're done
            if(curr.node.equals(dest)) {
                destNode = curr;
                break;
            }
            // for each neighbor of current node
            for(PathEdge<Node> edge : curr.node.getEdges()) {
                // add the neighbor to the priority queue
                if(!inPath.contains(edge.getDestination())) {
                    pq.add(new PathListNode(edge.getDestination(), curr, curr.cost + edge.getCost()));
                }
            }
        }
        if(destNode == null) {
            return new Path<Node>(false, 0, new ArrayList<Node>());
        }

        List<Node> path = new ArrayList<Node>();
        PathListNode curr = destNode;
        while(curr != null) {
            path.add(curr.node);
            curr = curr.previous;
        }

        return new Path<Node>(true, destNode.cost, path);
    }

    private List<Node> getPathList(PathListNode startNode) {
        List<Node> path = new ArrayList<Node>();
        PathListNode curr = startNode;
        while(curr != null) {
            path.add(curr.node);
            curr = curr.previous;
        }
        return path;
    }

    private class PathListNode implements Comparable<PathListNode> {
        Node node;
        PathListNode previous;
        int cost;
        PathListNode(Node node, PathListNode previous, int cost) {
            this.node = node;
            this.previous = previous;
            this.cost = cost;
        }
        public int compareTo(PathListNode p) {
            if(this.cost != p.cost) {
                return this.cost < p.cost ? -1 : 1;
            }
            else {
                return getPathList(this).size() < getPathList(p).size() ? -1 : 1;
            }
        }

        public String toString() {
            return node.toString();
        }
    }
}
