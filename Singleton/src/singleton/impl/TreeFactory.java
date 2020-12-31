package singleton.impl;

import shape.*;
import shape.impl.ShapeTreeAT;
import shape.impl.ShapeTreeSlash;
import shape.impl.ShapeTreeStar;
import singleton.AbstractFactory;

public class TreeFactory extends AbstractFactory {
	
	@Override
	public ShapeAT makeShapeAT() {
		return new ShapeTreeAT();
	}
	
	@Override
	public ShapeStar makeShapeStar() {
		return new ShapeTreeStar();
	}

	@Override
	public ShapeSlash makeShapeSlash() {
		return new ShapeTreeSlash();
	}
}
