package visitor;
import java.io.File;

public abstract class Node {

	// adattatore ad oggetto
	protected java.io.File file;
	
	public Node(java.io.File file) {
		this.file = file;
	}
	
	public Node(String path) {
		file = new File(path);
		
		if(!file.exists())
			throw new RuntimeException();
	}
	
	public abstract void add(Node n);
	public abstract void remove(Node n);
	public String getName() {
		return file.getName();
	}
	public Long getSize() {
		return file.length();
	}
	public String getAbsolutePath() {
		return file.getAbsolutePath();
	}
	public abstract void accept(Visitor v);
}
