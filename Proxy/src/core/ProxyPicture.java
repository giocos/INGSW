package core;

import java.awt.Image;

public class ProxyPicture implements Picture {

	private String path;
	private Picture picture;

	public ProxyPicture(String path) {
		this.path = path;
	}
	
	@Override
	public Image showImage() {
		if(picture == null) {
			picture = new RealPicture(path);
		}
		return picture.showImage();
	}
}
