/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graph;
import java.util.HashMap;
import objects.*;


/**
 *
 * @author Gautham
 */
public class LFunction {

    private HashMap<Node,FunctionElement> LFunction_Map;
    
    public LFunction(){
    	LFunction_Map=new HashMap<Node, FunctionElement>();
    }
        
    public HashMap<Node, FunctionElement> getLFunction_Map() {
        return LFunction_Map;
    }
}
