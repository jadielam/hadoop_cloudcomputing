package objects;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.List;

import org.apache.hadoop.io.ArrayWritable;
import org.apache.hadoop.io.Writable;

public class Conjunct implements Writable{
	
	
	private ArrayWritable facts=new ArrayWritable(Fact.class,null);

	public Conjunct(List<Fact> facts) {
		super();
		for(Fact f:facts)
		{
			facts.add(f);
		}
	}

	public ArrayWritable getFacts() {
		return facts;
	}
	
	public void write(DataOutput out) throws IOException{
        facts.write(out);
       
}

public void readFields(DataInput in) throws IOException {
       facts.readFields(in);
        
}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((facts == null) ? 0 : facts.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conjunct other = (Conjunct) obj;
		if (facts == null) {
			if (other.facts != null)
				return false;
		} else if (!facts.equals(other.facts))
			return false;
		return true;
	}

}
