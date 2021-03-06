
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
public class Main {
    
    public static void main(String[] args) {
        // n is the number of nodes including the source and the sink.
        //int n = 11;
        int n = 6;
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Node node = new Node(String.valueOf(i));
            node.setVisited(0);
            nodes.add(node);
        }
        Network network = new Network(nodes, nodes.get(0), nodes.get(n - 1));
        //Node s = nodes.get(0);
        //Node t = nodes.get(n-1);
        //System.out.println("s = " + s.getName() + " t = " + t.getName());

        //Edges from source
//        solver.addEdge(s, 0, 10); 
//        solver.addEdge(s, 1, 5);
//        solver.addEdge(s, 2, 10);
//        // Middle edges
//        solver.addEdge(0, 3, 10);
//        solver.addEdge(1, 2, 10);
//        solver.addEdge(2, 5, 15);
//        solver.addEdge(3, 1, 2);
//        solver.addEdge(3, 6, 15);
//        solver.addEdge(4, 1, 15);
//        solver.addEdge(4, 3, 3);
//        solver.addEdge(5, 4, 4);
//        solver.addEdge(5, 8, 10);        
//        solver.addEdge(6, 7, 10);
//        solver.addEdge(7, 4, 10);
//        solver.addEdge(7, 5, 7);     
//        // Edges to sink
//        solver.addEdge(6, t, 15);
//        solver.addEdge(8, t, 10);
//        solver.addEdge(0, 1, 10);
//        solver.addEdge(0, 2, 5);
//        solver.addEdge(0, 3, 10);
//        solver.addEdge(1, 4, 10);
//        solver.addEdge(2, 3, 10);
//        solver.addEdge(3, 6, 15);
//        solver.addEdge(4, 2, 2);
//        solver.addEdge(4, 7, 15);
//        solver.addEdge(5, 2, 15);
//        solver.addEdge(5, 4, 3);
//        solver.addEdge(6, 5, 4);
//        solver.addEdge(6, 9, 10);
//        solver.addEdge(7, 8, 10);
//        solver.addEdge(8, 5, 10);
//        solver.addEdge(8, 6, 7);
//        solver.addEdge(7, 10, 15);
//        solver.addEdge(9, 10, 10);
//        
//        solver.addEdge(nodes.get(0), nodes.get(1), 10);
//        solver.addEdge(nodes.get(0), nodes.get(2), 5);
//        solver.addEdge(nodes.get(0), nodes.get(3), 10);
//        solver.addEdge(nodes.get(1), nodes.get(4), 10);
//        solver.addEdge(nodes.get(2), nodes.get(3), 10);
//        solver.addEdge(nodes.get(3), nodes.get(6), 15);
//        solver.addEdge(nodes.get(4), nodes.get(2), 2);
//        solver.addEdge(nodes.get(4), nodes.get(7), 15);
//        solver.addEdge(nodes.get(5), nodes.get(2), 15);
//        solver.addEdge(nodes.get(5), nodes.get(4), 3);
//        solver.addEdge(nodes.get(6), nodes.get(5), 4);
//        solver.addEdge(nodes.get(6), nodes.get(9), 10);
//        solver.addEdge(nodes.get(7), nodes.get(8), 10);
//        solver.addEdge(nodes.get(8), nodes.get(5), 10);
//        solver.addEdge(nodes.get(8), nodes.get(6), 7);
//        solver.addEdge(nodes.get(7), nodes.get(10), 15);
//        solver.addEdge(nodes.get(9), nodes.get(10), 10);
        network.addEdge(nodes.get(0), nodes.get(1), 5);
        network.addEdge(nodes.get(1), nodes.get(2), 10);
        network.addEdge(nodes.get(0), nodes.get(3), 15);
        network.addEdge(nodes.get(3), nodes.get(4), 5);
        network.addEdge(nodes.get(4), nodes.get(5), 5);
        network.addEdge(nodes.get(3), nodes.get(1), 5);
        network.addEdge(nodes.get(4), nodes.get(2), 2);
        network.addEdge(nodes.get(1), nodes.get(4), 5);
        network.addEdge(nodes.get(2), nodes.get(3), 3);
        network.addEdge(nodes.get(2), nodes.get(5), 20);
        //NetworkFlowSolver solver = new FordFulkersonSolver(network);
        //NetworkFlowSolver solver = new EdmondsKarpSolver(network);

        //solver.solve();
        NetworkFlowSolverContext context = new NetworkFlowSolverContext();
        context.setNetwork(network);
        context.setDisplayer(new EdmondsKarpDisplayer());
        context.runStep();
        System.out.printf("Maximum Flow is: %d\n", network.getMaxFlow());
        for (int i = 0; i < context.getDisplayer().getResults().size(); i++) {
            System.out.println(context.getDisplayer().getResults().get(i).toString());
        }
//        List<Edge>[] result = solver.getEachWay();
//        for (int i = 0; i < result.length; i++) {
//            for (int j = 0; j < result[i].size(); j++) {
//                System.out.println(result[i].get(j));
//            }
//            System.out.println("1");
//        }
        
//        for (int i = 0; i < network.getEdges().size(); i++) {
//            System.out.println(network.getEdges().get(i).toString());
//        }
        
    }
}
