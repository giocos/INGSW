package shapeAF;

import singletonAF.AbstractCreator;

public class SingletonAFDemo {

	public static void main(String[] args) {
				
			AbstractCreator tree = AbstractCreator.getConcreteCreator("Tree");
			ShapeAT t1 = tree.makeShapeAT();
			ShapeStar t2 = tree.makeShapeStar();
			ShapeSlash t3 = tree.makeShapeSlash();
			
			System.out.println("Tree's Singleton Factory:");
			t1.printShape();
			System.out.println();
			t2.printShape();
			System.out.println();
			t3.printShape();
			
			AbstractCreator star = AbstractCreator.getConcreteCreator("Star");
			ShapeAT s1 = star.makeShapeAT();
			ShapeStar s2 = star.makeShapeStar();
			ShapeSlash s3 = star.makeShapeSlash();
			
			System.out.println("\nStar's Singleton Factory:");
			s1.printShape();
			System.out.println();
			s2.printShape();
			System.out.println();
			s3.printShape();
//			
//			AbstractCreator tree2 = AbstractCreator.instance();
//			t1 = tree2.makeShapeAT();
//			t2 = tree2.makeShapeStar();
//			t3 = tree2.makeShapeSlash();
//			
//			t1.printShape();
//			System.out.println();
//			t2.printShape();
//			System.out.println();
//			t3.printShape();
	}
}
