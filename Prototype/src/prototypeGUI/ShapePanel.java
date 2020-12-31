package prototypeGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import prototype.Shape;

@SuppressWarnings("serial")
public class ShapePanel extends JPanel implements MouseListener {

	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static final Color[] colors = {Color.BLUE, Color.RED, Color.CYAN, Color.GRAY};

	private final List<Shape> shapes;
	private List<JButton> buttons;
	private boolean pressed;
	private boolean clicked;
	private int countColor;
	private int position;
	
	public ShapePanel(List<Shape> shapes) {
	
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setBackground(Color.BLACK);
		this.addMouseListener(this);
		this.shapes = shapes;

		buttons = new ArrayList<>();
		pressed = false;
		clicked = false;
		countColor = 0;
		position = 0;

		this.initButtons();
	}
	
	private void initButtons() {
		for(int i = 0; i < shapes.size(); i++) {
			final int j = i;
			buttons.add(new JButton(shapes.get(i).type));
			buttons.get(i).addActionListener(e -> {
					pressed = true;
					clicked = false;
					countColor = 0;
					position = j;
					repaint();
			});
			this.add(buttons.get(i));
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.ORANGE);
		((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		if(pressed) {
			if(clicked) {
				g.setColor(colors[countColor]);
				countColor = (countColor + 1) % colors.length;
			}
			shapes.get(position).draw(g, this.getPreferredSize().getWidth(), this.getPreferredSize().getHeight());
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getX() >= 275 && e.getX() <= 525 && e.getY() >= 175 && e.getY() <= 425) {
			clicked = true;
			repaint();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
}
