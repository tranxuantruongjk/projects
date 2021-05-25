/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author xuantruong
 */
public class Node {
    private String name;
    private int visited;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node(String name) {
        this.name = name;
    }
    // 'visited' and 'visitedToken' are variables used in graph sub-routines to
    // track whether a node has been visited or not. In particular, node 'i' was
    // recently visited if visited[i] == visitedToken is true. This is handy
    // because to mark all nodes as unvisited simply increment the visitedToken.
    //protected int visitedToken = 1;
    
        // Marks node 'i' as visited.
    public void setVisited(int visited) {
        this.visited = visited;
    }

    // Returns true/false depending on whether node 'i' has been visited or not.
    public int getVisited() {
        return visited;
    }
}
