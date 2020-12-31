package core;

import java.awt.Point;

public class Shape {
	
	private Point point;
	
	protected Shape(Point point) {
		this.point = point;
	}
	 
	protected Point getState() {
		return point;
	}
}
