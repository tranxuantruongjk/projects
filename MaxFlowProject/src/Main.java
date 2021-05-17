
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
public class Main {
    public static void main(String[] args) {
        // n is the number of nodes including the source and the sink.
        //int n = 12;
        int n = 11;
    
        int s = n - 2;
        int t = n - 1;
        System.out.println("s = " + s + " t = " + t);
        NetworkFlowSolverBase solver = new FordFulkersonSolver(n, s, t);

        // Edges from source
        solver.addEdge(s, 0, 10);
        //solver.addEdge(0, 1, 10);
        solver.addEdge(s, 1, 5);
        //solver.addEdge(0, 2, 5);
        solver.addEdge(s, 2, 10);
        //solver.addEdge(0, 3, 10);

        // Middle edges
        solver.addEdge(0, 3, 10);
        //solver.addEdge(1, 4, 10);
        solver.addEdge(1, 2, 10);
        //solver.addEdge(2, 3, 10);
        solver.addEdge(2, 5, 15);
        //solver.addEdge(3, 6, 15);
        solver.addEdge(3, 1, 2);
        //solver.addEdge(4, 2, 2);
        solver.addEdge(3, 6, 15);
        //solver.addEdge(4, 7, 15);
        solver.addEdge(4, 1, 15);
        //solver.addEdge(5, 2, 15);
        solver.addEdge(4, 3, 3);
        //solver.addEdge(5, 4, 3);
        solver.addEdge(5, 4, 4);
        //solver.addEdge(6, 5, 4);
        solver.addEdge(5, 8, 10);
        //solver.addEdge(6, 9, 10);
        solver.addEdge(6, 7, 10);
        //solver.addEdge(7, 8, 10);
        solver.addEdge(7, 4, 10);
        //solver.addEdge(8, 5, 10);
        solver.addEdge(7, 5, 7);
        //solver.addEdge(8, 6, 7);

        // Edges to sink
        solver.addEdge(6, t, 15);
        //solver.addEdge(7, 10, 15);
        solver.addEdge(8, t, 10);
        //solver.addEdge(9, 10, 10);

        // Prints:
        // Maximum Flow is: 23
        //for (List<Edge> edges : solver.graph) for (Edge e : edges) System.out.println(e.toString(s, t));
        System.out.printf("Maximum Flow is: %d\n", solver.getMaxFlow());

        List<Edge>[] resultGraph = solver.getGraph();

        // Displays all edges part of the resulting residual graph.
        for (List<Edge> edges : resultGraph) 
            edges.forEach(e -> {
                System.out.println(e.toString(s, t));
            });
    }
}
