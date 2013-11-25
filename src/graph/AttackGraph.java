/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.HashSet;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.IntWritable;
/**
 *
 * @author Gautham
 */
public class AttackGraph implements Writable {
   
	 
	
	MapWritable Nr;
    MapWritable Np;
    MapWritable Nd;
    MapWritable E;
    LFunction Lf;
    Goal G;

    public AttackGraph(){
    	this.Nr=new MapWritable();
    	this.Np=new MapWritable();
    	this.Nd=new MapWritable();
    	this.E=new MapWritable();
    	this.Lf=new LFunction();
    	this.G=new Goal();
    	
    }
    public AttackGraph(HashSet<DerivationNode> Nr, HashSet<PrimitiveNode> Np, HashSet<DerivedNode> Nd, HashSet<Edge> E, LFunction Lf, Goal G) {
        
    	initialize(this.Nr, Nr);
    	initialize(this.Np, Np);
        initialize(this.Nd, Nd);
        initialize(this.E, E);
        
        this.Lf = Lf;
        this.G = G;
        
        
    }
    
    private void initialize(MapWritable map, HashSet<? extends Writable> set){
    	for (Writable a : set){
    		map.put(a, new IntWritable(1));
    	}
    }

    public HashSet<DerivationNode> getNr() {
        return Nr;
    }

    public HashSet<PrimitiveNode> getNp() {
        return Np;
    }

    public HashSet<DerivedNode> getNd() {
        return Nd;
    }

    public HashSet<Edge> getE() {
        return E;
    }

    public LFunction getLf() {
        return Lf;
    }

    public Goal getG() {
        return G;
    }

	@Override
	public void readFields(DataInput arg0) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write(DataOutput arg0) throws IOException {
		// TODO Auto-generated method stub
		
	}
    

}
