package builder;

import java.util.Arrays;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLReader {

	private int i = 0;
	private TextConverter converterBuilder;
	private String[] values = new String[] {"", "", ""};//A:RED:18,B:BLUE:16,C:GREEN:18
	
	public void setBuilder(TextConverter converterBuilder) {
		this.converterBuilder = converterBuilder;
	}
	
	public void convertToAscii() {
		
		converterBuilder.create();
		
		for(String it : values) {
			
			String[] tmp = it.split(":");

			converterBuilder.convertCharacter(tmp[0]);
			String s = Arrays.toString(converterBuilder.getAscii().getCharacter()) + ":";
			converterBuilder.convertColor(tmp[1]);
			s += Arrays.toString(converterBuilder.getAscii().getColor()) + ":";
			converterBuilder.convertSize(tmp[2]);
			s += Arrays.toString(converterBuilder.getAscii().getSize());
			converterBuilder.add(s);
		}
	}
	
	public void parseXML() {
		
		try {

			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			DefaultHandler handler = new DefaultHandler() {
		
			boolean id = false;
			boolean color = false;
			boolean size = false;
			
			@Override
			public void startElement(String uri, String localName, String qName, 
					Attributes attributes) throws SAXException {
				
				if(qName.equalsIgnoreCase("Id")) {
					id = true;
				}
				
				if(qName.equalsIgnoreCase("Color")) {
					color = true;
				}
				
				if(qName.equalsIgnoreCase("Size")) {
					size = true;
				}
			}
			
			@Override
			public void characters(char ch[], int start, int length) throws SAXException {
		
				String tmp = null;
				
				if(id) {
				
					tmp = new String(ch, start, length);
					id = false;
					values[i] += (tmp + ":");
				}
				
				if(color) {
					
					tmp = new String(ch, start, length);
					color = false;
					values[i] += (tmp + ":");
				}
				
				if(size) {
					
					tmp = new String(ch, start, length);
					size = false;
					values[i++] += tmp;
				}
			}
	     };
	       		saxParser.parse("file/file.xml", handler);

	     } catch(Exception e) {
	       e.printStackTrace();
	     }
	}
	
	public ASCIIText getAsciiText() {
		return converterBuilder.getAscii();
	}
}
