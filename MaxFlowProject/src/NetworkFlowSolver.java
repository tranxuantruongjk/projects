
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
public abstract class NetworkFlowSolver {
    private Network network;
    private List<Edge> result = new ArrayList<>();

    public NetworkFlowSolver() {
    }

    public NetworkFlowSolver(Network network) {  
        this.network = network;
    }

    public Network getNetwork() {
        return network;
    }

    public List<Edge> getResult() {
        return result;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }
    
    public List<Edge>[] getEachWay() {
        
        int count = 0;
        int size = result.size();
        ArrayList<String> indexs = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (result.get(i).getTo().equals(network.getT())) {
                indexs.add(String.valueOf(i));
                count++;
            }
        }
        List<Edge>[] eachWay = new List[count];
        for (int i = 0; i < count; i++) {
            eachWay[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < count; i++) {
            int index1 = Integer.parseInt(indexs.get(i));
            if (i == count - 1) {
                for (int j = index1; j < result.size(); j++) {
                    eachWay[i].add(result.get(j));
                }
                break;
            }
            int index2 = Integer.parseInt(indexs.get(i+1));
            for (int j = index1; j < index2; j++) {
                eachWay[i].add(result.get(j));
            }
        }
        return eachWay;
        
    }
    // Method to implement which solves the network flow problem.
    public abstract void solve();
    
}
