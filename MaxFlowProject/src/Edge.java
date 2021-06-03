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
    private Node from;
    private Node to;
    private Edge residual;
    private long flow;
    private final long capacity;

    public Node getFrom() {
        return from;
    }

    public void setFrom(Node from) {
        this.from = from;
    }

    public Node getTo() {
        return to;
    }

    public void setTo(Node to) {
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
    
    public Edge(Node from, Node to, long capacity) {
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

    @Override
    public String toString() {
        String u = from.getName();
        String v = to.getName();
//        String u = String.valueOf(from);
//        String v = String.valueOf(to);
        return String.format(
            "Edge %s -> %s | flow = %3d | capacity = %3d | is residual: %s | visited: %3d %3d",
            u, v, flow, capacity, isResidual(), from.getVisited(), to.getVisited());
    }
}
