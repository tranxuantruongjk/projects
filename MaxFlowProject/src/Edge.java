/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author xuantruong
 */
public class Edge {
    private int from, to;
    private Edge residual;
    private long flow;
    private final long capacity;

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public Edge getResidual() {
        return residual;
    }

    public void setResidual(Edge residual) {
        this.residual = residual;
    }

    public long getFlow() {
        return flow;
    }

    public void setFlow(long flow) {
        this.flow = flow;
    }
    
    public Edge(int from, int to, long capacity) {
        this.from = from;
        this.to = to;
        this.capacity = capacity;
    }

    public boolean isResidual() {
        return capacity == 0;
    }

    public long remainingCapacity() {
        return capacity - flow;
    }

    public void augment(long bottleNeck) {
        flow += bottleNeck;
        residual.flow -= bottleNeck;
    }

    public String toString(int s, int t) {
        String u = (from == s) ? "s" : ((from == t) ? "t" : String.valueOf(from));
        String v = (to == s) ? "s" : ((to == t) ? "t" : String.valueOf(to));
//        String u = String.valueOf(from);
//        String v = String.valueOf(to);
        return String.format(
            "Edge %s -> %s | flow = %3d | capacity = %3d | is residual: %s",
            u, v, flow, capacity, isResidual());
    }
}
