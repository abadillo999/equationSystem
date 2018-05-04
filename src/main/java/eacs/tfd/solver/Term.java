package eacs.tfd.solver;

import java.util.Set;

public abstract class Term {

	protected float value;
	
	public Term(float value) {
		this.value = value;
		}
	
	public void multiply(float value) {
		this.value *= value;
	}
	
	public abstract boolean hasName(String name);
	
	public abstract boolean hasName(Set<String> names);
	
	public abstract Term clon();

	public float getValue() {
		return this.value;
	}

	public abstract void dispatch(TermVisitor visitor);

}
