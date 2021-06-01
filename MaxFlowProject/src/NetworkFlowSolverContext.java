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
    public static NetworkFlowSolver solver;
    public static Display display;
    public NetworkFlowSolverContext() {
        
    }
    public NetworkFlowSolverContext(NetworkFlowSolver solver, Display display) {
        this.solver = solver;
        this.display = display;
    }

    public static NetworkFlowSolver getSolver() {
        return solver;
    }

    public static void setSolver(NetworkFlowSolver solver) {
        NetworkFlowSolverContext.solver = solver;
    }

    public static Display getDisplay() {
        return display;
    }

    public static void setDisplay(Display display) {
        NetworkFlowSolverContext.display = display;
    }
    
}
