package eacs.tfd.solver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class NameExpressionAnalyzerTest {

	@Test
	public void get_constant_receive_void() {
		List <Term> terms = new ArrayList<Term>();
		
		terms.add(new Constant(1f));
		terms.add(new Constant(2f));
		
		NameExpressionAnalyzer expAnalyzer = new NameExpressionAnalyzer(terms);
		
		assertEquals(0, expAnalyzer.getNameSet().size());
	}

	@Test
	public void get_variables_names() {
		
		List <Term> terms = new ArrayList<Term>();
		
		terms.add(new Constant(1f));
		terms.add(new Variable(2f, "X"));
		terms.add(new Constant(2f));
		terms.add(new Variable(2f, "Y"));
		terms.add(new Constant(1f));
		terms.add(new Variable(2f, "Z"));
		terms.add(new Constant(2f));
		terms.add(new Variable(2f, "Y"));
		
		NameExpressionAnalyzer expAnalyzer = new NameExpressionAnalyzer(terms);
		
		Set <String> result =  expAnalyzer.getNameSet();

		
		assertEquals(3,result.size());

		assertTrue(result.contains("X"));
		assertTrue(result.contains("Z"));
		assertTrue(result.contains("Y"));
		assertFalse(result.contains("A"));
		


	}

}
