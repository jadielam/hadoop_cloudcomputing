package objects;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;


public class TraceStep extends FunctionElement{
	private InteractionRule interactionrule;
	private Fact fact;
	private Conjunct conjunct;
	
	public String toString(){
		StringBuilder sb=new StringBuilder();
		sb.append("[").append(interactionrule.toString()).append(", ");
		sb.append(fact.toString()).append(", ").append(conjunct.toString());
		sb.append("]");
		
		return sb.toString();
	}
	
	public TraceStep(){
		this.interactionrule=new InteractionRule();
		this.fact=new Fact();
		this.conjunct=new Conjunct();
	}
	public TraceStep(InteractionRule interactionrule, Fact fact,
			Conjunct conjunct) {
		this.interactionrule = interactionrule;
		this.fact = fact;
		this.conjunct = conjunct;
	}
	public InteractionRule getInteractionrule() {
		return interactionrule;
	}
	public Fact getFact() {
		return fact;
	}
	public Conjunct getConjunct() {
		return conjunct;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((conjunct == null) ? 0 : conjunct.hashCode());
		result = prime * result + ((fact == null) ? 0 : fact.hashCode());
		result = prime * result
				+ ((interactionrule == null) ? 0 : interactionrule.hashCode());
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
		TraceStep other = (TraceStep) obj;
		if (conjunct == null) {
			if (other.conjunct != null)
				return false;
		} else if (!conjunct.equals(other.conjunct))
			return false;
		if (fact == null) {
			if (other.fact != null)
				return false;
		} else if (!fact.equals(other.fact))
			return false;
		if (interactionrule == null) {
			if (other.interactionrule != null)
				return false;
		} else if (!interactionrule.equals(other.interactionrule))
			return false;
		return true;
	}
}