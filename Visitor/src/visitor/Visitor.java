package visitor;

public interface Visitor {

	public void visitFile(File f);
	public void visitFolder(Folder f);
}
