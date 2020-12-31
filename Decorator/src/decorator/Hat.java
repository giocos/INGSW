package decorator;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Hat implements Decorator {

	private Shape shape;
		
	public Hat(Shape shape) {
		this.shape = shape;
	}
	
	@Override
	public void draw(Graphics g, int x, int y) {
		
		try {
			shape.draw(g, x, y); 
			Image hat = ImageIO.read(new File("./images/hat.png")).getScaledInstance(
				200, 100, Image.SCALE_SMOOTH);
			g.drawImage(hat, x - 200 / 2, y - 185, hat.getWidth(null), hat.getHeight(null), null);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}