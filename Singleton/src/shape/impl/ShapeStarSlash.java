package shape.impl;

import shape.ShapeSlash;

public class ShapeStarSlash implements ShapeSlash {
	
	@Override
	public void printShape() {
	
		System.out.println("         /         ");
		System.out.println("        ///        ");
		System.out.println("       /////       ");
		System.out.println("  ///////////////  ");
		System.out.println("    ///////////    ");
		System.out.println("     /////////     ");
		System.out.println("    ///// /////    ");
		System.out.println("   ////     ////   ");
		System.out.println("  ///         ///  ");
	}
}
