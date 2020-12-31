package it.unical.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)// test suite classe aggiuntiva con l'esecuzione di tutti i test
@SuiteClasses({CalculatorBasicTest.class, CalculatorAdvancedTest.class})//array di classi test
public class CalculatorTestSuite {}
