package objects;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.hadoop.io.ArrayWritable;
import org.apache.hadoop.io.Writable;

public class Conjunct {
	
	public String toString(){
		StringBuilder sb=new StringBuilder();
		sb.append("(");
		for(int i=0;i<facts.size()-1;i++)
		{
			sb.append(facts.get(i).toString()).append(", ");
		}
		sb.append(facts.get(facts.size()-1));
		
		sb.append(")");
		
		return sb.toString();
	}
	
	private List<Fact> facts=new LinkedList<Fact>();
	
	public Conjunct(){
		this.facts=new LinkedList<Fact>();
	}
	
	public Conjunct(List<Fact> facts) {
		
		
		this.facts=facts;
	}

	public List<Fact> getFacts() {
		return facts;
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
