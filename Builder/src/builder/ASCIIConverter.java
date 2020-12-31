package builder;

public class ASCIIConverter extends TextConverter {
	
	@Override
	public void convertCharacter(String s) {
		getAscii().setCharacter(s.getBytes());
	}

	@Override
	public void convertColor(String s) {
		getAscii().setColor(s.getBytes());
	}

	@Override
	public void convertSize(String s) {
		getAscii().setSize(s.getBytes());
	}

	@Override
	public void add(String s) {
		getAscii().getValues().add(s);
	}
}
