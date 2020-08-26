/**

package test.logic;

import static org.junit.Assert.*;
import model.logic.Modelo;

import org.junit.Before;
import org.junit.Test;

public class TestModelo {
	
	private Modelo modelo;
	private static int CAPACIDAD=100;
	
	@Before
	public void setUp1() {
		modelo= new Modelo(CAPACIDAD);
	}

	public void setUp2() {
		for(int i =0; i< CAPACIDAD;i++){
			modelo.agregar(i);
		}
	}

	@Test
	public void testModelo() {
		assertTrue(modelo!=null);
		assertEquals(0, modelo.darTamano());  // Modelo con 0 elementos presentes.
	}

	@Test
	public void testDarTamano() {
		setUp2();
		assertEquals(100, modelo.darTamano());
	}

	@Test
	public void testAgregar() {
		setUp2();
		for(int i =0; i < CAPACIDAD; i++) {
			Integer actual = modelo.darElemento(i);
			assertEquals(i, actual.intValue());
		}
	}

	@Test
	public void testBuscar() {
		setUp2();
		for(int i =0; i < CAPACIDAD; i++) {
			assertEquals(Integer.valueOf(i),modelo.buscar(Integer.valueOf(i)));
		}
	}

	@Test
	public void testEliminar() {
		setUp2();
		for(int i = 0; i < CAPACIDAD-1;i++)
		{
			modelo.eliminar(Integer.valueOf(i));
		}
		
		assertEquals(1, modelo.darTamano());
		
		modelo.eliminar(99);
		
		assertEquals(0, modelo.darTamano());
		
	}

}
 * 
 */
