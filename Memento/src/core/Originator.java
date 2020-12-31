package core;

import java.awt.Point;

public class Originator {

	private Point point;
	
	public void setState(Point point) {
		this.point = point;
	}
	
	public Shape save() {
		return new Shape(point);
	}
	
	public void restore(Shape m) {
		point = m.getState();
	}
	
	public Point getPoint() {
		return point;
	}
}
