package prototype;

import java.awt.Graphics;

public abstract class Shape implements Cloneable {

	public static final int PIXEL = 250;

	public String type;
	
	public abstract void draw(Graphics g, double w, double h);
	
	@Override
	protected Shape clone() {
		try {
			return (Shape) super.clone();
		} catch(CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
}
