package prototype;

import java.awt.Graphics;
import java.awt.Polygon;

public class Hexagon extends Shape {

	private final int SIDES = 6;
	
	public Hexagon() {
		type = "Hexagon";
	}
	
	@Override
	public void draw(Graphics g, double w, double h) {
		g.fillPolygon(getHexagon((int) w / 2, (int) h / 2, PIXEL / 2));
	}
	
    private Polygon getHexagon(int x, int y, int h) {
        Polygon hexagon = new Polygon();
        for(int i = 0; i < SIDES; i++) {
	        	
           double a = Math.PI / 3.0 * i;
           hexagon.addPoint((int)(Math.round(x + Math.sin(a) * h)), (int)(Math.round(y + Math.cos(a) * h)));
        }
        return hexagon;
    }
}
