package aufgabenblatt1.a2;

import java.time.LocalDateTime;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlSchreiber {
	

	
	public XmlSchreiber(String filepath) throws ParserConfigurationException {
		
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		docFactory.setValidating(true);


		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		Document document = docBuilder.newDocument();
		Element rootElement = document.createElement("Sensor");
		document.appendChild(rootElement);
		rootElement.setNodeValue("Messung");
		rootElement.setNodeValue("Messung");
		
		
		
		
		
		
	}
	
	
		public void setSensor(Sensor sensor) {
			
			
			
			
			
			
			
		
	}
}
