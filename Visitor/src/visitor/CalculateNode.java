package visitor;

public class CalculateNode implements Visitor {

	private int count = 0;
	
	@Override
	public void visitFile(File f) {
		count ++;
	}

	@Override
	public void visitFolder(Folder f) {
		count ++;//per ogni file della cartella incremento il count
	}
	
	public Integer getCount() {
		return count;
	}
}
