package core;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {

	private List<Shape> mementos = new ArrayList<>();
	
	public void addMemento(Shape m) {
		mementos.add(m);
	}
	
	public Shape getMemento(int i) {
		return mementos.get(i);
	}
	
	public int getSize() {
		return mementos.size();
	}
	
	public void clear() {
		mementos.clear();
	}
}
