package it.unical.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import it.unical.businesslogic.Calculator;

public class CalculatorBasicTest {
	
	private static Calculator calculator;// rendiamo l'oggetto statico

	@Test(timeout = 1000) // possiamo usarlo per 'la richiesta ad un sito web', tempo espresso in milli secondi
	public void multiplicationWorks() throws InterruptedException {
		System.out.println(calculator);
		Thread.sleep(500);
		Assert.assertEquals(10, calculator.multiply(5, 2));
	}
	
	@Test
	public void additionWorks() {//Viene istanziato un oggetto CalculatorBasicTest per ogni prova di Test
		System.out.println(calculator);
		Assert.assertEquals(9, calculator.add(6, 3));
		Assert.assertEquals(5, calculator.add(2, 3));
	}
	
	@Test(expected = ArithmeticException.class) 
	public void divisionTest() {// non termina correttamente se non viene generata l'eccezione
		System.out.println(calculator);
		calculator.division(10, 0);
	}
	// eccezione controllate che estendono Exception e vengono gestite con un try catch
	// eccezione non controllata estendono RuntimeException non mi aspetto che ci sia
	
	@BeforeClass
	public static void inizializzazione() {// deve essere necessariamente statico
		System.out.println("Before Class");//possiamo usarlo ad esempio per l inizializzazione di un data base una sola volta prima di tutti i test
		calculator = new Calculator();
	}
	
	@Before
	public void primaDiOgniTest() {// prima di ogni 'test'
		System.out.println("before");
	}
}
