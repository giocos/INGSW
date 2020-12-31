import shape.ShapeAT;
import shape.ShapeSlash;
import shape.ShapeStar;
import singleton.AbstractFactory;

public class SingletonAFDemo {

	public static void main(String[] args) {
				
			final AbstractFactory tree = AbstractFactory.getInstance("Tree");
			final ShapeAT t1 = tree.makeShapeAT();
			final ShapeStar t2 = tree.makeShapeStar();
			final ShapeSlash t3 = tree.makeShapeSlash();
			
			System.out.println("Tree's Singleton Factory:");
			t1.printShape();
			System.out.println();
			t2.printShape();
			System.out.println();
			t3.printShape();

			final AbstractFactory star = AbstractFactory.getInstance("Star");
			/*final ShapeAT s1 = star.makeShapeAT();
			final ShapeStar s2 = star.makeShapeStar();
			final ShapeSlash s3 = star.makeShapeSlash();
			
			System.out.println("\nStar's Singleton Factory:");
			s1.printShape();
			System.out.println();
			s2.printShape();
			System.out.println();
			s3.printShape();*/
	}
}
