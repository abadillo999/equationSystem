import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import eacs.tfd.solver.Term;
import eacs.tfd.solver.Variable;

public class VariableTest {

	@Test
	public void clone_variable_test() {
		Term variable = new Variable(1f, "x");
		 
		assertTrue(variable.clon().hasName("x"));
		assertEquals(1f, variable.clon().getValue(), 0.00001f);
		
	}

	@Test
	public void multiply_variable_test() {
		
		Variable constant = new Variable(2.2f, "x");	
		constant.multiply(2);
		
		assertEquals(constant.getValue(), 4.4f, 0.00001);		
				
	}
}
