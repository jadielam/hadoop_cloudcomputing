package objects;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.Text;

public abstract class FunctionElement implements Writable {

	public abstract Text getText();
}
