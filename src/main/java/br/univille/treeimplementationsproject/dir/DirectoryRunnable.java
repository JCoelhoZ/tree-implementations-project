package src.main.java.br.univille.treeimplementationsproject.dir;

public class DirectoryRunnable {
	public static void main(String[] args){
		Directory dir = new Directory("C:");

		Directory downloadsDir = new Directory("downloads");
		downloadsDir.addContent(new File("java.exe", 256));
		downloadsDir.addContent(new File("artigo.pdf", 64));
		downloadsDir.addContent(new File("mysql-driver-jdbc.jar", 512));

		Directory eclipseDir = new Directory("eclipse");
		Directory androidSDKDir = new Directory("AndroidSDK");

		dir.addContent(downloadsDir);
		dir.addContent(eclipseDir);
		dir.addContent(androidSDKDir);
		dir.addContent(new File("tcc.doc", 256));
		dir.addContent(new File("Gimp 2.exe", 256));

		dir.printContent();
	}
}
