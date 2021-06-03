/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author xuantruong
 */
public class NetworkFlowSolverContext {
    public Network network;
    public Displayer displayer;
    public NetworkFlowSolverContext() {  
    }
    
    public NetworkFlowSolverContext(Network network, Displayer displayer) {
        this.network = network;
        this.displayer = displayer;
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public Displayer getDisplayer() {
        return displayer;
    }

    public void setDisplayer(Displayer displayer) {
        this.displayer = displayer;
        this.displayer.getSolver().setNetwork(network);
    }
    
    
    public void runAuto() {
        displayer.run();
    }
    
    public void runStep() {
        displayer.step();
    }
    
}
