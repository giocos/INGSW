package templateGUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;

import template.SortAlgorithm;
import template.SortAscending;
import template.SortDescending;

public class Frame {

	public static void main(String[] args) {

		List<SortAlgorithm> s = new ArrayList<>();
		s.add(new SortAscending());
		s.add(new SortDescending());
		
		for(int i = 0; i < s.get(0).values.length; i++) {
			
			int r = new Random().nextInt(100);
			s.get(0).values[i] = r;
			s.get(1).values[i] = r;
		}
		
		Panel panel = new Panel(s);
		JFrame frame = new JFrame();
		frame.add(panel);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
