package builder;

public abstract class TextConverter {

	private ASCIIText text;
	
	public void create() {
		text = new ASCIIText();
	}
	
	public ASCIIText getAscii() {
		return text;
	}
	
	public void add(String s) {}
	
	public abstract void convertCharacter(String s);
	
	public abstract void convertColor(String s);
	
	public abstract void convertSize(String s);
}
