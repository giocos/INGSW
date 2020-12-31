package prototypeGUI;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import prototype.Generator;
import prototype.Shape;

@SuppressWarnings("serial")
public class Frame extends JFrame {

	public Frame(ShapePanel p) {
		
		this.setTitle("Frame Shape");
		this.add(p);
		this.pack();
		this.setLocationRelativeTo(this);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		Generator.loadMap();

		final List<Shape> shapes = new ArrayList<>();
		final String[] names = {"Circle", "Square", "Hexagon", "Rectangle"};

		for (String name : names) {
			shapes.add(Generator.getShape(name));
		}
		final ShapePanel panel = new ShapePanel(shapes);
		new Frame(panel);
	}
}
