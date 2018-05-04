package eacs.tfd.solver;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NameExpressionAnalyzer implements TermVisitor {

	private List<Term> terms;

	private Set<String> names;

	public NameExpressionAnalyzer(List<Term> terms) {
		this.terms = terms;
		names = new HashSet<String>();
	}

	public void visit(Variable variable) {
		names.add(variable.getName());
	}

	public void visit(Constant constant) {

	}
	
	public Set<String> getNameSet() {
		for (Term term : terms) {
			term.dispatch(this);
		}
		return names;
	}


}
