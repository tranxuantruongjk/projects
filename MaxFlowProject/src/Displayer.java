
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
public abstract class Displayer {
    private int count;
    private NetworkFlowSolver solver;
    private List<Edge> results = new ArrayList<>();

    public Displayer() {
    }
    
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public NetworkFlowSolver getSolver() {
        return solver;
    }

    public void setSolver(NetworkFlowSolver solver) {
        this.solver = solver;
    }

    public List<Edge> getResults() {
        return results;
    }

    public void setResults(List<Edge> results) {
        this.results = results;
    }
    
    public abstract void run();
    public abstract void step();
    
}
