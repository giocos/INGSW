package prototype;

import java.awt.Graphics;

public class Rectangle extends Shape {

	public Rectangle() {
		type = "Rectangle";
	}
	
	@Override
	public void draw(Graphics g, double w, double h) {
		g.fillRect((int) (w / 2 - PIXEL / 2), (int) (h / 2 - PIXEL / 4), PIXEL, PIXEL / 2);
	}
}
