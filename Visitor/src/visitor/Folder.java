package visitor;

public class Folder extends Node {

	public Folder(java.io.File file) {
		super(file);
	}
	
	public Folder(String path) {
		super(path);
	}
	
	public void add(Node n) {
		
		java.io.File f = new java.io.File(file.getPath() + "/" + n.file.getName());
		n.file.renameTo(f); //sposta il file esistente
	}

	@Override
	public void remove(Node n) {
		
		java.io.File[] listFiles = file.listFiles();//ctrl + 1
		
		for(java.io.File f : listFiles) {
			
			if(f.equals(n.file))
				f.delete();
		}
	}

	@Override
	public void accept(Visitor v) {
		
		v.visitFolder(this);
		
		java.io.File[] listFiles = file.listFiles();
		
		for(java.io.File f : listFiles) {
			
			if(f.isDirectory()) {
				
				Folder fold =  new Folder(f);
				fold.accept(v);
			} else {
				
				File f2 = new File(f);
				f2.accept(v);
			}
		}
	}
}
