package decoratorGUI;

import javax.swing.JFrame;
import decorator.Bat;
import decorator.Hat;
import decorator.Pumpkin;
import decorator.Shape;

@SuppressWarnings("serial")
public class Frame extends JFrame {

	public Frame(ShapePanel panel) {
	
		this.add(panel);
		this.pack();
		this.setResizable(false);
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		Shape pumpkin = new Bat(new Hat(new Pumpkin()));
		ShapePanel panel = new ShapePanel(pumpkin);
		new Frame(panel);
	}
}
