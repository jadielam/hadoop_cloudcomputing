/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.Objects;

/**
 *
 * @author Gautham
 */
public abstract class Node {
	
    private int id;
    private String name;
   
    public Node(int cur_id, String cur_name) {
        id = cur_id;
        name = cur_name;
    }
    
    public Node(int cur_id){
    	id=cur_id;
    	name="";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.id;
        hash = 23 * hash + Objects.hashCode(this.name);
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
        final Node other = (Node) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
 

    public int getID() {
        int cur_id = this.id;
        return cur_id;
    }

    public String getName() {
        String cur_name = this.name;
        
        return cur_name;
        
    }
    
    public int ComparesTo(Node nodeobj){
    int result=this.ComparesTo(nodeobj);
    return result;
    }
}

