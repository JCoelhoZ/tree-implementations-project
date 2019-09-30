package src.main.java.br.univille.treeimplementationsproject.dir;

public class File implements IContent {
	private final String fileName;
	private final Integer size;

	public File(String fileName, Integer size) {
		this.fileName = fileName;
		this.size = size;
	}

	@Override
	public String getName() {
		return fileName;
	}

	@Override
	public Integer getSize() {
		return size;
	}

	@Override
	public void printContent() {
		System.out.println(this.getName());
	}
}
