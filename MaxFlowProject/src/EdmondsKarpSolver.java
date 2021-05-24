
import static java.lang.Math.min;
import java.util.ArrayDeque;
import java.util.Queue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author xuantruong
 */
public class EdmondsKarpSolver extends NetworkFlowSolverBase {
    /**
     * Creates an instance of a flow network solver. Use the {@link #addEdge(int, int, int)} method
     * to add edges to the graph.
     *
     * @param n - The number of nodes in the graph including source and sink nodes.
     * @param s - The index of the source node, 0 <= s < n
     * @param t - The index of the sink node, 0 <= t < n, t != s
     */
    public EdmondsKarpSolver(int n, int s, int t) {
        super(n, s, t);
    }

    // Run Edmonds-Karp and compute the max flow from the source to the sink node.
    @Override
    public void solve() {
        long flow;
        do {
            visitedToken++;
            flow = bfs();
            setMaxFlow(flow); // maxFlow += flow
        } while (flow != 0);
    }
    
    public long bfs() {
        
        // Initialize BFS queue and add starting source node.
        Queue<Integer> q = new ArrayDeque<>(getN());
        visit(getS());
        q.offer(getS());

        // Perform BFS from source to sink
        Edge[] prev = new Edge[getN()];
        while (!q.isEmpty()) {
            int node = q.poll();
            if (node == getT()) break;

            for (Edge edge : getGraph()[node]) {
                long cap = edge.remainingCapacity();
                if (cap > 0 && !visited(edge.getTo())) {
                    visit(edge.getTo());
                    prev[edge.getTo()] = edge;
                    q.offer(edge.getTo());
                }
            }
        }

        // Sink not reachable!
        if (prev[getT()] == null) return 0;

        // Find augmented path and bottle neck
        long bottleNeck = Long.MAX_VALUE;
        for (Edge edge = prev[getT()]; edge != null; edge = prev[edge.getFrom()])
            bottleNeck = min(bottleNeck, edge.remainingCapacity());

        // Retrace augmented path and update flow values.
        for (Edge edge = prev[getT()]; edge != null; edge = prev[edge.getFrom()]) edge.augment(bottleNeck);

        // Return bottleneck flow
        return bottleNeck;
    }   
}
