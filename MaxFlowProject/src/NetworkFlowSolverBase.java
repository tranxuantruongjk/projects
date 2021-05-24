
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
public abstract class NetworkFlowSolverBase {
    // Inputs: n = number of nodes, s = source, t = sink
    private int n;
    private int s;
    private int t;
    // The adjacency list representing the flow graph.
    private final List<Edge>[] graph;
    private final ArrayList<Edge>[] edgeList;
    // The maximum flow. Calculated by calling the {@link #solve} method.
    private long maxFlow;
    // 'visited' and 'visitedToken' are variables used in graph sub-routines to
    // track whether a node has been visited or not. In particular, node 'i' was
    // recently visited if visited[i] == visitedToken is true. This is handy
    // because to mark all nodes as unvisited simply increment the visitedToken.
    protected int visitedToken = 1;
    protected int[] visited;
    // To avoid overflow, set infinity to a value less than Long.MAX_VALUE;
    static final long INF = Long.MAX_VALUE / 2;
    /**
     * Creates an instance of a flow network solver. Use the {@link #addEdge} method to add edges to
     * the graph.
     *
     * @param n - The number of nodes in the graph including s and t.
     * @param s - The index of the source node, 0 <= s < n
     * @param t - The index of the sink node, 0 <= t < n and t != s
     */
    public NetworkFlowSolverBase(int n, int s, int t) {
        this.n = n;
        this.s = s;
        this.t = t;
        this.maxFlow = 0;
        graph = new List[n];
        edgeList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            edgeList[i] = new ArrayList<>();
        }
        System.arraycopy(edgeList, 0, graph, 0, n);
        visited = new int[n];
    }

    // Constructs an empty graph with n nodes including s and t

    /**
     * Adds a directed edge (and its residual edge) to the flow graph.
     *
     * @param from - The index of the node the directed edge starts at.
     * @param to - The index of the node the directed edge ends at.
     * @param capacity - The capacity of the edge
     */
    public void addEdge(int from, int to, long capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Forward edge capacity <= 0");
        Edge e1 = new Edge(from, to, capacity);
        Edge e2 = new Edge(to, from, 0);
        e1.setResidual(e2);
        e2.setResidual(e1);
        graph[from].add(e1);
        graph[to].add(e2);
    }

    public void setMaxFlow(long flow) {
        this.maxFlow += flow;
    }
    
    
    /**
     * Returns the residual graph after the solver has been executed.This allows you to inspect the
    {@link Edge#flow} and {@link Edge#capacity} values of each edge. This is useful if you are
 debugging or want to figure out which edges were used during the max flow.
     * @return 
     */
    public List<Edge>[] getGraph() {
        return graph;
    }

    public int getN() {
        return n;
    }

    public int getS() {
        return s;
    }

    public int getT() {
        return t;
    }
    
    // Returns the maximum flow from the source to the sink.
    public long getMaxFlow() {
        return maxFlow;
    }
    
    // Marks node 'i' as visited.
    public void visit(int i) {
        visited[i] = visitedToken;
    }

    // Returns true/false depending on whether node 'i' has been visited or not.
    public boolean visited(int i) {
        return visited[i] == visitedToken;
    }

    // Method to implement which solves the network flow problem.
    public abstract void solve();
    
}
