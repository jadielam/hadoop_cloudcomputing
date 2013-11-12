/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Graph;
import java.util.HashMap;
import objects.*;


/**
 *
 * @author Gautham
 */
public class LFunction {

    private HashMap<Node,FunctionElement> LFunction_Map;
    
    public LFunction(HashMap<Node, FunctionElement> LFunction_Map) {
        this.LFunction_Map = LFunction_Map;
    }
    

    
    public HashMap<Node, FunctionElement> getLFunction_Map() {
        return LFunction_Map;
    }
}
