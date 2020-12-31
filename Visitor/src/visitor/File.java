package visitor;

public class File extends Node {

	public File(java.io.File file) {
		super(file);
	}
	
	public File(String path) {
		super(path);
	}

	@Override
	public void add(Node n) {
		throw new RuntimeException();
	}

	@Override
	public void remove(Node n) {
		throw new RuntimeException();
	}

	@Override
	public void accept(Visitor v) {
		v.visitFile(this);
	}
}
