package gui;

import javax.swing.*;

public class XMasDemo extends JFrame {

    public XMasDemo(final JPanel panel) {
        this.add(panel);
        this.pack();
        this.setFocusable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new XMasDemo(new TreePanel());
    }
}
