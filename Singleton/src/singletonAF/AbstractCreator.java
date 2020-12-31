package singletonAF;

import shapeAF.ShapeAT;
import shapeAF.ShapeSlash;
import shapeAF.ShapeStar;

public abstract class AbstractCreator {

	private static AbstractCreator creator = null;
	
	protected AbstractCreator() {
		System.out.println("Creator's Singleton instance");
	}
	
	public static AbstractCreator instance() {
		
		if(creator == null)
			throw new RuntimeException("Null Pointer Exception, Invoke getConcreteInstance(type)");
		else 
			return creator;
	}
	
	public static AbstractCreator getConcreteCreator(String type) {
		
		if(creator == null) {
			
			if(type.equals("Tree")) {
				return creator = new ConcreteCreatorTree();
			} 
			else
			if(type.equals("Star")) {
				return creator = new ConcreteCreatorStar();
			}
		}
		throw new RuntimeException("Instance already created");
	}
	
	public abstract ShapeStar makeShapeStar();
	public abstract ShapeAT makeShapeAT();
	public abstract ShapeSlash makeShapeSlash();
}
