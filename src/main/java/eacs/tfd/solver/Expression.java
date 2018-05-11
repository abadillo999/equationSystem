package eacs.tfd.solver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Expression {
	private List<Term> terms = new ArrayList<Term>();

	public boolean empty() {
		return this.terms.isEmpty();
	}

	public void add(Term term) {
		this.terms.add(term);
	}

	public void add(Expression exp) {
		this.terms.addAll(exp.terms);
	}

	public void simplify() {
		float aux = this.getValue();
		this.removeAllTerms();
		this.terms.add(new Constant(aux));
	}

	public void simplify(String name) {
		float aux = getValue(name);
		this.removeAllTerms(name);
		this.terms.add(new Variable(aux, name));
	}

	public float getValue(String name) {
		float aux = 0;
		for (Term term : this.terms) {
			if (term.hasName(name)) {
				aux += term.getValue();
			}
		}
		return aux;
	}

	public float getValue() {
		float aux = 0;
		for (Term term : this.terms) {
			if (!term.hasName(this.getNameSet())) {
				aux += term.getValue();
			}
		}
		return aux;
	}

	public void apply(String name, float scalar) {
		float aux = getValue(name);
		this.removeAllTerms(name);
		this.terms.add(new Constant(aux * scalar));
	}

	public Expression clon() {
		Expression aux = new Expression();
		aux.add(this);
		return aux;
	}

	public Set<String> getNameSet() {
		return new NameExpressionAnalyzer(this.terms).getNameSet();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Expression other = (Expression) obj;
		if (terms == null) {
			if (other.terms != null)
				return false;
		} else if (!terms.equals(other.terms))
			return false;
		return true;
	}

	private void removeElements(List<Term> itemsToRemove) {
		this.terms.removeAll(itemsToRemove);
	}

	private void removeAllTerms(String name) {
		List<Term> itemsToRemove = new ArrayList<Term>();
		for (Term term : this.terms) {
			if (term.hasName(name)) {
				itemsToRemove.add(term);
			}
		}
		this.removeElements(itemsToRemove);
	}

	private void removeAllTerms() {
		List<Term> itemsToRemove = new ArrayList<Term>();
		for (Term term : this.terms) {
			if (!term.hasName(this.getNameSet())) {
				itemsToRemove.add(term);
			}
		}
		this.removeElements(itemsToRemove);
	}

}
