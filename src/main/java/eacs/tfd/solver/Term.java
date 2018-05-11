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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Term other = (Term) obj;
		if (Float.floatToIntBits(value) != Float.floatToIntBits(other.value))
			return false;
		return true;
	}
}
