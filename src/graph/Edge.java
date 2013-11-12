/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

/**
 *
 * @author Gautham
 */
public class Edge {
    
    
   private Node source;

    public Node getSource() {
        return source;
    }

    public void setSource(Node source) {
        this.source = source;
    }

    public Node getDestination() {
        return destination;
    }

    public void setDestination(Node destination) {
        this.destination = destination;
    }
    private Node destination;
    public Edge(Node src, Node dest){
    
    source=src;
    destination=dest;
    
    }
    
}
