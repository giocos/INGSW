package composite;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Line extends Shape {

	@Override
	public void draw(Graphics2D g, int x1, int y1, int x2, int y2) {
		
		g.setColor(Color.BLACK);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawLine(x1, y1, x2, y2);
	}
}
