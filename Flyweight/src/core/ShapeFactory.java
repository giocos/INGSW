package core;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {

    private static final Map<Color, Shape2D> shapes = new HashMap<>();

    public static Shape2D getBall(final Color color) {
        Shape2D ball = shapes.get(color);
        if (ball == null) {
            ball = new Circle(color);
            shapes.put(color, ball);
        }
        return ball;
    }

    public static Map<Color, Shape2D> getShapes() {
        return shapes;
    }
}
