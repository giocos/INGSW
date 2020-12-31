package cor;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;


class Client extends JFrame implements Runnable {

    /**
     *
     */
    private static final long serialVersionUID = -2743574149855089215L;
    private JPanel p;

    ImageIcon green, red, yellow, blue, empty;
    Image current;

    Chain chain;
    HashMap<String, ImageIcon> images;


    public Client() throws IOException {
        p = new JPanel();
        p.setPreferredSize(new Dimension(800, 700));
        p.setLayout(null);
        add(p);
        chain = new Blue();
        Chain redChain = new Red();
        Chain yellowChain = new Yellow();
        Chain greenChain = new Green();

        chain.linkNext(redChain);
        redChain.linkNext(yellowChain);
        yellowChain.linkNext(greenChain);
        greenChain.linkNext(null);

        images = new HashMap<>();

        blue = new ImageIcon(ImageIO.read(new FileInputStream("src/resources/blue.jpg")).getScaledInstance(565, 250, Image.SCALE_SMOOTH));
        green = new ImageIcon(ImageIO.read(new FileInputStream("src/resources/green.jpg")).getScaledInstance(565, 250, Image.SCALE_SMOOTH));
        red = new ImageIcon(ImageIO.read(new FileInputStream("src/resources/red.jpg")).getScaledInstance(565, 250, Image.SCALE_SMOOTH));
        yellow = new ImageIcon(ImageIO.read(new FileInputStream("src/resources/yellow.jpg")).getScaledInstance(565, 250, Image.SCALE_SMOOTH));
        empty = new ImageIcon(ImageIO.read(new FileInputStream("src/resources/empty.jpg")).getScaledInstance(565, 250, Image.SCALE_SMOOTH));

        images.put("RED", red);
        images.put("BLUE", blue);
        images.put("YELLOW", yellow);
        images.put("EMPTY", empty);
        images.put("GREEN", green);

        current = empty.getImage();

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        repaint();
    }

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 5; i++) {
                String value = chain.check(i);
                current = images.get(value).getImage();

                try {
                    Thread.sleep(1000);
                    repaint();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }


    @Override
    public void paint(Graphics g) {
        super.paintComponents(g);
        g.drawImage(current, 100, 100, 500, 500, this);
    }

    public static void main(String[] args) {
        try {
            Client m = new Client();
            m.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
