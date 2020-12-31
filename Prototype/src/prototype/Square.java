package prototype;

import java.awt.Graphics;

public class Square extends Shape {

	public Square() {
		type = "Square";
	}
	
	@Override
	public void draw(Graphics g, double w, double h) {
		g.fillRect((int) (w / 2 - PIXEL / 2), (int) (h / 2 - PIXEL / 2), PIXEL, PIXEL);
	}
}
