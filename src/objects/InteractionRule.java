package objects;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
public class InteractionRule implements Writable,FunctionElement {
	
	private Text text;
	
	public InteractionRule(String text) {
		this.text = new Text(text);
	}
	public Text getText() {
		return text;
	}
	public void write(DataOutput out) throws IOException{
        text.write(out);
       
}

public void readFields(DataInput in) throws IOException {
       text.readFields(in);
        
}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
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
		InteractionRule other = (InteractionRule) obj;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

}
