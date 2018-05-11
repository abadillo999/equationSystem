package eacs.tfd.solver;

import java.util.List;

import eacs.tfd.solver.Expression;

public class ExpressionBuilder {

	private Expression exp;

	public ExpressionBuilder() {
		this.exp = new Expression();
	}

	public ExpressionBuilder add(Expression expression) {
		exp.add(expression);
		return this;
	}

	public ExpressionBuilder add(Term term) {
		exp.add(term);
		return this;
	}

	public ExpressionBuilder add(List<Term> terms) {
		for (Term term : terms) {
			exp.add(term);
		}
		return this;
	}

	public Expression build() {
		return exp;
	}

}
