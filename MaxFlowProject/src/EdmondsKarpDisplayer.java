/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author xuantruong
 */
public class EdmondsKarpDisplayer extends Displayer {

    public EdmondsKarpDisplayer() {
        NetworkFlowSolver solver = new EdmondsKarpSolver();
        setSolver(solver);
    }

    @Override
    public void run() {
        getSolver().solve();
    }

    @Override
    public void step() {
        getSolver().solve();
        setResults(getSolver().getResult());
    }
    
}
