package gui;

import javax.swing.JFrame;
import core.Caretaker;
import core.Originator;

public class Window  {
	
	public static void main(String[] args) {
		
		final Caretaker caretaker = new Caretaker();
		final Originator originator = new Originator();
		
		final JFrame frame = new JFrame("Memento Demo");
		frame.add(new MainPanel(caretaker, originator));
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
