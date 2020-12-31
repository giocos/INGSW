package factoryMethodGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;

import factoryMethod.Shape;


@SuppressWarnings("serial")
public class ShapePanel extends JPanel {

	private final int WIDTH = 600;
	private final int HEIGHT = WIDTH;
	private boolean pressed;
	private int count;
	private List<JButton> buttons;
	private List<Shape> shapes;
	
	public ShapePanel(List<Shape> shapes) {
	
		this.setBackground(Color.DARK_GRAY);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.shapes = shapes;
		pressed = false;
		count = 0;
		initButtons();
	}
	
	private void initButtons() {
		
		buttons = new ArrayList<>();
		final String[] names = {"Circle", "Square", "Triangle"};
		
		for(int i = 0; i < names.length; i++) {
			
			final int j = i;
			buttons.add(new JButton(names[i]));
			buttons.get(i).addActionListener(event -> {
				
				pressed = true;
				count = j;
				repaint();
			});
			this.add(buttons.get(i));
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(pressed) {
			
			((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
					RenderingHints.VALUE_ANTIALIAS_ON);
			shapes.get(count).printShape(g);
		}
	}
}
