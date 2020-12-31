package gui;

import core.Color;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ImageFactory {

    private static final int TREE_WIDTH = 998;
    private static final int TREE_HEIGHT = 998;

    protected static final int BALL_WIDTH = 120;
    protected static final int BALL_HEIGHT = 80;

    protected static Image xmasTree;

    private static Image redBall;
    private static Image blueBall;
    private static Image greenBall;
    private static Image whiteBall;
    private static Image yellowBall;

    private static final Map<Color, Image> balls = new HashMap<>();

    static {
        try {
            xmasTree = ImageIO.read(new File("/home/giocos/Scrivania/Flyweight/resources/tree.png")).getScaledInstance(TREE_WIDTH, TREE_HEIGHT, Image.SCALE_SMOOTH);
            redBall = ImageIO.read(new File("/home/giocos/Scrivania/Flyweight/resources/red.png")).getScaledInstance(BALL_WIDTH, BALL_HEIGHT, Image.SCALE_SMOOTH);
            blueBall =  ImageIO.read(new File("/home/giocos/Scrivania/Flyweight/resources/blue.png")).getScaledInstance(BALL_WIDTH, BALL_HEIGHT, Image.SCALE_SMOOTH);
            greenBall = ImageIO.read(new File("/home/giocos/Scrivania/Flyweight/resources/green.png")).getScaledInstance(BALL_WIDTH, BALL_HEIGHT, Image.SCALE_SMOOTH);
            whiteBall = ImageIO.read(new File("/home/giocos/Scrivania/Flyweight/resources/white.png")).getScaledInstance(BALL_WIDTH, BALL_HEIGHT, Image.SCALE_SMOOTH);
            yellowBall = ImageIO.read(new File("/home/giocos/Scrivania/Flyweight/resources/yellow.png")).getScaledInstance(BALL_WIDTH, BALL_HEIGHT, Image.SCALE_SMOOTH);
            
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    static {
        balls.put(Color.RED, redBall);
        balls.put(Color.BLUE, blueBall);
        balls.put(Color.GREEN, greenBall);
        balls.put(Color.WHITE, whiteBall);
        balls.put(Color.YELLOW, yellowBall);
    }

    protected static Image getBall(String name) {
        return balls.get(Color.valueOf(name));
    }
}
