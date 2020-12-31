package visitor;

/**
 * pattern utilizzati: Composite, Adapter e Visitor
 */
public class VisitorDemo {

	public static void main(String[] args) {
		
		Folder folder = new Folder("C:/Users/Giò/Desktop/Università/INGSW");
		CalculateNode v = new CalculateNode();
		CalculateSize c = new CalculateSize();
		folder.accept(v);
		folder.accept(c);
		System.out.println("Number of files: " + v.getCount());
		System.out.println("Totale size: " + c.getSize() + " byte");
	}
}
