package pathfinding;

import model.GameModel;
import model.board.Location;
import model.board.LocationType;
import model.rules.developer.DeveloperPassThroughRule;
import model.rules.developer.DeveloperPlacementRule;
import model.rules.developer.DeveloperTraversalRule;

import java.util.*;

/**
 * Created by Baker on 4/14/2014.
 */
public class LeastCostPathFinder {
    private GameModel model;

    public LeastCostPathFinder(GameModel model) {
        this.model = model;
    }

    public JavaPath findShortestPath(Location src, Location dest) {
        PathFinder<JavaNode, JavaEdge> pathFinder = new PathFinder<JavaNode, JavaEdge>();
        Set<Location> visited = new HashSet<Location>();
        Map<Location, JavaNode> nodes = new HashMap<Location, JavaNode>();
        Queue<JavaNode> queue = new LinkedList<JavaNode>();
        JavaNode source = new JavaNode(src);
        nodes.put(src, source);
        // start the BFS from the developer's starting location
        queue.add(source);
        while(!queue.isEmpty()) {
            JavaNode curr = queue.poll();

            // get all of the valid edges
            for(Location neighbor : curr.getLocation().getNeighbors()) {
                List<JavaEdge> edges = getEdgesTo(curr.getLocation(), neighbor, nodes);
                for(JavaEdge edge : edges) {
                    if(edge != null) {
                        curr.addEdge(edge);
                        if(!visited.contains(edge.getDestination().getLocation())) {
                            queue.add(edge.getDestination());
                        }
                    }
                }
            }
        }

        return null;
    }

    public JavaPath findShortestPlacementPath(Location placementLocation) {
        JavaPath min = null;
        for(Location src : outerJavaLocations()) {
            JavaPath path = findShortestPath(src, placementLocation);
            if(min == null) {
                min = path;
            }
            else {
                min = path.valid() && path.getCost() < min.getCost() ? path : min;
            }
        }
        return min;
    }

    public JavaPath findShortestRemovalPath(Location removalLocation) {
        JavaPath min = null;
        for(Location dest : outerJavaLocations()) {
            JavaPath path = findShortestPath(removalLocation, dest);
            if(min == null) {
                min = path;
            }
            else {
                min = path.valid() && path.getCost() < min.getCost() ? path : min;
            }
        }
        return min;
    }

    private Collection<Location> outerJavaLocations() {
        Collection<Location> locations = new ArrayList<Location>();
        for(Location location : locations) {
            if(model.getBoard().getLocationType(location) == LocationType.Lowlands &&
                    model.getBoard().getLocationType(location) == LocationType.Highlands) {
                locations.add(location);
            }
        }
        return locations;
    }

    private List<JavaEdge> getEdgesTo(Location from, Location to, Map<Location, JavaNode> nodes) {
        // if we can traverse directly there
        DeveloperPlacementRule dpr = new DeveloperPlacementRule(to, model.getBoard(), model.getDevelopers());
        if(dpr.allowed()) {
            List<JavaEdge> edge = new ArrayList<JavaEdge>();
            edge.add(getEdgeBetween(from, to, nodes));
            return edge;
        }
        // if we can only pass through
        DeveloperPassThroughRule dptr = new DeveloperPassThroughRule(to, model.getBoard(),
                model.getJavaPlayers(), model.getCurrentJavaPlayer());
        if(dpr.allowed()) {
            return getEdgesStemmingFrom(to, nodes);
        }

        // we can't use this location at all
        return new ArrayList<JavaEdge>();
    }

    private List<JavaEdge> getEdgesStemmingFrom(Location to, Map<Location, JavaNode> nodes) {
        List<JavaEdge> edges = new ArrayList<JavaEdge>();
        for(Location neighbor : to.getNeighbors()) {
            edges.addAll(getEdgesTo(to, neighbor, nodes));
        }
        return edges;
    }

    private JavaEdge getEdgeBetween(Location from, Location to, Map<Location, JavaNode> nodes) {
        DeveloperTraversalRule dtr = new DeveloperTraversalRule(model.getBoard().getTopTileComponent(from),
                model.getBoard().getTopTileComponent(to));
        int cost = dtr.getCost();
        if(!nodes.containsKey(to)) {
            nodes.put(to, new JavaNode(to));
        }
        return new JavaEdge(nodes.get(from), nodes.get(to), cost);
    }
}
