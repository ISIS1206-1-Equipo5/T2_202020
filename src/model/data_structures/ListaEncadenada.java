package model.data_structures;



import java.util.Iterator;



public class ListaEncadenada<T extends Comparable<T>> implements ILista<T>, Iterable<T>

{

	private Node first;

	private int tamanio;

	public class Node
	{
		T item;
		Node next;
		public Node()
		{
			this.item = null;
			this.next = null;
		}

		public T getItem(){

			return item;

		}

		public void setItem(T pItem)

		{

			this.item = pItem;

		}

		public Node getNext()

		{

			return next;

		}

		public void setNext(Node pNext)

		{

			this.next = pNext;

		}



	}








	@Override

	public int size() {

		int tamano = 0;

		Iterator<T> iterator = iterator();

		while(iterator.hasNext())

		{

			T item = iterator.next();

			tamano++;

		}


		return tamano;

	}



	@Override

	public T getElement(int pos) {

		T element = null;


		if(pos == 1)

		{

			element = first.getItem();

		}

		else {

			Node act = first;

			for (int i = 1; i < pos; i++) {

				act = act.getNext();


			}


			element = act.getItem();



		}







		return element;

	}



	@Override

	public void addLast(T element) {


		Node nuevo = new Node();

		nuevo.setItem(element);


		if(isEmpty())

		{

			first = nuevo;

		}

		else {

			Node act = first;


			while(act.getNext() != null)

			{

				act = act.getNext();

			}

			act.setNext(nuevo);

		}

		tamanio++;

	}



	@Override

	public void addFirst(T element) {


		Node nuevo = new Node();

		nuevo.setItem(element);


		if(isEmpty())

		{

			first = nuevo;

		}

		else {

			nuevo.setNext(first);

			first = nuevo;

		}

		tamanio++;

	}







	@Override

	public void insertElement(T element, int pos) throws IndexOutOfBoundsException {

		if( pos< 1)

			throw new IndexOutOfBoundsException(); 

		Node nuevo = new Node();

		nuevo.setItem(element);

		if(isEmpty())

		{

			addFirst(element);

		}

		else if(pos == (tamanio+1))

		{

			addLast(element);

		}


		else {


			Node act = first;

			if(1 == (pos-1))

			{

				Node sig = act.getNext();

				act.setNext(nuevo);

				nuevo.setNext(sig);

			}

			else {

				for (int i =1; i < (pos-1); i++) {

					act = act.getNext();

				}

				Node sig = act.getNext();

				act.setNext(nuevo);

				nuevo.setNext(sig);




			}

			tamanio++;

		}





	}



	@Override

	public T removeFirst() throws Exception {

		if(tamanio == 0)

			throw new Exception("la lista no tiene elementos");

		T eliminado = first.item;

		first = first.next;

		tamanio--;


		return eliminado;

	}



	@Override

	public T removeLast() throws Exception {

		if(tamanio == 0)

			throw new Exception("La lista no tiene elementos");

		T element = null;

		Node act = first;

		while(act.getNext().getNext()!= null)

		{

			act = act.getNext();

		}

		act.setNext(null);

		tamanio--;


		return getElement(tamanio);



	}



	@Override

	public T deleteElement(int pos) throws Exception {

		if(tamanio < pos || pos < 1)

			throw new IndexOutOfBoundsException();


		T eliminar = getElement(pos);

		Node act = first;

		if(1 == (pos-1))

		{

			Node element1 = first.getNext();

			first.setNext(element1.getNext());

			element1.setNext(null);

		}

		else {

			for (int i =1; i < (pos-1); i++) {

				act = act.getNext();

			}

			Node sig = act.getNext();

			act.setNext(sig.getNext());

			sig.setNext(null);



		}

		tamanio--;







		return null;

	}



	@Override

	public T firstElement() throws Exception {

		if(tamanio == 0)

			throw new Exception("La lista no tiene elementos");

		return first.getItem();

	}



	@Override

	public T lastElement() throws Exception {

		if(tamanio == 0)

			throw new Exception("La lista no tiene elementos");

		T element = null;

		Node act = first;

		while(act.getNext()!= null)

		{

			act = act.getNext();

		}

		element = act.getItem();


		return element ;

	}



	@Override

	public boolean isEmpty() {


		return first== null;

	}



	@Override

	public int isPresent(T element) {

		int posicion = -1;

		int contador = 0;

		boolean encontro = false;

		Node act = first;

		while(act!= null && !encontro)

		{

			contador++;

			if(act.getItem().equals(element))

			{

				posicion = contador;

				encontro = true;

			}

			act = act.getNext();

		}

		return posicion;

	}



	@Override

	public void exchange(int pos1, int pos2) throws IndexOutOfBoundsException {


		if(tamanio < pos1 || pos1 < 1)

			throw new IndexOutOfBoundsException();


		if(tamanio < pos2 || pos2 < 1)

			throw new IndexOutOfBoundsException();

		Node act1 = first;

		Node act2 = first;

		if(pos1 != 1 || pos2!= 1)

		{

			for (int i =1; i < pos1; i++) {

				act1 = act1.getNext();

			}


			for (int i =1; i < pos2; i++) {

				act2 = act2.getNext();

			}

		}

		T item1 = act1.getItem();

		T item2 = act2.getItem();


		act1.setItem(item2);

		act2.setItem(item1);







	}



	@Override

	public void changeInfo(int pos, T elem) throws IndexOutOfBoundsException {


		if(tamanio < pos || pos < 1)

			throw new IndexOutOfBoundsException(pos-1);


		Node act = first;

		for (int i =1; i < pos; i++) {

			act = act.getNext();

		}

		act.setItem(elem);


	}



	@Override

	public Iterator<T> iterator() {

		return new ListIterator();

	}


	private class ListIterator implements Iterator<T>{


		private Node current = first;




		@Override

		public boolean hasNext() {


			return current!= null;

		}



		@Override

		public T next() {

			T item = current.item;

			current = current.next;

			return item;

		}







	}

}