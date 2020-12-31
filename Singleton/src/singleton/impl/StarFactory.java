package singleton.impl;

import shape.*;
import shape.impl.ShapeStarAT;
import shape.impl.ShapeStarSlash;
import shape.impl.ShapeStarStar;
import singleton.AbstractFactory;

public class StarFactory extends AbstractFactory {

	@Override
	public ShapeAT makeShapeAT() {
		return new ShapeStarAT();
	}
	
	@Override
	public ShapeStar makeShapeStar() { return new ShapeStarStar(); }

	@Override
	public ShapeSlash makeShapeSlash() {
		return new ShapeStarSlash();
	}
}



