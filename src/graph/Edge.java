/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author Gautham
 */
public class Edge {
    
    
   private Node source;
private Node destination;
@Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.source);
        hash = 43 * hash + Objects.hashCode(this.destination);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Edge other = (Edge) obj;
        if (!Objects.equals(this.source, other.source)) {
            return false;
        }
        if (!Objects.equals(this.destination, other.destination)) {
            return false;
        }
        return true;
    }

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
    
    public Edge(Node src, Node dest){
    
    source=src;
    destination=dest;
    
    }
    
}
