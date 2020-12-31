package factoryMethodGUI;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import factoryMethod.ConcreteShapeFactory;
import factoryMethod.Shape;
import factoryMethod.ShapeFactory;

public class Window {

	public static void showLookAndFeel(List<Shape> s) {
		
		final ShapePanel panel = new ShapePanel(s);
		final JFrame frame = new JFrame("Factory Method Demo");
		frame.add(panel);
		frame.pack();
		frame.setLocationRelativeTo(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		List<Shape> shapes = new ArrayList<>();
		ShapeFactory factory = new ConcreteShapeFactory();
	
		shapes.add(factory.makeCircle());
		shapes.add(factory.makeSquare());
		shapes.add(factory.makeTriangle());
		showLookAndFeel(shapes);
	}
}
