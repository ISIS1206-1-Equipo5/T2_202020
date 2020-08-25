package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico< T extends Comparable<T>> implements IArregloDinamico<T> {
	/**
	 * Capacidad maxima del arreglo
	 */
	private int tamanoMax;
	/**
	 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
	 */
	private int tamanoAct;
	/**
	 * Arreglo de elementos de tamaNo maximo
	 */
	private T[] elementos;

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * @param max Capacidad maxima inicial
	 */
	public ArregloDinamico( int max )
	{
		elementos = (T[]) new Comparable[max];
		tamanoMax = max;
		tamanoAct = 0;
	}

	public void addFirst(T element) {
		tamanoAct++;
		if ( tamanoAct == tamanoMax )
		{  // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;
			T[] copia = elementos;
			elementos = (T[]) new Comparable[tamanoMax];
			for ( int i = 0; i < tamanoAct; i++)
			{
				elementos[i] = copia[i];
			} 
			System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
		}

		T actual = element;

		for(int j=0; j < tamanoAct;j++)
		{
			T siguiente = elementos[j];
			elementos[j] = actual;
			actual = siguiente;
		}
		elementos[tamanoAct] = actual;
	}

	public void addLast( T dato )
	{
		if ( tamanoAct == tamanoMax )
		{  // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;
			T[] copia = elementos;
			elementos = (T[]) new Comparable[tamanoMax];
			for ( int i = 0; i < tamanoAct; i++)
			{
				elementos[i] = copia[i];
			} 
			System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
		}	
		elementos[tamanoAct] = dato;
		tamanoAct++;
	}

	//Ojo con las posiciones, que empiezan desde 1
	//TODO Revisar el manejo de la excepci�n.
	public void insertElement(T element, int pos) throws IndexOutOfBoundsException {
		
		if(tamanoMax < pos)
			throw new IndexOutOfBoundsException(pos-1);
		
		tamanoAct++;
		if ( tamanoAct == tamanoMax )
		{  // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;
			T[] copia = elementos;
			elementos = (T[]) new Comparable[tamanoMax];
			for ( int i = 0; i < tamanoAct; i++)
			{
				elementos[i] = copia[i];
			} 
			System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
		}

		T actual = element;

		for(int j=pos-1; j < tamanoAct;j++)
		{
			T siguiente = elementos[j];
			elementos[j] = actual;
			actual = siguiente;
		}
		elementos[tamanoAct] = actual;
	}

	//TODO Revisar el manejo de la excepcion.
	public T removeFirst() throws Exception{
		
		if(tamanoAct == 0)
			throw new Exception("El arreglo no tiene elementos");
		
		T primero = elementos[0];

		for (int i = 0; i < tamanoAct-1; i++) {
			elementos[i] = elementos[i+1];
		}
		elementos[tamanoAct-1] = null;


		tamanoAct--;
		return primero;
	}


	//TODO Revisar el manejo de la excepcion.
	public T removeLast()  throws Exception{
		
		if(tamanoAct == 0)
			throw new Exception("El arreglo no tiene elementos");
		
		T ultimo = elementos[tamanoAct-1];
		elementos[tamanoAct-1] = null;
		tamanoAct--;
		return ultimo;
	}

	//Ojo con las posiciones, que empiezan desde 1	
	//TODO Revisar el manejo de la excepcion.
	public T deleteElement(int pos) throws IndexOutOfBoundsException {
		
		if(tamanoAct < pos)
			throw new IndexOutOfBoundsException(pos-1);
		
		T aEliminar = elementos[pos-1];

		for (int i = pos-1; i < tamanoAct-1; i++) {
			elementos[i] = elementos[i+1];
		}
		elementos[tamanoAct-1] = null;

		tamanoAct--;
		return aEliminar;
	}

	//TODO Revisar el manejo de la excepcion.
	public T firstElement() throws Exception{
		
		if(tamanoAct == 0)
			throw new Exception("El arreglo no tiene elementos");		
		
		return elementos[0];
	}

	//TODO Revisar el manejo de la excepcion.
	public T lastElement() throws Exception{
		
		if(tamanoAct == 0)
			throw new Exception("El arreglo no tiene elementos");
		
		return elementos[tamanoAct-1];
	}

	//TODO Revisar el manejo de la excepcion.
	public T getElement(int pos) throws IndexOutOfBoundsException{
		
		if(tamanoAct < pos)
			throw new IndexOutOfBoundsException(pos-1);
		
		return elementos[pos-1];
	}

	public int size() {
		return tamanoAct;
	}

	public boolean isEmpty() {
		boolean empty = false;
		if(tamanoAct==0)
			empty= true;
		return empty;
	}

	//Ojo con la posición, empieza desde 1
	public int isPresent(T element) {
		int posicion = -1;
		boolean encontro = false;

		for (int i = 0; i < tamanoAct && !encontro; i++) {
			T actual = elementos[i];
			if (actual.compareTo(element)==0) {
				encontro = true;
				posicion = i+1;
			}
		}

		return posicion;
	}

	//Ojo con la posición, empieza desde 1
	//TODO Revisar el manejo de la excepcion.
	public void exchange(int pos1, int pos2) throws IndexOutOfBoundsException{
		
		if(tamanoAct < pos1)
			throw new IndexOutOfBoundsException(pos1-1);
		
		if(tamanoAct < pos2)
			throw new IndexOutOfBoundsException(pos2-1);
		
		T objeto1 = getElement(pos1);
		T objeto2 = getElement(pos2);

		elementos[pos1-1] = objeto2;
		elementos[pos2-1] = objeto1;
	}

	//Ojo con la posición, empieza desde 1
	//TODO Revisar el manejo de la excepcion.
	public void changeInfo(int pos, T elem) throws IndexOutOfBoundsException{
		
		if(tamanoAct < pos)
			throw new IndexOutOfBoundsException(pos-1);
		
		elementos[pos-1] = elem;
	}

}
