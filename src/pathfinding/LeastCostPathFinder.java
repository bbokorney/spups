package pathfinding;

import model.GameModel;
import model.board.BoardRuleHelper;
import model.board.Location;
import model.board.LocationType;
import model.player.Developer;
import model.rules.developer.DeveloperPassThroughRule;
import model.rules.developer.DeveloperPlacementRule;
import model.rules.developer.DeveloperTraversalRule;
import org.omg.PortableInterceptor.LOCATION_FORWARD;

import java.util.*;

/**
 * Created by Baker on 4/14/2014.
 */
public class LeastCostPathFinder {
    private GameModel model;
    private BoardRuleHelper helper;

    public LeastCostPathFinder(GameModel model) {
        this.model = model;
        this.helper = new BoardRuleHelper(model);
    }

    public JavaPath findShortestPath(Location src, Location dest, Developer developer) {
        System.out.println("Shortest path from "+src+" to "+ dest);
        if(src.equals(dest)) {
            System.out.println("Locations are equal.");
            List<JavaNode> nodes = new ArrayList<JavaNode>();
            nodes.add(new JavaNode(src));
            Path<JavaNode> path = new Path<JavaNode>(true, 0, nodes);
            return new JavaPath(path);
        }
        JavaNode destination = new JavaNode(dest);
        PathFinder<JavaNode, JavaEdge> pathFinder = new PathFinder<JavaNode, JavaEdge>();
        Set<Location> visited = new HashSet<Location>();
        Map<Location, JavaNode> nodes = new HashMap<Location, JavaNode>();
        nodes.put(dest, destination);
        Queue<JavaNode> queue = new LinkedList<JavaNode>();
        JavaNode source = new JavaNode(src);
        nodes.put(src, source);
        // start the BFS from the developer's starting location
        queue.add(source);
        while(!queue.isEmpty()) {

            JavaNode curr = queue.poll();
//            System.out.println("Queue size: " + queue.size());
//            System.out.println("Curr: " + curr.toString());
            // get all of the valid edges
            for(Location neighbor : curr.getLocation().getNeighbors()) {
//                System.out.println("Neighbor: " + neighbor.toString());
                if(!model.getBoard().areLocationsOnBoard(neighbor)) {
                    continue;
                }
                List<JavaEdge> edges = getEdgesTo(curr.getLocation(), neighbor, nodes, developer);
                for(JavaEdge edge : edges) {
                    if(edge != null) {
                        curr.addEdge(edge);
                        if(!visited.contains(edge.getDestination().getLocation())) {
                            queue.add(edge.getDestination());
                            visited.add(edge.getDestination().getLocation());
                        }
                    }
                }
            }
        }
        Path<JavaNode> path = pathFinder.findShortestPath(source, destination);
        return new JavaPath(path);
    }

    private int minCostToEnterOrExitHere(Location location) {
        if(helper.inHighLands(location)) {
            return 2;
        }
        else if(helper.inLowlands(location)) {
            return 1;
        }

        for(Location neighbor : location.getNeighbors()) {
            if(helper.inLowlands(neighbor)) {
                return 1;
            }
        }
        return 2;
    }

    public JavaPath findShortestPlacementPath(Location placementLocation) {
        JavaPath min = null;
        for(Location src : model.getBoard().getAllLocations()) {
            if(!helper.developerCanEnterHere(src)) {
                continue;
            }
            JavaPath path = findShortestPath(src, placementLocation, null);
            //System.out.println(path);
            // find the minimum cost to get to this
            int minCost = minCostToEnterOrExitHere(src);
            path.setCost(path.getCost() + minCost);
            if(min == null) {
                System.out.println("found a min path");
                System.out.println(path);
                min = path;
            }
            else {
                min = path.valid() && path.getCost() < min.getCost() ? path : min;
            }
        }
        //System.out.println("The result "+min);
        return min;
        //return findShortestEnterOrExitPath(placementLocation, null, false);
    }

    public JavaPath findShortestRemovalPath(Location removalLocation, Developer developer) {
        JavaPath min = null;
        for(Location src : model.getBoard().getAllLocations()) {
            if(!helper.developerCanBeRemovedFromHere(src, developer)) {
                continue;
            }
            JavaPath path = findShortestPath(removalLocation, src, developer);
            //System.out.println(path);
            // find the minimum cost to get to this
            int minCost = minCostToEnterOrExitHere(src);
            path.setCost(path.getCost() + minCost);
            if(min == null) {
                System.out.println("found a min path");
                System.out.println(path);
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
        for(Location location : model.getBoard().getAllLocations()) {
            if(model.getBoard().getLocationType(location) == LocationType.Lowlands ||
                    model.getBoard().getLocationType(location) == LocationType.Highlands) {
                locations.add(location);
            }
        }
        return locations;
    }

    private List<JavaEdge> getEdgesTo(Location from, Location to, Map<Location, JavaNode> nodes, Developer developer) {
        // if we can traverse directly there
        DeveloperPlacementRule dpr = new DeveloperPlacementRule(to, model.getBoard(), model.getDevelopersFromAllPlayers(), developer);
        if(dpr.allowed()) {
            List<JavaEdge> edge = new ArrayList<JavaEdge>();
            edge.add(getEdgeBetween(from, to, nodes));
            return edge;
        }
        // if we can only pass through
        DeveloperPassThroughRule dptr = new DeveloperPassThroughRule(to, model.getBoard(),
                model.getJavaPlayers(), model.getCurrentJavaPlayer());
        if(dptr.allowed()) {
            return getEdgesStemmingFrom(to, nodes, developer);
        }

        // we can't use this location at all
        return new ArrayList<JavaEdge>();
    }

    private List<JavaEdge> getEdgesStemmingFrom(Location to, Map<Location, JavaNode> nodes, Developer developer) {
        List<JavaEdge> edges = new ArrayList<JavaEdge>();
        for(Location neighbor : to.getNeighbors()) {
            edges.addAll(getEdgesTo(to, neighbor, nodes, developer));
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
