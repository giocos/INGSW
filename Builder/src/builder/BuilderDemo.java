package builder;

public class BuilderDemo {

	public static void main(String[] args) {
		
		XMLReader reader = new XMLReader();
		TextConverter asciiConverterBuilder = new ASCIIConverter();
		reader.setBuilder(asciiConverterBuilder);
		reader.parseXML();
		reader.convertToAscii();
		
		ASCIIText text = reader.getAsciiText();
		
		for(int i = 0; i < text.getValues().size(); i++) {
			
			String[] result = text.getValues().get(i).split(":");
			System.out.printf("%-7s %-7s%n", "CHAR: ", result[0]);
			System.out.printf("%-7s %-7s%n", "COLOR: ", result[1]);
			System.out.printf("%-7s %-7s%n", "SIZE: ", result[2]);
			System.out.println("--------------------");
		}
	}
}
