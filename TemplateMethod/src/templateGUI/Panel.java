package templateGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import template.SortAlgorithm;

@SuppressWarnings("serial")
public class Panel extends JPanel {

	private final int WIDTH = 500;
	private final int HEIGHT = 350;
	private final int DIM = 10;
	private int posY;
	private boolean[] sorted;
	
	private JLabel label;
	private JTextArea[] area;
	private List<SortAlgorithm> s;
	private final JButton[] buttons; 
	
	public Panel(List<SortAlgorithm> s) {
		
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBackground(Color.BLACK);
		this.setLayout(null);
		this.s = s;
		
		buttons = new JButton[] {new JButton(), new JButton()};
		area = new JTextArea[DIM];
		posY = 0;
		sorted = new boolean[] {false, false}; 
		setLabel();
		
		for(int i = 0; i < area.length; i++) {
			addUnsortedArray(i);
		}
		posY += 100;
		initButtons();
		
		area = new JTextArea[DIM];
		for(int i = 0; i < area.length; i++) {
			addSortedArray(i);
		}	
	}
	
	private void setLabel() {
		
		label = new JLabel("Sort Algorithm");
		label.setFont(new Font("Jokerman", Font.PLAIN, 40));
		label.setBackground(this.getBackground());
		label.setForeground(Color.RED);
		label.setBounds(WIDTH / 2 - 150, posY, 300, 50);
		posY += 100;
		this.add(label);
	}
	
	private void addUnsortedArray(int i) {
		
		area[i] = new JTextArea();
		area[i].setBorder(null);
		area[i].setLayout(new FlowLayout(FlowLayout.CENTER));
		area[i].setBounds((i * 50) + 15, posY, 30, 25);		
		area[i].add(new JLabel(String.valueOf(s.get(0).values[i])));
		this.add(area[i]);
	}
	
	private void addSortedArray(int i) {
		
		area[i] = new JTextArea();
		area[i].setBorder(null);
		area[i].setLayout(new FlowLayout(FlowLayout.CENTER));
		area[i].setBounds((i * 50) + 15, posY, 30, 25);
		area[i].add(new JLabel(""));
		this.add(area[i]);
	}
	
	private void initButtons() {
		
		final String[] text = {"Ascending" , "Descending"};
		
		for(int i = 0; i < buttons.length; i++) {
			
			final int j = i;
			buttons[i].setText(text[i]) ;
			buttons[i].setBounds((WIDTH / 2 - 145) + (i * 150), posY, 125, 25);
			buttons[i].addActionListener(e -> {
				
				if(!sorted[j]) {				
					
					s.get(j).sort();
					sorted[j] = true;
				}

				final int[] tmp = s.get(j).values;
				
				for(int k = 0; k < tmp.length; k++) {
					
					JLabel l = new JLabel(String.valueOf(tmp[k]));
					area[k].setText("\n");
					area[k].removeAll();
					area[k].add(l).revalidate();
				}
			});
			this.add(buttons[i]);
		}
		posY += 100;
	}
}
