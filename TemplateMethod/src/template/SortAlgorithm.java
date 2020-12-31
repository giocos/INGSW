package template;

//import java.util.Random;

public abstract class SortAlgorithm {

	private final int DIM = 10;
	public int[] values = new int[DIM]; //TODO da rivedere
	
	public final void sort() {
		
//		initialize();
		compare();
//		returnArray();
	}
	
//	public void initialize() {
//		
//		for(int i = 0; i < DIM; i++) {
//			values[i] = new Random().nextInt(100);
//		}
//	}
	
	public abstract void compare();
	
//	public int[] returnArray() {
//		return values;
//	}
}
