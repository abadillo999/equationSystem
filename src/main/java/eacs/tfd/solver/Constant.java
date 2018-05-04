package eacs.tfd.solver;

import java.util.Set;

public class Constant extends Term {

	public Constant(float value) {
		super(value);
	}

	public Constant clon() {
		return new Constant(this.value);
	}

	@Override
	public boolean hasName(String name) {
		return false;
	}

	@Override
	public boolean hasName(Set<String> names) {
		return false;
	}
	@Override
	public void dispatch(TermVisitor visitor) {
		visitor.visit(this);
	}


}
