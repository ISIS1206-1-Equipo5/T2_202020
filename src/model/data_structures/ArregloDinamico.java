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
	public void insertElement(T element, int pos) {
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
	
	@Override
	public T removeFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public T removeLast() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public T deleteElement(int pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T firstElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T lastElement() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public T getElement(int pos) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int size() {
		return tamanoAct;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int isPresent(T element) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void exchange(int pos1, int pos2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changeInfo(int pos, T elem) {
		// TODO Auto-generated method stub

	}

	public T buscar(T dato) {
		T buscado = null;

		for(int i = 0; i < tamanoAct; i++)
		{
			T t = elementos[i];

			if(t.compareTo(dato)== 0)
				buscado = t;
		}

		return buscado;
	}

	public T eliminar(T dato) {
		T buscado = null;
		boolean encontro = false;
		for(int i = 0; i < tamanoAct && !encontro; i++)
		{
			T t = elementos[i];

			if(t.compareTo(dato)== 0)
			{
				buscado = t;
				encontro = true;
				for(int j = i+1; j< tamanoAct; j++)
				{
					T siguiente = elementos[j];
					elementos[j-1] = siguiente;
				}
				elementos[elementos.length-1] = null;
				tamanoAct--; 
			}

		}

		return buscado;
	}

	public T darElemento(int i) {
		return elementos[i];
	}

}
