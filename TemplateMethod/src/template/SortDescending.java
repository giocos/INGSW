package template;

public class SortDescending extends SortAlgorithm {

	@Override
	public void compare() {
	
		for(int i = 0; i < values.length; i++) {
			for(int j = i; j < values.length; j++) {
				
				if(values[i] < values[j]) {
					
					int tmp = values[j];
					values[j] = values[i];
					values[i] = tmp;
				}
			}
		}
	}
}
