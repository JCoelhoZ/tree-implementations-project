package src.main.java.br.univille.treeimplementationsproject.dir;

import java.util.Iterator;

import src.Position;
import src.Tree;

public class Directory implements IContent {
	private final Integer defaultSize = 1;
	private final String dirName;
	private final Tree<IContent> content;

	public Directory(String dirName) {
		this.dirName = dirName;
		this.content = new Tree<>();
		this.content.addRoot(this);
	}

	public Tree<IContent> getContent() {
		return content;
	}

	public void addContent(IContent content) {
		this.content.addChild(this.content.root(), content);
	}

	@Override
	public String getName() {
		return dirName;
	}

	@Override
	public Integer getSize() {
		Integer size = defaultSize;
		Iterator<Position<IContent>> children = content.children(content.root());

		while (children.hasNext()) {
			Position<IContent> next = children.next();
			size += next.getElement().getSize();
		}

		return size;
	}

	public void printContent() {
		System.out.print(this.getName());
		Iterator<Position<IContent>> children = content.children(content.root());
		while (children.hasNext()) {
			System.out.println("|--- ");
			IContent content = children.next().getElement();
			content.printContent();
		}
	}
}
