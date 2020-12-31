package decoratorGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import decorator.Shape;

@SuppressWarnings("serial")
public class ShapePanel extends JPanel {

	private Shape shape;
	
	public ShapePanel(Shape shape) {
		
		this.shape = shape;
		this.setPreferredSize(new Dimension(500, 500));
		this.setBackground(Color.decode("#d55e00"));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		shape.draw(g, (int) this.getPreferredSize().getWidth() / 2
				, (int) this.getPreferredSize().getHeight() / 2);
	}
}
