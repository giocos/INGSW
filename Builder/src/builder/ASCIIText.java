package builder;

import java.util.ArrayList;
import java.util.List;

public class ASCIIText {

	private byte[] character;
	private byte[] color;
	private byte[] size;
	private List<String> values = new ArrayList<>();
	
	public byte[] getCharacter() {
		return character;
	}
	
	public void setCharacter(byte[] character) {
		this.character = character;
	}
	
	public byte[] getColor() {
		return color;
	}
	
	public void setColor(byte[] color) {
		this.color = color;
	}
	
	public byte[] getSize() {
		return size;
	}
	
	public void setSize(byte[] size) {
		this.size = size;
	}
	
	public List<String> getValues() {
		return values;
	}
}
