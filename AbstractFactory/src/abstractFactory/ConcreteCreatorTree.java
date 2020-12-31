package abstractFactory;

public class ConcreteCreatorTree extends AbstractCreator {
	
	@Override
	public ShapeStar makeShapeStar() {
		return new ShapeTreeStar();
	}

	@Override
	public ShapeAT makeShapeAT() {
		return new ShapeTreeAT();
	}

	@Override
	public ShapeSlash makeShapeSlash() {
		return new ShapeTreeSlash();
	}
}
