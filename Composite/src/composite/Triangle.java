package composite;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

public class Triangle extends Shape {

	public Triangle() {
		shapes = new ArrayList<>();
	}
	
	@Override
	public void draw(Graphics2D g, int x1, int y1, int x2, int y2) {
	
		g.setColor(Color.BLACK);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		shapes.get(0).draw(g, x1, y1, x2, y2);
		shapes.get(1).draw(g, x1, y1, x2 - 200, y2 - 200);
		shapes.get(2).draw(g, x1 + 400, y1, x2 - 200, y2 - 200);
	}
	
	@Override
	public void add(Shape s) {
		shapes.add(s);
	}
	
	@Override
	public void remove(int i) {
		shapes.remove(i);
	}
	
	@Override
	public Shape get(int i) {
		return shapes.get(i);
	}
}
