package src.main.java.br.univille.treeimplementationsproject;

import java.util.Iterator;

/*
 *  arvore onde os nodos podem ter uma quantidade arbitraria de filhos.
 * */
public class Tree<E> {

	private int size;
	private Position<E> root;

	/** Retorna a raiz da arvore. */
	public Position<E> root() throws EmptyTreeException{
		return root;
	}

	/** Retorna o pai de um dado nodo. */
	public Position<E> parent(Position<E> position) throws  BoundaryViolationException{
		if (position.getParent() == null) {
			throw new BoundaryViolationException("Raíz não possui pai.");
		}
		return position.getParent();
	}

	/** Retorna uma colecao iteravel dos filhos de um dado nodo. */
	public Iterator<Position<E>> children(Position<E> position)  throws InvalidPositionException {
		if (position == null) {
			throw new InvalidPositionException("Posição não deve ser nula.");
		}
		return position.getChildren();
	}

	/** Retorna se um dado nodo e interno. */
	public boolean isInternal(Position<E> position) throws InvalidPositionException  {
		if (position == null) {
			throw new InvalidPositionException("Posição não deve ser nula.");
		}
		return position.getChildren().hasNext();
	}

	/** Retorna se um dado nodo e externo. */
	public boolean isExternal(Position<E> position)  throws InvalidPositionException {
		if (position == null) {
			throw new InvalidPositionException("Posição não deve ser nula.");
		}
		return !position.getChildren().hasNext();
	}

	/** Retorna se um dado nodo e a raiz da arvore. */
	public boolean isRoot(Position<E> position) throws InvalidPositionException   {
		return position.equals(root);
	}

	/** Retorna a quantidade de nodos da arvore. */
	public int size() {
		return size;
	}

	/** Retorna se a arvore esta vazia. */
	public boolean isEmpty() {
		return size == 0;
	}

	/** Retorna uma colecao iteravel dos nodos. */
	public Iterator<Position<E>> positions(){
		return root.getChildren();
	}

	/** Substitui o elemento armazenado em um dado nodo. */
	public E replace(Position<E> position, E element) throws InvalidPositionException {
		position.setElement(element);
		return element;
	}

	/**
	 * Adiciona a raiz em uma arvore vazia
	 * @param element
	 */
	public Position<E> addRoot(E element) throws NonEmptyTreeException {
		if (!isEmpty()) {
			throw new NonEmptyTreeException("A árvore não está vazia.");
		}
		size++;
		return root = new Position<E>(element);
	}

	/** Adicione um filho no nodo */
	public Position<E> addChild(Position<E> parent, E element) throws InvalidPositionException{
		if (element == null || parent == null) {
			throw new InvalidPositionException("Parâmetros inválidos");
		}
		Position<E> position = new Position<>(element);
		position.setParent(parent);
		parent.addChild(position);
		size++;
		return position;
	}

}
