package singleton;

import shape.ShapeAT;
import shape.ShapeSlash;
import shape.ShapeStar;
import singleton.impl.StarFactory;
import singleton.impl.TreeFactory;

public abstract class AbstractFactory {

	private static volatile AbstractFactory factory = null;
	
	protected AbstractFactory() {
		System.out.println("Factory Singleton instance");
	}
	
	public static AbstractFactory getInstance(String type) {
		if(factory == null) {
			synchronized (AbstractFactory.class) {
				if (type.equals("Tree")) {
					factory = new TreeFactory();
				} else if (type.equals("Star")) {
					factory = new StarFactory();
				}
				return factory;
			}
		}
		throw new IllegalStateException("Instance already created");
	}

	// abstract methods
	public abstract ShapeAT makeShapeAT();

	public abstract ShapeStar makeShapeStar();

	public abstract ShapeSlash makeShapeSlash();
}
