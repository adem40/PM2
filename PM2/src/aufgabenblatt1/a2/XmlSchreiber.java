package aufgabenblatt1.a2;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlSchreiber {
	

	
	public XmlSchreiber(String filepath) {
		
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		docFactory.setValidating(true);


		DocumentBuilder docBuilder = null;
		try {
			docBuilder = docFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		Document document = docBuilder.newDocument();
		Element rootElement = document.createElement("Sensor");
		document.appendChild(rootElement);
		rootElement.setAttribute("id", "Banane");
		
	}
	
	public Messungen messungen(){
		List<Messungen> messung = new ArrayList<Messungen>();
		messung.add(new Messungen(20,LocalDateTime.now()));
		messung.add(new Messungen(22,LocalDateTime.now()));
		messung.add(new Messungen(24,LocalDateTime.now()));
		return messung;
		
	
	}
	
	
		public void setSensor(Sensor sensor) {
			
			
			
			
			
			
			
		
	}
}
