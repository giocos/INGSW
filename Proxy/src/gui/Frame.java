package gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import core.Picture;
import core.ProxyPicture;

public class Frame {

	public static final int DIM = 6;
	
	public static void showLookAndFeel(PicturePanel panel) {
		final JFrame frame = new JFrame("Proxy Demo");
		frame.add(panel);
		frame.pack();
		frame.setLocationRelativeTo(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {

		final List<Picture> proxyImages = new ArrayList<>();
		for(int i = 1; i <= DIM; i++) {
			proxyImages.add(new ProxyPicture("./images/image" + i + ".jpg"));
		}
		final PicturePanel panel = new PicturePanel(proxyImages);
		Frame.showLookAndFeel(panel);
	}
}
