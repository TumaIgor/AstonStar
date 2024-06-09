package aston.list.models;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

import aston.list.interfaces.RealizeList;

public class MyArrayList<E> implements RealizeList<E> {
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
	private Object[] elements;
	private int size;
	
	public MyArrayList() {
//		elements = new Object[10];
		this(10);
	}
	
	public MyArrayList(int initialCapacity) {
		if(initialCapacity < 0) {
			throw new IllegalArgumentException("Illegal capacity" + initialCapacity);
		}
		if(initialCapacity > MAX_ARRAY_SIZE) {
			initialCapacity = MAX_ARRAY_SIZE; 
		}
		elements = new Object[initialCapacity];
	}


	@Override
	public int size() {
		
		return size;
	}

	@Override
	public boolean add(int index, E element) {
		ensureCapacity();
		if(index == size) {
			elements[size] = element;
		} else {
			checkIndex(index);
			System.arraycopy(elements, index, elements, index + 1, size - index);
			elements[index] = element;
		}
		size++;
		return true;
	}

	private void checkIndex(int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(index + " out of bounds");
		}
		
	}

	private void ensureCapacity() {
		if(size == MAX_ARRAY_SIZE) {
			throw new OutOfMemoryError();
		}
		if (size == elements.length) {
			int newCapacity = elements.length + elements.length / 2 + 1;
			if (newCapacity < 0 || newCapacity > MAX_ARRAY_SIZE) {
				newCapacity = MAX_ARRAY_SIZE;
			}
			elements = Arrays.copyOf(elements, newCapacity);
		}
	}

	@Override
	public E get(int index) {
		checkIndex(index);
		return (E) elements[index];
	}

	@Override
	public int indexOf(Object o) {
		if(o == null) {
			for(int i =0; i < size; i++) {
				if (elements[i] == o) {
					return i;
				}
			}
		} else {
			for(int i =0; i < size; i++) {
				if (o.equals(elements[i])) {
					return i;
				}
			}
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0; 
	}

	@Override
	public E remove(int index) {
		checkIndex(index);
		E victim = (E) elements[index];
		System.arraycopy(elements, index + 1, elements, index, --size - index);
		return victim;
	}

	@Override
	public E set(int index, E element) {
		checkIndex(index);
		@SuppressWarnings("unchecked")
		E victim = (E) elements[index];
		elements[index] = element;
		return victim;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	} 

}
