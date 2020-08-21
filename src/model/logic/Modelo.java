package model.logic;

import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private IArregloDinamico<Integer> datos;

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		datos = new ArregloDinamico<Integer>(7);
	}

	/**
	 * Constructor del modelo del mundo con capacidad dada
	 * @param tamano
	 */
	public Modelo(int capacidad)
	{
		datos = new ArregloDinamico<Integer>(capacidad);
	}

	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return datos.size();
	}


	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(Integer dato)
	{	
		datos.addLast(dato);
	}

	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public Integer buscar(Integer dato)
	{
		return datos.buscar(dato);
	}

	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public Integer eliminar(Integer dato)
	{
		return datos.eliminar(dato);
	}

	public Integer darElemento(int i)
	{
		return datos.darElemento(i);
	}

	//TODO esto se creó para probar el funcionamiento de los métodos

	public void insertarElemento(Integer elem, int pos) {
		datos.insertElement(elem, pos);
	}

	public Integer primerElemento() {
		return datos.firstElement();
	}

	public Integer ultimoElemento() {
		return datos.lastElement();
	}

	public Integer getElemento(int pos) {
		return datos.getElement(pos);
	}

	public boolean esVacio() {
		return datos.isEmpty();
	}

	public Integer estaPresente(Integer dato) {
		return datos.isPresent(dato);
	}

	public void intercambiar(int pos1, int pos2) {
		datos.exchange(pos1, pos2);
	}

	public void cambiarInfo(int pos, Integer elem) {
		datos.changeInfo(pos, elem);
	}
}
