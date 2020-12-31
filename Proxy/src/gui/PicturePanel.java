package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import core.Picture;

@SuppressWarnings("serial")
public class PicturePanel extends JPanel implements ActionListener {

	private static final int WIDTH = 1920;//(int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private static final int HEIGHT = 1240;//(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

	private List<Picture> images;
	private JButton[] buttons;
	private int position = -1;
	private int imageCount = 0;
	
	public PicturePanel(List<Picture> images) {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.images = images;
		this.init();
	}
	
	private void init() {
		buttons = new JButton[2];
		final String[] names = {"Back", "Forward"};
		final Dimension dimension = new Dimension(100, 25);
		
		for(int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(names[i]);
			buttons[i].setPreferredSize(dimension);
			buttons[i].addActionListener(this);
			buttons[i].setBorderPainted(false);
			buttons[i].setFocusPainted(false);
			buttons[i].setOpaque(true);

			this.add(buttons[i]);
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(position >= 0) {
			Image img = images.get(position).showImage();
			g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(((JButton) e.getSource()).getText().equals("Forward")) {
			position = (position + 1) % images.size();
			if(imageCount < position) {
				imageCount = position;
			}
		} else {
			if(position - 1 >= 0) {
				position -= 1;
			} else if(imageCount == images.size() - 1) {
				position = images.size() - 1;
			}
		}
		repaint();
	}
}
