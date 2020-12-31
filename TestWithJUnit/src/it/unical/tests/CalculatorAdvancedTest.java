package it.unical.tests;

import org.junit.Assert;
import org.junit.Test;

import it.unical.businesslogic.Calculator;

public class CalculatorAdvancedTest {

	@Test 
	public void advancedMultiplicationTest() {
		
		Calculator calculator = new Calculator();
		Assert.assertEquals(1000000, calculator.multiply(1000, 1000));
	}
}
