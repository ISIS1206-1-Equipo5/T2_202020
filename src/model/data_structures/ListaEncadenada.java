package model.data_structures;

import java.util.Iterator;

public class ListaEncadenada<T extends Comparable<T>> implements ILista<T>, Iterable<T>
{
	private Node first;
	
	private Node last;

	
	public class Node
	{
		T item;
		Node next;
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
		int contador = 0;
		Iterator<T> iterator = iterator();
		while(iterator.hasNext()&& element!= null)
		{
			T item = iterator.next();
			if(contador == (pos-1))
			{
				element = item;

			}
				
			contador++;
		}

		return element;
	}

	@Override
	public void addLast(T element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addFirst(T element) {
		
		Node oldFirst = first;
		first = new Node();
		first.item = element;
		first.next = oldFirst;
		
	}
	

	@Override
	public void insertElement(T element, int pos) throws IndexOutOfBoundsException {
		
		
		
	}

	@Override
	public T removeFirst() throws Exception {
		T element = null;
		T eliminado = first.item;
		first = first.next;
		
		return eliminado;
	}

	@Override
	public T removeLast() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T deleteElement(int pos) throws Exception {
		Iterator<T> iter = iterator();
		int contador = 0;
		Node prevoius = new Node();
		Node sig = new Node();
		boolean elimino = false;
		while(iter.hasNext() && !elimino)
		{
			T item = iter.next();
			if(contador == (pos-2))
			{
				prevoius.item = item;
			}
			else if(contador == pos)
			{
				sig.item= item;
				prevoius.next = sig;
				elimino = true;
				
			}
			

			contador++;
				
		}
		return getElement(pos);
	}

	@Override
	public T firstElement() throws Exception {
		
		return first.item;
	}

	@Override
	public T lastElement() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		
		return first== null;
	}

	@Override
	public int isPresent(T element) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void exchange(int pos1, int pos2) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeInfo(int pos, T elem) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		
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