package model.data_structures;

public interface ILista <T extends Comparable<T>> {
	
	
	/**
	 * Retornar el numero de elementos presentes en el arreglo
	 * @return 
	 */
	int size( );

	/**
	 * Retornar el elemento en la posicion pos
	 * @param pos posicion de consulta
	 * @return elemento de consulta. null si no hay elemento en posicion.
	 */
	T getElement( int pos );

	/**
	 * Agregar un dato de forma compacta (en la última casilla disponible) 
	 * Caso Especial: Si el arreglo esta lleno debe aumentarse su capacidad, agregar el nuevo dato y deben quedar multiples casillas disponibles para futuros nuevos datos.
	 * @param element nuevo elemento
	 */
	public void addLast( T element );

	/**
	 * Agregar un dato de forma compacta (en la primera casilla disponible) 
	 * Caso Especial: Si el arreglo esta lleno debe aumentarse su capacidad, agregar el nuevo dato y deben quedar multiples casillas disponibles para futuros nuevos datos.
	 * @param element nuevo elemento
	 */
	public void addFirst(T element);

	/**
	 * Agrega un elemento en una posición válida. 
	 * Caso Especial: Si el arreglo esta lleno debe aumentarse su capacidad, agregar el nuevo dato y deben quedar multiples casillas disponibles para futuros nuevos datos.
	 * @param element nuevo elemento
	 * @param pos posición a insertar
	 */
	public void insertElement(T element, int pos) throws IndexOutOfBoundsException;

	/**
	 * Elimina el primer elemento.
	 * @return El elemento eliminado
	 */
	public T removeFirst() throws Exception;

	/**
	 * Elimina el último elemento.
	 * @return El elemento eliminado
	 */
	T removeLast() throws Exception;

	/**
	 * Elimina el elemento en la posición dada.
	 * @param pos posición de elemento a eliminar
	 * @return El elemento eliminado
	 */
	T deleteElement(int pos) throws Exception;

	/**
	 * Retorna el primer elemento.
	 * @return 
	 */
	T firstElement() throws Exception;

	/**
	 * Retorna el último elemento.
	 * @return
	 */
	T lastElement() throws Exception;

	/**
	 * Determina si el arreglo no tiene datos.
	 * @return true si no tiene datos || false si tiene datos
	 */
	boolean isEmpty();

	/**
	 * Retorna la posición válida del elemento element
	 * @param element Elemento a buscar
	 * @return La posicion del elemento. Si no lo encuentra, retorna -1
	 */
	int isPresent(T element);

	/**
	 * Intercambia la información de los elementos de dos posiciones válidas.
	 * @param pos1 Posición del primer elemento
	 * @param pos2 Posición del segundo elemento.
	 */
	void exchange(int pos1, int pos2) throws IndexOutOfBoundsException;

	/**
	 * Actualiza el elemento en una posición válida
	 * @param pos Posición del elemento
	 * @param elem Objeto con actualización de información
	 */
	void changeInfo(int pos, T elem) throws IndexOutOfBoundsException;

}
