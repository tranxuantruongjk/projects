
import static java.lang.Math.min;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
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
public class EdmondsKarpSolver extends NetworkFlowSolver {

    public EdmondsKarpSolver() {
    }
    
    /**
     * Creates an instance of a flow network solver.Use the {@link #addEdge(int, int, int)} method
 to add edges to the graph.
     *
     * @param network
     */
    public EdmondsKarpSolver(Network network) {
        super(network);
    }
    protected int visitedToken = 0;

    // Run Edmonds-Karp and compute the max flow from the source to the sink node.
    @Override
    public void solve() {
        long flow;
        do {
//            for (int i = 0; i < getResult().size(); i++) {
//                System.out.println(getResult().get(i).toString());
//            }
//            System.out.println("1");
            //getResult().clear();
            visitedToken++;
          
            flow = bfs();
            getNetwork().setMaxFlow(flow); // maxFlow += flow
        } while (flow != 0);
    }
    
    public long bfs() {
        
        // Initialize BFS queue and add starting source node.
        int n = getNetwork().getN();
        Queue<Node> q = new ArrayDeque<>(n);
        Node s = getNetwork().getS();
        Node t = getNetwork().getT();
        s.setVisited(visitedToken);
        q.offer(s);
        // Perform BFS from source to sink
        List<Edge> prev = new ArrayList<>();
        
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.equals(t)) break;
            
            List<Edge> edges = new ArrayList<>();
            for (int i = 0; i < this.getNetwork().getEdges().size(); i++) {
                Edge edge = this.getNetwork().getEdges().get(i);
                if (node.equals(edge.getFrom())) {
                    edges.add(edge);
                }
            }
                       
            edges.forEach(edge -> {
                long cap = edge.remainingCapacity();
                if (cap > 0 && edge.getTo().getVisited() != visitedToken) {
                    edge.getTo().setVisited(visitedToken);
                    prev.add(edge);
                    q.offer(edge.getTo());
                }
            });
        }

        // Sink not reachable!
        int index = 0;
        int reach = 0;

        for (int i = 0; i < prev.size(); i++) {
            if (prev.get(i).getTo().equals(t)) {
                reach = 1;
                index = i;
                break;
            }
        }
        if (reach == 0) return 0;
        
        long bottleNeck = Long.MAX_VALUE;
        int next = Integer.MAX_VALUE;

        for (Edge edge = prev.get(index); edge != null ; edge = prev.get(next)) {
            bottleNeck = min(bottleNeck, edge.remainingCapacity());
            getResult().add(edge);
            if (edge.getFrom().equals(s)) {
                break;
            }        
            Node node = edge.getFrom(); 
            for (int i = prev.size()-1; i >= 0; i--) {
                if (node.equals(prev.get(i).getTo())) {
                    next = i;
                    break;
                }
            }
        }
        
        next = Integer.MAX_VALUE;
        for (Edge edge = prev.get(index); edge != null ; edge = prev.get(next)) {
            edge.augment(bottleNeck);          
            if (edge.getFrom().equals(s)) {
                break;
            }
            Node node = edge.getFrom();
            for (int i = prev.size() - 1; i >= 0; i--) {
                if (node.equals(prev.get(i).getTo())) {
                    next = i;
                    break;
                }
            }
        }
        return bottleNeck;

    }   
}
