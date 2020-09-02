package test.data_structures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import model.data_structures.ArregloDinamico;
import model.data_structures.ListaEncadenada;

public class TestListaEncadenada {
	private ListaEncadenada<Double> arreglo;

	@Before
	public void setUp1() {
		arreglo= new ListaEncadenada<Double>();
	}

	public void setUp3() {
		arreglo = new ListaEncadenada<Double>();
		arreglo.insertElement(1.0, 1);
		arreglo.insertElement(2.0, 2);
		arreglo.insertElement(3.0, 3);
		arreglo.insertElement(4.0, 4);
		arreglo.insertElement(5.0, 5);
		arreglo.insertElement(6.0, 6);
		arreglo.insertElement(7.0, 7);
		arreglo.insertElement(8.0, 8);
		arreglo.insertElement(9.0, 9);
	}


	@Test
	public void testArregloDinamico() {
		assertTrue(arreglo!= null);
		assertEquals(0, arreglo.size());
	}

	@Test
	public void testAddFirst()
	{
		setUp3();
		arreglo.addFirst(11.0);
		try {
			assertEquals("No se agrego el elemento en la primera posicion", Double.valueOf(11.0), arreglo.firstElement());
		} catch (Exception e) {
			fail("Lanzada excepcion no esperada");
		}
	}
	@Test
	public void testaddLast()
	{
		setUp3();
		arreglo.addLast(11.0);
		try {
			assertEquals("No se agrego el elemento en la ultima posicion", Double.valueOf(11.0), arreglo.lastElement());
		} catch (Exception e) {
			fail("Lanzada excepcion no esperada");
		}
	}
	@Test
	public void testInsertElement1()
	{
		setUp3();
		arreglo.insertElement(15.0, 3);
		assertEquals("El elemento en esta posicion no es la esperada", Double.valueOf(15.0), arreglo.getElement(3));
		assertEquals("El elemento en esta posicion no es la esperada", Double.valueOf(3.0), arreglo.getElement(4));
		assertEquals("El elemento en esta posicion no es la esperada", Double.valueOf(2.0), arreglo.getElement(2));
		assertEquals("El elemento en esta posicion no es la esperada", Double.valueOf(4.0), arreglo.getElement(5));
	}
	@Test
	public void testInsertElement2()
	{
		setUp1();
		arreglo.insertElement(1.0,1 );
		arreglo.insertElement(2.0, 2);
		arreglo.insertElement(3.0, 3);
		assertEquals("El elemento en esta posicion no es la esperada", Double.valueOf(1.0), arreglo.getElement(1));
		assertEquals("El elemento en esta posicion no es la esperada", Double.valueOf(2.0), arreglo.getElement(2));
		assertEquals("El elemento en esta posicion no es la esperada", Double.valueOf(3.0), arreglo.getElement(3));
		assertEquals("La cantidad de datos no es la esperada", 3, arreglo.size());
	}
	@Test
	public void testInsertElement3()
	{
		setUp3();
		arreglo.insertElement(12.0, 5);
		arreglo.insertElement(13.0, 7);
		assertEquals("El elemento en esta posicion no es la esperada",Double.valueOf(5.0), arreglo.getElement(6));
		assertEquals("El elemento en esta posicion no es la esperada", Double.valueOf(13.0), arreglo.getElement(7));
		assertEquals("El elemento en esta posicion no es la esperada", Double.valueOf(6.0), arreglo.getElement(8));
		assertEquals("El elemento en esta posicion no es la esperada", Double.valueOf(12.0), arreglo.getElement(5));
	}

