
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
public abstract class NetworkFlowSolver extends Network {

    public NetworkFlowSolver(List<Node> nodes, Node s, Node t) {
        super(nodes, s, t);
    }
    // Method to implement which solves the network flow problem.
    public abstract void solve();
    
}
