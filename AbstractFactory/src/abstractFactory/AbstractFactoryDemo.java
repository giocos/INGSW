package abstractFactory;

public class AbstractFactoryDemo {

	public static void main(String[] args) {
	
			AbstractCreator tree = new ConcreteCreatorTree();
			ShapeAT t1 = tree.makeShapeAT();
			ShapeStar t2 = tree.makeShapeStar();
			ShapeSlash t3 = tree.makeShapeSlash();
			
			System.out.println("Tree's Factory:");
			t1.printShape();
			System.out.println();
			t2.printShape();
			System.out.println();
			t3.printShape();
			
			AbstractCreator star = new ConcreteCreatorStar();
			ShapeAT s1 = star.makeShapeAT();
			ShapeStar s2 = star.makeShapeStar();
			ShapeSlash s3 = star.makeShapeSlash();
			
			System.out.println("\nStar's Factory:");
			s1.printShape();
			System.out.println();
			s2.printShape();
			System.out.println();
			s3.printShape();
	}
}
