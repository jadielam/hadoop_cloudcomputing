package objects;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.List;

import org.apache.hadoop.io.ArrayWritable;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

public class Fact extends FunctionElement implements Writable {
	private Text predicate;
	private ArrayWritable constants=new ArrayWritable(Constant.class,null);
	
	public Fact()
	{
		
	}
	
	public Fact(String predicate, List<Constant> constants) {
		this.predicate = new Text(predicate);
		for(Constant c:constants)
		{
		constants.add(c);
		}
	}
	
	public Text getPredicate() {
		return predicate;
	}
	
	public ArrayWritable getConstants() {
		return constants;
	}
	
	public void write(DataOutput out) throws IOException{
        predicate.write(out);
        constants.write(out);
}

public void readFields(DataInput in) throws IOException {
        predicate.readFields(in);
        constants.readFields(in);
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
