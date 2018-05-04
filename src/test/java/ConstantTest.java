import static org.junit.Assert.assertEquals;

import org.junit.Test;

import eacs.tfd.solver.Constant;

public class ConstantTest {

	
	@Test
	public void clone_constant_test() {
		Constant constant = new Constant(2.2f);
		assertEquals(2.2f, constant.clon().getValue(), 0.00001f);
	}

	@Test
	public void multiply_constant_test() {
		Constant constant = new Constant(2.2f);	
		constant.multiply(2);

		assertEquals(constant.getValue(), 4.4, 0.00001);		
		
		
	}
}
