package core;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class RealPicture implements Picture {

	private static final int WIDTH = 1920;
	private static final int HEIGHT = 1240;

	private Image image;
	
	public RealPicture(String path) {
		loadImage(path);
	}
	
	private void loadImage(String path) {
		try {			
			image = ImageIO.read(new File(path)).getScaledInstance(WIDTH, HEIGHT, java.awt.Image.SCALE_SMOOTH);
		} catch(final IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Image showImage() {
		return image;
	}
}
