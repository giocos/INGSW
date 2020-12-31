package gui;

import core.Circle;
import core.Color;
import core.Shape2D;
import core.ShapeFactory;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;

import java.util.HashMap;
import java.util.Map;

public class TreePanel extends JPanel {

    private static final int DIM = 5;
    private static final Color[] colors = Color.values();

    private final Map<Color, JLabel> shapes = new HashMap<>();
    private final MouseInputAdapter listener = new DragAndDropListener(); // listener

    public TreePanel() {
        this.setPreferredSize(new Dimension(1920, 1024));
        this.setBackground(java.awt.Color.decode("#654321"));
        this.addButtons();
    }

    private void addButtons() {
        for (int i = 0; i < DIM; i++) {
            final String name = colors[i].name();
            final JButton button = new JButton(name);
            button.setPreferredSize(new Dimension(100, 30));
            button.addActionListener(e -> {
                JButton b = (JButton) e.getSource();
                final Color color = Color.valueOf(b.getText());
                final Circle circle = (Circle) ShapeFactory.getBall(color);
                circle.setX(0);
                circle.setY(0);

                buildLabel(circle);
            });
            this.add(button);
        }
    }

    private void buildLabel(Circle circle) {
        if (shapes.containsKey(circle.getColor())) {
            return;
        }
        final JLabel label = new JLabel(circle.getColor().name());
        label.setLocation(circle.getX(), circle.getY());
        label.setPreferredSize(new Dimension(ImageFactory.BALL_WIDTH, ImageFactory.BALL_HEIGHT));
        label.setIcon(new ImageIcon(ImageFactory.getBall(circle.getColor().name())));
        label.setBorder(null);
        label.setOpaque(false);
        label.setBackground(null);
        label.addMouseListener(listener);
        label.addMouseMotionListener(listener);

        this.add(label);
        this.revalidate();

        shapes.put(circle.getColor(), label);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        final int treeWidth = ImageFactory.xmasTree.getWidth(this);
        g.drawImage(ImageFactory.xmasTree, (this.getPreferredSize().width / 2) - (treeWidth / 2), 0, this);

        /*if (shapes != null && shapes.size() > 0) {
            for (final Shape2D shape : shapes.values()) {
                final Image image = ImageFactory.getBall(shape.getColor().name());
                g.drawImage(image, shape.getX(), shape.getY(), this);
            }
        }*/
       
    }

    /**
     *
     */
    private class DragAndDropListener extends MouseInputAdapter {

        @Override
        public void mouseDragged(MouseEvent e) {
            super.mouseDragged(e);

            final int currX = e.getX();
            final int currY = e.getY();
            final JLabel label = (JLabel) e.getSource();

            label.setLocation(Math.abs(currX), Math.abs(currY));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e);

            final int lastX = e.getX();
            final int lastY = e.getY();
            final JLabel label = (JLabel) e.getSource();

            final Color color = Color.valueOf(label.getText());
            final Circle circle = (Circle) ShapeFactory.getShapes().get(color);
            if (lastX >= 0 && lastX <= (getPreferredSize().width - ImageFactory.BALL_WIDTH)) {
                circle.setX(lastX);
            }
            if (lastY >= 0 && lastY <= (getPreferredSize().height - ImageFactory.BALL_HEIGHT)) {
                circle.setY(lastY);
            }
        }
    }
}
