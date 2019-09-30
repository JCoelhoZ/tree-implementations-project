package src.main.java.br.univille.treeimplementationsproject;

import java.util.Iterator;

public class ArrayIterator<E> implements Iterator<E> {

	private E[] array;
	private int cursorPosition = 0;

	public ArrayIterator(E[] lista) {
		this.array = array;
	}

	@Override
	public boolean hasNext() {
		return cursorPosition < array.length;
	}

	@Override
	public E next() {
		if (!hasNext()) {
			throw new AssertionError("Não há outro elemento");
		}
		return array[cursorPosition++];
	}

}
