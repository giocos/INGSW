package compositeGUI;

import javax.swing.JFrame;

import composite.Line;
import composite.Pyramid;
import composite.Shape;
import composite.Triangle;

@SuppressWarnings("serial")
public class ShapeFrame extends JFrame {

	public ShapeFrame(ShapePanel panel) {
	
		this.add(panel);
		this.pack();
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
	
		Shape line = new Line();
		Shape triangle = new Triangle();
		Shape pyramid = new Pyramid();
		
		for(int i = 0; i < 3; i++) {
			triangle.add(new Line());
		}
		for(int i = 0; i < 8; i++) {	
			pyramid.add(new Line());
		}
		Shape[] s = new Shape[] {line, triangle, pyramid};
		ShapePanel panel = new ShapePanel(s);
		new ShapeFrame(panel);
	}
}
