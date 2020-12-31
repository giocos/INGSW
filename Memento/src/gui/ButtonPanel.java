package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ButtonPanel extends JPanel {

	private String buttonClicked;
	private boolean first;
	
	public ButtonPanel() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setBackground(Color.GRAY);
		this.initButtons();
	}
	
	private void initButtons() {
		JButton[] buttons = new JButton[4];
		final String[] names = {"Circle", "Square", "Hexagon", "Info"};
		
		for(int i = 0; i < buttons.length; i++) {
			final int j = i;
			buttons[i] = new JButton(names[i]);
			buttons[i].setFocusPainted(false);
			buttons[i].addActionListener(e -> {
				
				buttonClicked = names[j];
				if(buttonClicked.equals("Info")) {
					JOptionPane.showMessageDialog(null,
							"Press Ctrl + z to undo\nPress Ctrl + r to redo");
				}
				else {
					first = true;
				}
				getRootPane().transferFocus();
				getRootPane().repaint();
			});
			this.add(buttons[i]);
		}
	}
	
	public String getButtonClicked() {
		return buttonClicked;
	}

	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}
}
