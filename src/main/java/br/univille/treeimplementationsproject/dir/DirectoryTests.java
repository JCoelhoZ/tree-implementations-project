package src.main.java.br.univille.treeimplementationsproject.dir;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public class DirectoryTests {
	@Test
	public void shouldShowEmptyDirectorySize() {
		Directory dir = new Directory("Z:");
		MatcherAssert.assertThat(dir.getSize(), Matchers.equalTo(1));
	}

	@Test
	public void shouldShowNonEmptyDirectorySize() {
		Directory dir = new Directory("E:");

		Directory innerDir = new Directory("inner");
		innerDir.addContent(new File("god.exe", 1024));

		dir.addContent(new File("file1.txt", 256));
		dir.addContent(new File("ct-mysql.cba", 516));
		dir.addContent(innerDir);

		MatcherAssert.assertThat(dir.getSize(), Matchers.equalTo(1798));
	}
}
