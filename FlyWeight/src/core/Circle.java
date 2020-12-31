package core;

public class Circle implements Shape2D {

    private int x = -1;
    private int y = -1;
    private Color color; // extrinsinc state

    public Circle(Color color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public Color getColor() {
        return color;
    }
}
