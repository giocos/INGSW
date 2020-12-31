package decorator;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Pumpkin implements Shape {
	
	@Override
	public void draw(Graphics g, int x, int y) {
		
		try {
		Image pumpkin = ImageIO.read(new File("images/pumpkin.png")).getScaledInstance(
			250, 200, Image.SCALE_SMOOTH);
		g.drawImage(pumpkin, x - 250 / 2, y - 145, pumpkin.getWidth(null), pumpkin.getHeight(null), null);
		
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
