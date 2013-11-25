package objects;

import java.io.Serializable;
import java.util.List;

public class Conjunct implements Serializable {
	
	private static final long serialVersionUID= 7526472295622776150L;
	
	private List<Fact> facts;

	public Conjunct(List<Fact> facts) {
		super();
		this.facts = facts;
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
