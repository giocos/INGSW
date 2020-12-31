package gui;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;
import core.Caretaker;
import core.Originator;

@SuppressWarnings("serial")
public class MainPanel extends JPanel implements KeyListener {
	
	private static final int WIDTH = 800;
	private static final int HEIGHT = WIDTH;
	private static final int SHAPE_DIM = 120;
	
	private int posX;
	private int posY;
	private int lastState;
	private boolean correctPosition;
	private final Caretaker caretaker;
	private final Originator originator;
	// component + event listener
	private final ButtonPanel buttonPanel = new ButtonPanel();
	private final MouseInputAdapter listener = new MouseDragged();
	
	public MainPanel(Caretaker caretaker, Originator originator) {
		this.setBackground(Color.GRAY);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.requestFocusInWindow(true);
		this.addMouseMotionListener(listener);
		this.addMouseListener(listener);
		this.addKeyListener(this);
		this.setFocusable(true);
		this.add(buttonPanel);
		
		this.caretaker = caretaker;
		this.originator = originator;
		this.correctPosition = false;
	}
	
	private void setInitialState() {
		
		if(caretaker.getSize() > 0) {
			caretaker.clear();
		}
		// Initial position
		posX = WIDTH / 2 - SHAPE_DIM / 2;
		posY = HEIGHT / 2 - SHAPE_DIM / 2;
		
		originator.setState(new Point(posX, posY));
		caretaker.addMemento(originator.save());
		lastState = caretaker.getSize() - 1;
	}

	/**
	 * Mouse Input Listener
	 */
	private class MouseDragged extends MouseInputAdapter {
		@Override
		public void mouseDragged(MouseEvent e) {
			if((e.getX() >= 0 && e.getX() <= WIDTH - SHAPE_DIM)
					&& (e.getY() >= 50 && e.getY() <= HEIGHT - SHAPE_DIM))
			{
				posX = e.getX();
				posY = e.getY();
				correctPosition = true;
				repaint();
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if(correctPosition) {
				originator.setState(new Point(posX, posY));
				caretaker.addMemento(originator.save());
				lastState = caretaker.getSize() - 1;
				correctPosition = false;
			}
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		if(buttonPanel.getButtonClicked() != null) {
			if (buttonPanel.isFirst()) {
				setInitialState();
				buttonPanel.setFirst(false);
			}

			if(buttonPanel.getButtonClicked().equals("Circle")) {
				g.setColor(Color.BLUE);
				g.drawOval(posX, posY, SHAPE_DIM, SHAPE_DIM);
			} 
			else if(buttonPanel.getButtonClicked().equals("Square")) {
				g.setColor(Color.RED);
				g.drawRect(posX, posY, SHAPE_DIM, SHAPE_DIM);
			}
			else if(buttonPanel.getButtonClicked().equals("Hexagon")) {
				g.setColor(Color.YELLOW);
				g.drawPolygon(getHexagon());
			}
			else {
				g.drawRect(0, 0, this.getWidth(), this.getHeight()); //empty panel
			}
		}
	}

	private Polygon getHexagon() {
		final Polygon hexagon = new Polygon();
		for (int i = 0; i < 6; i++) {
			double a = Math.PI / 3.0 * i;
			hexagon.addPoint((int)(Math.round((posX + (posX / 6)) + (Math.sin(a) * SHAPE_DIM / 2))),
					(int)(Math.round((posY + (posY / 6))  + (Math.cos(a) * SHAPE_DIM / 2))));
		}
		return hexagon;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Point currentPoint = null;
		if(e.getKeyCode() == KeyEvent.VK_Z && e.isControlDown()) {// undo
			if(lastState > 0) {
				originator.restore(caretaker.getMemento(--lastState));
				currentPoint = originator.getPoint();
				posX = currentPoint.x;
				posY = currentPoint.y;
				repaint();		
			}

			if (lastState == 0) {
				setInitialState();
			}
		}
		else if(e.getKeyCode() == KeyEvent.VK_R && e.isControlDown()) {// redo
			if(lastState < caretaker.getSize() - 1) {
				originator.restore(caretaker.getMemento(++lastState));
				currentPoint = originator.getPoint();
				posX = currentPoint.x;
				posY = currentPoint.y;
				repaint();		
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}
}
