package src.main.java.br.univille.treeimplementationsproject;

import java.util.Iterator;

public class TreeUtils {
	public static <E> int depth(Tree<E> T, Position<E> v) {
		if (T.isRoot(v)) {
			return 0;
		}
		return 1 + depth(T, v.getParent());
	}

	public static <E> int height(Tree<E> T, Position<E> v) {
		if (T.isExternal(v)) {
			return 0;
		}
		Iterator<Position<E>> children = v.getChildren();
		int height = 0;
		while (children.hasNext()) {
			height = Math.max(height, height(T, children.next()));
		}
		return 1 + height;
	}

	public static <E> String toStringPreOrder(Tree<E> T, Position<E> v) {
		StringBuilder sb = new StringBuilder();
		preOrder(T, v, sb);
		String string = sb.toString();
		return string.substring(0, string.lastIndexOf(", "));
	}

	public static <E> String toStringPostOrder(Tree<E> T, Position<E> v) {
		StringBuilder sb = new StringBuilder();
		postOrder(T, v, sb);
		String string = sb.toString();
		return string.substring(0, string.lastIndexOf(", "));
	}

	private static <E> void preOrder(Tree<E> T, Position<E> v, StringBuilder sb) {
		sb.append(v.getElement());
		sb.append(", ");

		Iterator<Position<E>> children = v.getChildren();
		while (children.hasNext()) {
			preOrder(T, children.next(), sb);
		}
	}

	private static <E> void postOrder(Tree<E> T, Position<E> v, StringBuilder sb) {
		Iterator<Position<E>> children = v.getChildren();
		while (children.hasNext()) {
			postOrder(T, children.next(), sb);
		}
		sb.append(v.getElement());
		sb.append(", ");
	}
}
