package abstractFactory;

public class ConcreteCreatorStar extends AbstractCreator {
	
	@Override
	public ShapeStar makeShapeStar() {
		return new ShapeStarStar();
	}

	@Override
	public ShapeAT makeShapeAT() {
		return new ShapeStarAT();
	}
	
	@Override
	public ShapeSlash makeShapeSlash() {
		return new ShapeStarSlash();
	}
}



