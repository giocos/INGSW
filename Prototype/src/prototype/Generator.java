package prototype;

import java.util.HashMap;

public class Generator {
	
	private static final HashMap<String, Shape> shapeMap = new HashMap<>();
	
	public static void loadMap() {
		Circle circle = new Circle();
		shapeMap.put(circle.type, circle);
		
		Square square = new Square();
		shapeMap.put(square.type, square);
		
		Rectangle rectangle = new Rectangle();
		shapeMap.put(rectangle.type, rectangle);
		
		Hexagon triangle = new Hexagon();
		shapeMap.put(triangle.type, triangle);
	}
	
	public static Shape getShape(String type) {
		if(shapeMap.containsKey(type)) {
			return shapeMap.get(type).clone();
		}
		throw new IllegalArgumentException("Type " + type + " not found");
	}	
}
