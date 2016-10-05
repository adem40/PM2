package aufgabenblatt1.a2;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlSchreiber {
	

	
	public XmlSchreiber(String filepath, Sensor sensor) throws TransformerException {
		
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		docFactory.setValidating(true);


		DocumentBuilder docBuilder = null;
		try {
			docBuilder = docFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("Sensor");
		doc.appendChild(rootElement);
		rootElement.setAttribute("ID", sensor.getId());
		for(int i = 0; i < sensor.getMessungen().size(); i++ ){
			Element neuemessung = doc.createElement("Messung");
			rootElement.appendChild(neuemessung);
			neuemessung.setAttribute("wert",Double.toString(sensor.getMessungen().get(i).getWert()));
			neuemessung.setAttribute("zeitstempel", sensor.getMessungen().get(i).getZeitstempel().toString());
		}
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("Z:/win7/pm2_local/PM2/bin/aufgabenblatt1/a2/NeueXML.xml"));
		transformer.transform(source, result);
	}
	
	
	
	public List<Messungen> messungen(){
		List<Messungen> messung = new ArrayList<Messungen>();
		messung.add(new Messungen(20,LocalDateTime.now()));
		messung.add(new Messungen(22,LocalDateTime.now()));
		messung.add(new Messungen(24,LocalDateTime.now()));
		return messung;
	
	}
	
	
	public static void main(String[] args) {
		List<Messungen> messung = new ArrayList<Messungen>();
		messung.add(new Messungen(20,LocalDateTime.now()));
		messung.add(new Messungen(22,LocalDateTime.now()));
		messung.add(new Messungen(24,LocalDateTime.now()));
		Sensor sensor = new Sensor("12345", messung);
		try {
			XmlSchreiber schreiber = new XmlSchreiber("Z:/win7/pm2_local/PM2/bin/aufgabenblatt1/a2/NeueXML.xml", sensor);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		
	}
}
