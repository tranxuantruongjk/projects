
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
     * @param network
     */
    public FordFulkersonSolver(Network network) {
        super(network);
    }
    protected int visitedToken = 1;
    long INF = Long.MAX_VALUE;
    // Performs the Ford-Fulkerson method applying a depth first search as
    // a means of finding an augmenting path.
    @Override
    public void solve() {
        Node s = getNetwork().getS();
        // Find max flow by adding all augmenting path flows.
        for (long f = dfs(s, INF); f != 0; f = dfs(s, INF)) {
            visitedToken++;
            getNetwork().setMaxFlow(f); // maxFlow += flow;
        }
    }
    
    public long dfs(Node node, long flow) {
        // At sink node, return augmented path flow.
        if (node.equals(getNetwork().getT())) return flow;

        // Mark the current node as visited.
        node.setVisited(visitedToken);
       
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < getNetwork().getEdges().size(); i++) {
            Edge edge = getNetwork().getEdges().get(i);
            if (node.equals(edge.getFrom())) {
                edges.add(edge);
            }
        }
        for (Edge edge : edges) {
            if (edge.remainingCapacity() > 0 && edge.getTo().getVisited() != visitedToken) {
                long bottleNeck = dfs(edge.getTo(), min(flow, edge.remainingCapacity()));
                if (bottleNeck > 0) {
                    getResult().add(edge);
                    edge.augment(bottleNeck);
                    return bottleNeck;
                }
            }
        }
        return 0;
    }
}
