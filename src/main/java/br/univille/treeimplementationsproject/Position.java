package src.main.java.br.univille.treeimplementationsproject;

import java.util.Collection;
import java.util.Iterator;

public class Position<E> {

	private E element;
	private Position<E> parent;
	private Collection<Position<E>> children;

	public Position() {
		this(null,null);
	}

	public Position(E element) {
		this(element,null);
	}

	public Position(E element, Position<E> parent) {
		setElement(element);
		setParent(parent);
	}

	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

	public Position<E> getParent() {
		return parent;
	}

	public void setParent(Position<E> parent) {
		this.parent = parent;
	}

	public void addChild(Position<E> child) {
		this.children.add(child);
	}

	public void addChild(E element) {
		this.addChild(new Position<>(element, this));
	}

	public Position<E> removeChild(Position<E> child){
		this.children.remove(child);
		return child;
	}

	public Iterator<Position<E>> getChildren(){
		return this.children.iterator();
	}

	public int size() {
		return this.children.size();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((children == null) ? 0 : children.hashCode());
		result = prime * result + ((element == null) ? 0 : element.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (children == null) {
			if (other.children != null)
				return false;
		} else if (!children.equals(other.children))
			return false;
		if (element == null) {
			if (other.element != null)
				return false;
		} else if (!element.equals(other.element))
			return false;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		return true;
	}

}
