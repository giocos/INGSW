package prototype;

import java.awt.Graphics;

public class Circle extends Shape {

	public Circle() {
		type = "Circle";
	}
	
	@Override
	public void draw(Graphics g, double w, double h) {
		g.fillOval((int) (w / 2 - PIXEL / 2), (int) (h / 2 - PIXEL / 2), PIXEL, PIXEL);
	}
}
