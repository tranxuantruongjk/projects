
import static java.lang.Math.min;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author xuantruong
 */
public class FordFulkersonSolver extends NetworkFlowSolver {
    /**
     * Creates an instance of a flow network solver.Use the {@link #addEdge} method to add edges to
 the graph.
     *
     * @param nodes
     * @param s - The index of the source node, 0 <= s < n
     * @param t - The index of the sink node, 0 <= t < n and t != s
     */
    public FordFulkersonSolver(List<Node> nodes, Node s, Node t) {
        super(nodes, s, t);
    }
    protected int visitedToken = 1;
    // Performs the Ford-Fulkerson method applying a depth first search as
    // a means of finding an augmenting path.
    @Override
    public void solve() {
        // Find max flow by adding all augmenting path flows.
        for (long f = dfs(getS(), INF); f != 0; f = dfs(getS(), INF)) {
            visitedToken++;
            //System.out.println("visitedToken = " + visitedToken);
            setMaxFlow(f); // maxFlow += flow;
            //for (List<Edge> edges : graph) for (Edge e : edges) System.out.println(e.toString(s, t));
            //System.out.println("=))");
        }
    }
    
    public long dfs(Node node, long flow) {
        // At sink node, return augmented path flow.
        if (node.equals(getT())) return flow;

        // Mark the current node as visited.
        node.setVisited(visitedToken);
        
        //List<Edge> edges = getGraph()[node];
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < this.getEdges().size(); i++) {
            Edge edge = this.getEdges().get(i);
            if (node.equals(edge.getFrom())) {
                edges.add(edge);
            }
        }
        for (Edge edge : edges) {
            if (edge.remainingCapacity() > 0 && edge.getTo().getVisited() != visitedToken) {
                long bottleNeck = dfs(edge.getTo(), min(flow, edge.remainingCapacity()));

                // If we made it from s -> t (a.k.a bottleNeck > 0) then
                // augment flow with bottleneck value.
                if (bottleNeck > 0) {
                edge.augment(bottleNeck);
                return bottleNeck;
                }
            }
        }
        return 0;
    }
}
