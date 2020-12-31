package visitor;

public class CalculateSize implements Visitor {

	private long count = 0;
	
	@Override
	public void visitFile(File f) {
		count += f.getSize();
	}

	@Override
	public void visitFolder(Folder f) {
		count += f.getSize();	
	}
	
	public Long getSize() {
		return count;
	}
}
