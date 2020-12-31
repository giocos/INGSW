package factoryMethod;

import java.awt.Color;
import java.awt.Graphics;

public class Triangle implements Shape {

	@Override
	public void printShape(Graphics g) {
		
		g.setColor(Color.DARK_GRAY);
		g.drawLine(200, 400, 300, 200);
		g.drawLine(200, 400, 400, 400);
		g.drawLine(400, 400, 300, 200);
	}	
}
