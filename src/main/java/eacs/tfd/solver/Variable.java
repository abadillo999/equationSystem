package eacs.tfd.solver;

import java.util.Set;

public class Variable extends Term {

	private String name;

	public Variable(float value, String name) {
		super(value);
		this.name = name;
	}

	@Override
	public boolean hasName(String name) {
		return this.name.equalsIgnoreCase(name);
	}

	@Override
	public boolean hasName(Set<String> names) {
		return names.contains(this.name);
	}

	@Override
	public Term clon() {
		return new Variable(this.value, this.name);
	}

	@Override
	public void dispatch(TermVisitor visitor) {
		visitor.visit(this);
	}

	public String getName() {
		return this.name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Variable other = (Variable) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
