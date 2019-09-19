
package com.everis.bootcamp.tallerJUnit;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.everis.bootcamp.tallerjunit.Calculadora;
public class CalculadoraTest {
	
	@BeforeClass
	public static void testBeforeClass() {
		System.out.println("Entramos en la Beforeclass");
	}

	@Before
	public void testBefore() {
		System.out.println("Entramos en el Before");
	}

	@After
	public void testAfter() {
		System.out.println("Entramos en el After");
	}

	@AfterClass
	public static void testAfterClass() {
		System.out.println("Entramos en el AfterClass");
	}

	@Test
	public void testSuma() {
		System.out.println("Entramos en el Test");
		Calculadora calculadora = new Calculadora();
		double res = calculadora.suma(1D, 1D);
		assertEquals(2, res, 0);
	}

	@Test
	public void testResto() {
		System.out.println("Entramos en el Test");
		Calculadora calculadora = new Calculadora();
		double res = calculadora.resto(2D, 1D);
		assertEquals(1, res, 0);
	}

	@Test
	public void testMultiplicar() {
		System.out.println("Entramos en el Test");
		Calculadora calculadora = new Calculadora();
		double res = calculadora.multiplicar(3D, 2D);
		assertEquals(6, res, 0);
	}

	@Test
	public void testDividir() {
		System.out.println("Entramos en el Test");
		Calculadora calculadora = new Calculadora();
		double res = calculadora.dividir(4D, 2D);
		assertEquals(2, res, 0);
	}

}
