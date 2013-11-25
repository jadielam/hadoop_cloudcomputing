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
   
	 	
	MapWritable Nr=new MapWritable();
    MapWritable Np=new MapWritable();
    MapWritable Nd=new MapWritable();
    MapWritable E=new MapWritable();
    LFunction Lf=new LFunction();
    Goal G=new Goal();

    public AttackGraph(){
    	this.Nr=new MapWritable();
    	this.Np=new MapWritable();
    	this.Nd=new MapWritable();
    	this.E=new MapWritable();
    	this.Lf=new LFunction();
    	this.G=new Goal();
    	
    }
    
    public AttackGraph(MapWritable Nr, MapWritable Np, MapWritable Nd, MapWritable E, LFunction Lf, Goal G){
    	this.Nr=Nr;
    	this.Np=Np;
    	this.Nd=Nd;
    	this.E=E;
    	this.Lf=Lf;
    	this.G=G;
    }
    
    public AttackGraph(HashSet<DerivationNode> Nr, HashSet<PrimitiveNode> Np, HashSet<DerivedNode> Nd, HashSet<Edge> E, LFunction Lf, Goal G) {
        
    	this.Nr=new MapWritable();
    	this.Np=new MapWritable();
    	this.Nd=new MapWritable();
    	this.E=new MapWritable();
    	
    	initialize(this.Nr, Nr);
    	initialize(this.Np, Np);
        initialize(this.Nd, Nd);
        initialize(this.E, E);
        
        this.Lf = Lf;
        this.G = new Goal();
        
        
    }
    
    private void initialize(MapWritable map, HashSet<? extends Writable> set){
    	
    	
    	for (Writable a : set){
    		map.put(a, new IntWritable(1));
    	}
    }

    public MapWritable getNr() {
        return Nr;
    }

    public MapWritable getNp() {
        return Np;
    }

    public MapWritable getNd() {
        return Nd;
    }

    public MapWritable getE() {
        return E;
    }

    public LFunction getLf() {
        return Lf;
    }

    public Goal getG() {
        return G;
    }

	@Override
	public void readFields(DataInput in) throws IOException {
		Nr.readFields(in);
		Np.readFields(in);
		Nd.readFields(in);
		E.readFields(in);
		Lf.readFields(in);
		G.readFields(in);
	}

	@Override
	public void write(DataOutput out) throws IOException {
		Nr.write(out);
		Np.write(out);
		Nd.write(out);
		E.write(out);
		Lf.write(out);
		G.write(out);
	}
    

}
