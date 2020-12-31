package decorator;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bat implements Decorator {

	private Shape shape;
	
	public Bat(Shape shape) {
		this.shape = shape;
	}
	
	@Override
	public void draw(Graphics g, int x, int y) {
		
		try {
			shape.draw(g, x, y); 
			
			for(int i = 0; i < 2; i++) {
				Image bat = ImageIO.read(new File("./images/bat.png")).getScaledInstance(
					150, 80, Image.SCALE_SMOOTH);
				g.drawImage(bat, x - (225 - (i * 300))  , y - 186 / 2, bat.getWidth(null), bat.getHeight(null), null);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
