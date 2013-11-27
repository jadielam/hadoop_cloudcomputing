package objects;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.hadoop.io.ArrayWritable;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

public class Fact extends FunctionElement implements Writable {
	
	private Text predicate;
	private List<Constant> constants=new LinkedList<Constant>();

	public String toString(){
		StringBuilder sb=new StringBuilder("");
		sb.append(predicate.toString());
		sb.append("(");
		for(int i=0;i<constants.size()-1;i++)
		{
			sb.append(constants.get(i).toString()).append(", ");
		}
		sb.append(constants.get(constants.size()-1));
		sb.append(")");
		return sb.toString();
	}
	
	public Text getText(){
		return predicate;
	}
	
	
	public Fact()
	{
		this.predicate=new Text("");
		this.constants=new LinkedList<Constant>();
	}
	
	
	public Fact(String predicate, List<Constant> constants) {
		this.predicate = new Text(predicate);
		this.constants=constants;
		
	}
	
	public Text getPredicate() {
		return predicate;
	}
	
	public List<Constant> getConstants() {
		return constants;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((constants == null) ? 0 : constants.hashCode());
		result = prime * result
				+ ((predicate == null) ? 0 : predicate.hashCode());
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
		Fact other = (Fact) obj;
		if (constants == null) {
			if (other.constants != null)
				return false;
		} else if (!constants.equals(other.constants))
			return false;
		if (predicate == null) {
			if (other.predicate != null)
				return false;
		} else if (!predicate.equals(other.predicate))
			return false;
		return true;
	}	

}
