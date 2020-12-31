package factoryMethod;

import java.awt.Color;
import java.awt.Graphics;

public class Square implements Shape {

	@Override
	public void printShape(Graphics g) {
		
		g.setColor(Color.BLUE);
		g.drawRect(200, 200, 200, 200);
	}
}
