package compositeGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JButton;
import javax.swing.JPanel;

import composite.Shape;

@SuppressWarnings("serial")
public class ShapePanel extends JPanel {

	private Shape[] s;
	private String name;
	private JButton[] buttons;
	private final int DIM = 200;
	
	public ShapePanel(Shape[] s) {
	
		this.setPreferredSize(new Dimension(600, 600));
		this.setBackground(Color.GRAY);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.s = s;
		name = "";
		init();
	}
	
	private void init() {
		
		final String[] names = new String[] {"Line", "Triangle", "Pyramid"};
		buttons = new JButton[s.length];
		
		for(int i = 0; i < buttons.length; i++) {
			
			final int j = i;
			buttons[i] = new JButton();
			buttons[i].setText(names[i]);
			buttons[i].setFocusPainted(false);
			buttons[i].addActionListener(e -> {
				
				name = buttons[j].getText();
				this.repaint();
			});
			this.add(buttons[i]);
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(!name.equals("")) {
			
			Graphics2D g2d = (Graphics2D) g;
			
			if(name.equals("Line")) {
				s[0].draw(g2d, (int) this.getPreferredSize().getWidth() / 2 - DIM,
						(int) this.getPreferredSize().getHeight() / 2, 
						(int) this.getPreferredSize().getWidth() / 2 + DIM,
						(int) this.getPreferredSize().getHeight() / 2);
			} 
			else
			if(name.equals("Triangle")) {
				s[1].draw(g2d, (int) this.getPreferredSize().getWidth() / 2 - DIM,
						(int) this.getPreferredSize().getHeight() / 2, 
						(int) this.getPreferredSize().getWidth() / 2 + DIM,
						(int) this.getPreferredSize().getHeight() / 2);	
			} 
			else
			if(name.equals("Pyramid")) {
				s[2].draw(g2d, (int) this.getPreferredSize().getWidth() / 2 - DIM,
						(int) this.getPreferredSize().getHeight() / 2, 
						(int) this.getPreferredSize().getWidth() / 2 + DIM,
						(int) this.getPreferredSize().getHeight() / 2);	
			}
		}
	}
}
