package test.Incubyte.StringCalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import main.Incubyte.StringCalculator.Calculator;

public class CalculatorTest {
	public static void main(String []args) {		
		 org.junit.runner.JUnitCore.main("test.Incubyte.StringCalculator.CalculatorTest");	 	
	}
	
	@Test
	public void testEmptyString() {
		assertEquals(0,Calculator.add(""));
	}
	
	@Test
	public void testOneNumber() {
		assertEquals(1,Calculator.add("1"));
	}
	
	@Test
	public void testTwoNumber(){
		assertEquals(3,Calculator.add("1,2"));
	}
	@Test
	public void testThreeNumber(){
		assertEquals(6,Calculator.add("1,2,3"));
	}
	@Test
	public void testNewLine() {
		assertEquals(6,Calculator.add("1\n2,3"));
	}
	@Test
	public void testOtherDelimiter() {
		assertEquals(3,Calculator.add("//;\n1;2"));
	}
	
	@Test
	public void testNegativeNumber() {
		try {
			Calculator.add("-1,2");
		}
		catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(),"Negatives Not allowed:-1");
		}
		
		try {
			Calculator.add("2,-4,3,-5");
		}
		catch (IllegalArgumentException e){
			assertEquals(e.getMessage(), "Negatives Not allowed:-4,-5");
		}
		
	}

}
