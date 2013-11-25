package objects;

import java.io.Serializable;
import java.util.List;

public class Fact implements Serializable, FunctionElement {
	
	private static final long serialVersionUID= 7526472295622776152L;
	private String predicate;
	private List<Constant> constants;
	
	public Fact(String predicate, List<Constant> constants) {
		this.predicate = predicate;
		this.constants = constants;
	}
	
	public String getPredicate() {
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

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		StringBuilder sb=new StringBuilder();
		sb.append(predicate).append("(");
		
		int counter=0;
		for (Constant c : constants){
			sb.append(c.toString());
			counter++;
			if (counter!=constants.size()){
				sb.append(", ");
			}
		}
		return sb.toString();
	}	
	
	public String toString(){
		// TODO Auto-generated method stub
				StringBuilder sb=new StringBuilder();
				sb.append(predicate).append("(");
				
				int counter=0;
				for (Constant c : constants){
					sb.append(c.toString());
					counter++;
					if (counter!=constants.size()){
						sb.append(", ");
					}
				}
				sb.append(")");
				return sb.toString();
	}

}
