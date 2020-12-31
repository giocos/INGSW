package factoryMethod;

import java.awt.Color;
import java.awt.Graphics;

public class Circle implements Shape {

	@Override
	public void printShape(Graphics g) {
		
		g.setColor(Color.RED);
		g.drawOval(200, 200, 200, 200);
	}
}
