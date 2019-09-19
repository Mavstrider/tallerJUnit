/**
 * 
 */
package com.everis.bootcamp.tallerJUnit;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.everis.bootcamp.tallerjunit.Articulo;
import com.everis.bootcamp.tallerjunit.BaseDeDatosService;
import com.everis.bootcamp.tallerjunit.CarritoCompraService;

/**
 * @author admin
 *
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(MockitoJUnitRunner.class)
public class CarritoCompraServiceTest {

	List<Articulo> articulos = new ArrayList<Articulo>();

	// CarritoCompraService ccs;
	@InjectMocks
	static CarritoCompraService carrito;
	// Articulo art = new Articulo("Batatas", 2.2);
	// Articulo art1 = new Articulo("Ba", 3.2);
	@Mock
	static BaseDeDatosService servicebd;
	@BeforeClass
	public static void testBeforeClass() {
		System.out.println("Entramos en la Beforeclass");
		carrito = new CarritoCompraService();
		// servicebd = Mockito.mock(BaseDeDatosService.class);
	}

	@AfterClass
	public static void testAfterClass() {
		System.out.println("Entramos en el AfterClass");
	}

	@Before
	public void testBefore() {
		System.out.println("Entramos en el Before");
		Mockito.when(servicebd.findByIdJava8(1L)).thenReturn(new Articulo(1L, " mockeado id 1", 10D));
		Mockito.when(servicebd.findByIdJava8(100L)).thenReturn(new Articulo(100L, "mockeadoid 100", 10D));


	}

	@After
	public void testAfter() {
		System.out.println("Entramos en el After");


	}


//	@Test
//	public void testAddArticulo() {
//		System.out.println("Entramos em AddArticulo");
//		int sizeAntes = ccs.getArticulos().size();
//		ccs.addArticulo(art);
//		int sizeAfter = ccs.getArticulos().size();
//		assertEquals(sizeAntes, sizeAfter, 1);
//	}
//
//	@After
//	public void testAfter() {
//		System.out.println("depois de afteer");
//	}
//
//
//
//	@Test
//	public void testLimpiarCesto() {
//		System.out.println("Entramos em Limpar Cesta");
//		assertTrue(ccs.getArticulos().isEmpty());
//		ccs.addArticulo(art);
//		ccs.limpiarCesta();
//		assertTrue(ccs.getArticulos().isEmpty());
//
//	}
//
//
//
//	@Test
//	public void testprecoTotal() {
//		System.out.println("Entramos em Limpar Cesta");
//		ccs.addArticulo(art);
//		ccs.addArticulo(art1);
//		ccs.totalPrice();
//
//		assertEquals(ccs.totalPrice(), new Double(5.4));
//
//	}
//	
//	@Test
//	public void testDesconto() {
//		System.out.println("Entramos no Desconto");
////		ccs.addArticulo(new Articulo("Batatas", 10D));
////		ccs.addArticulo(new Articulo("Favas", 20D));
//		
//		double desc = ccs.calculadorDescuento(30D, 10D);
//		
//
//		assertEquals(27, desc, 0);
//
//	}
//	
//	@Test
//	public void testgetNumArtigos() {
//		System.out.println("Entramos no NumArtigos");
//		ccs.addArticulo(new Articulo("Batatas", 10D));
//		ccs.addArticulo(new Articulo("Favas", 20D));
//
//		int num = ccs.getNumArticulo();
//
//		assertEquals(2, num, 0);
//
//	}
//
//	@Test
//	public void testsetArtigo() {
//		System.out.println("----------------------------------Entramos List setArtigos");
//		List<Articulo> lart = new ArrayList<>();
//		ccs.addArticulo(new Articulo("Batatas", 10D));
//		ccs.addArticulo(new Articulo("Favas", 20D));
//		ccs.setArticulos(lart);
//		assertEquals(lart, ccs.getArticulos());
//
//	}

	@Test
	public void testAddArticulo3() {
		System.out.println("Entramos em AddArticulo");
		int sizeAntes = carrito.getArticulos().size();
		carrito.addArticulo(new Articulo("Batatas", 10D));
		int sizeAfter = carrito.getArticulos().size();
		assertEquals(sizeAntes, sizeAfter, 1);


	}

	@Test
	public void testCalculateprecoTotalnew() {
		System.out.println("Entramos em Preço total");
		carrito.limpiarCesta();
		carrito.addArticulo(new Articulo("Batatas", 10D));
		carrito.addArticulo(new Articulo("Favas", 30D));
		carrito.addArticulo(new Articulo("feijoes", 20D));
		carrito.totalPrice();

		assertEquals(carrito.totalPrice(), new Double(60));

	}

	@Test
	public void testLimpaCesto() {
		System.out.println("Entramos em Limpar Cesta");
		carrito.limpiarCesta();
		assertTrue(carrito.getArticulos().isEmpty());
		carrito.addArticulo(new Articulo("Batatas", 10D));
		carrito.addArticulo(new Articulo("Favas", 30D));
		carrito.addArticulo(new Articulo("feijoes", 20D));
		carrito.limpiarCesta();
		assertTrue(carrito.getArticulos().isEmpty());

	}
	
	@Test
	public void testAplicarDisconto() {
		System.out.println("Aplicar Disconto");
		double art = carrito.aplicarDescuento(1L, 5D);
		System.out.println("Preço total -->" + art);
		assertEquals(art, 9.5d, 0);

	}

	@Test
	public void testAplicarDisconto100() {
		System.out.println("Aplicar Disconto");
		double art = carrito.aplicarDescuento(100L, 5D);
		System.out.println("Preço total -->" + art);
		assertEquals(art, 9.5d, 0);

	}

}
