package composite;

import java.awt.Graphics2D;
import java.util.List;

public abstract class Shape {

	protected List<Shape> shapes;
	
	public abstract void draw(Graphics2D g, int x1, int y1, int x2, int y2);
	public void add(Shape s) {}
	public void remove(int i) {}
	public Shape get(int i) {return null;}
}
