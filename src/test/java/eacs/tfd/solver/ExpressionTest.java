package eacs.tfd.solver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class ExpressionTest {

	@Test
	public void empty_expression() {
		Expression exp = new ExpressionBuilder().build();
		assertTrue(exp.empty());
	}

	@Test
	public void clone_expression() {
		Expression exp = new ExpressionBuilder().build();
		Expression result = exp.clon();
		assertTrue(exp.equals(result));
	}

	@Test
	public void add_term_expression() {
		Term term = new Variable(1f, "X");
		Expression exp = new ExpressionBuilder().add(term).build();
		assertFalse(exp.empty());
	}

	@Test
	public void add_expression_expression() {
		Term term = new Variable(1f, "X");
		Expression expAux = new ExpressionBuilder().add(term).build();
		Expression expSut = new ExpressionBuilder().add(expAux).build();
		assertFalse(expSut.empty());
	}

	@Test
	public void simplify_constant_expression() {
		List<Term> constants = new ArrayList<Term>() {
			private static final long serialVersionUID = 1L;
			{
				add(new Constant(2f));
				add(new Constant(2f));
			}
		};
		Expression exp = new ExpressionBuilder().add(constants).build();
		exp.simplify();
		Expression result = new ExpressionBuilder().add(new Constant(4f)).build();
		assertTrue(exp.equals(result));
	}

	@Test
	public void simplify_variable_expression() {
		List<Term> variables = new ArrayList<Term>() {
			private static final long serialVersionUID = 1L;
			{
				add(new Variable(2f, "X"));
				add(new Variable(2f, "X"));
			}
		};
		Expression exp = new ExpressionBuilder().add(variables).build();
		exp.simplify("X");
		Expression result = new ExpressionBuilder().add(new Variable(4f, "X")).build();
		assertTrue(exp.equals(result));
	}

	@Test
	public void apply_variable_expression() {
		List<Term> variables = new ArrayList<Term>() {
			private static final long serialVersionUID = 1L;
			{
				add(new Variable(2f, "X"));
				add(new Variable(2f, "X"));
				add(new Variable(5f, "Y"));
				add(new Constant(3.1f));
			}
		};
		Expression exp = new ExpressionBuilder().add(variables).build();
		exp.apply("X", 10f);

		assertEquals(exp.getValue(), 43.1f, 0.00001);

	}

	@Test
	public void get_name_set_expression() {
		List<Term> variables = new ArrayList<Term>() {
			private static final long serialVersionUID = 1L;
			{
				add(new Variable(2f, "X"));
				add(new Variable(2f, "Z"));
				add(new Variable(5f, "Y"));
				add(new Constant(3.1f));
			}
		};
		Expression exp = new ExpressionBuilder().add(variables).build();
		Set<String> result = exp.getNameSet();
		assertEquals(3, result.size());

		assertTrue(result.contains("X"));
		assertTrue(result.contains("Z"));
		assertTrue(result.contains("Y"));

	}

}
