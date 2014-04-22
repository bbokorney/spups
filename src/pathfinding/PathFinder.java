package pathfinding;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Baker on 4/14/2014.
 */
public class PathFinder<Node extends PathNode<Node>, Edge extends PathEdge<Node>> {
    public Path<Node> findShortestPath(Node src, Node dest) {
        PathListNode destNode = null;
        PriorityQueue<PathListNode> pq = new PriorityQueue<PathListNode>();
        // add the source node to start the search from
        pq.add(new PathListNode(src, null, 0));
        // while we haven't found the destination and there are
        // still nodes to explore
        while(!pq.isEmpty()) {
            PathListNode curr = pq.poll();
            // if we've found the destination, we're done
            if(curr.node.equals(dest)) {
                destNode = curr;
                break;
            }
            // for each neighbor of current node
            for(PathEdge<Node> edge : curr.node.getEdges()) {
                // add the neighbor to the priority queue
                pq.add(new PathListNode(edge.getDestination(), curr, curr.cost+edge.getCost()));
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
            return this.cost < p.cost ? -1 : 1;
        }
    }
}
