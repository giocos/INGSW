package factoryMethod;

public class ConcreteShapeFactory implements ShapeFactory {

	@Override
	public Shape makeCircle() {
		return new Circle();
	}
	
	@Override
	public Shape makeSquare() {
		return new Square();
	}
	
	@Override
	public Shape makeTriangle() {	
		return new Triangle();
	}
}