	@Test
	public void testRemoveFirst(){
		setUp3();
		try {
			arreglo.removeFirst();
			assertEquals("No se elimino el primer elemento", Double.valueOf(2.0), arreglo.firstElement());


		}catch(Exception e)
		{
			fail("Lanzada excepcion no esperada");
		}
	}
	@Test
	public void testRemoveLast(){
		setUp3();
		try {
			arreglo.removeLast();
			Assert.assertEquals("No se elimino el ultimo elemento", Double.valueOf(8.0), arreglo.lastElement());
		}catch(Exception e)
		{
			fail("Lanzada excepcion no esperada");
		}
	}
	@Test
	public void testDeleteElement() {
		setUp3();
		try {
			arreglo.deleteElement(5);
		} catch (Exception e) {
			assertEquals("No se debería lanzar la excepción",true, true);
		}
		assertEquals("El elemento no debe existir en el arreglo", Double.valueOf(6.0), arreglo.getElement(5));
		assertEquals("El elemento no debe existir en el arreglo", Double.valueOf(7.0), arreglo.getElement(6));
		assertEquals("El elemento no debe existir en el arreglo", Double.valueOf(8.0), arreglo.getElement(7));
		assertEquals("El elemento no debe existir en el arreglo", Double.valueOf(9.0), arreglo.getElement(8));
	}
	@Test
	public void testFirstElement()
	{
		setUp3();
		try {
			assertEquals("Debe retornar el primer elemento", Double.valueOf(1.0), arreglo.firstElement());
		}catch(Exception e)
		{
			fail("Lanzada excepcion no esperada");
		}
	}
	@Test
	public void testLastElement()
	{
		setUp3();
		try {
			assertEquals("Debe retornar el último elemento", Double.valueOf(9.0), arreglo.lastElement());
		}catch(Exception e)
		{
			fail("Lanzada excepcion no esperada");
		}
	}
	@Test
	public void testGetElement()
	{
		setUp3();
		assertEquals("El elemento no es el esperado", Double.valueOf(6.0), arreglo.getElement(6));
		assertEquals("El elemento no es el esperado", Double.valueOf(9.0), arreglo.getElement(9));
		assertEquals("El elemento no es el esperado", Double.valueOf(4.0), arreglo.getElement(4));
	}
	@Test
	public void testIsSize()
	{
		setUp3();
		assertEquals("El numero de datos del arreglo no es el esperado ", 9, arreglo.size());

	}

	@Test
	public void testIsSize2()
	{
		setUp1();
		assertEquals("El numero de datos del arreglo no es el esperado ", 0, arreglo.size());

	}
	@Test
	public void testIsEmpty()
	{
		setUp1();
		assertTrue( "El arreglo esta vacio, el resultado no es el esperado", arreglo.isEmpty());
	}
	@Test
	public void testIsEmpty2()
	{
		setUp3();
		assertFalse( "El arreglo esta vacio, el resultado no es el esperado", arreglo.isEmpty());
	}
	@Test
	public void testIsPresent()
	{
		setUp3();
		assertEquals("La posición del elemento no es la esperada", 8,arreglo.isPresent(8.0));
		assertEquals("La posición del elemento no es la esperada", 4,arreglo.isPresent(4.0));
		assertEquals("La posición del elemento no es la esperada", 1,arreglo.isPresent(1.0));
		assertEquals("El elemento no deberia existir", -1,arreglo.isPresent(14.0));
	}
	@Test
	public void testExchange()
	{
		setUp3();
		arreglo.exchange(1, 9);
		arreglo.exchange(4, 7);
		assertEquals("No se intercambiaron los datos", Double.valueOf(1.0), arreglo.getElement(9));
		assertEquals("No se intercambiaron los datos", Double.valueOf(9.0), arreglo.getElement(1));
		assertEquals("No se intercambiaron los datos", Double.valueOf(4.0), arreglo.getElement(7));
		assertEquals("No se intercambiaron los datos", Double.valueOf(7.0), arreglo.getElement(4));
	}
	@Test
	public void testChangeInfo()
	{
		setUp3();
		arreglo.changeInfo(1, 10.0);
		arreglo.changeInfo(5, 15.0);
		arreglo.changeInfo(8, 18.0);
		assertEquals("No se actualizo el elemento", Double.valueOf(10.0), arreglo.getElement(1));
		assertEquals("No se intercambiaron los datos", Double.valueOf(15.0), arreglo.getElement(5));
		assertEquals("No se intercambiaron los datos", Double.valueOf(18.0), arreglo.getElement(8));
	}


}
