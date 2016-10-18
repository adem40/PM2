/**
* Praktikum PM2, WS 2016/17
* Gruppe: Adem Dagdeviren (adem.dagdeviren@haw-hamburg.de)
* Aufgabenblatt 1 Aufgabe 1.2
*/
package aufgabenblatt1.a2;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/**
 * Liest eine XML Datei aus und erstellt aus dem Inhalt einen Sensor Objekt.
 *
 */
public class XmlLeser {

	/**
	 * Das Dokument aus dem gelesen wird.
	 */
	public Document document;

	/**
	 * Liest die XML-Datei im "filepath" aus
	 * @param filepath
	 */
	public XmlLeser(String filepath) {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		//factory.setValidating(true);
		
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		try {
			document = builder.parse(new File(filepath));

		} catch (SAXException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Liest den Inhalt des Sensors aus und erstellt ein Sensor Objekt
	 * @return Sensor 
	 */
	public Sensor sensorAuslesen()  {
		//Lokale Variablen zum speichern der ausgelesenen Daten.
		List<Messungen> messung = new ArrayList<Messungen>();
		String id;
		String wertName;
		double wert;
		LocalDateTime zeitstempel;

		//Die ID des Sensors wird ermittelt
		Node node = document.getElementsByTagName("Sensor").item(0);
		Element element = (Element) node;
		id = element.getAttribute("ID");

		//Eine Liste der Messungen wird erstellt
		NodeList nodeList = element.getElementsByTagName("Messung");
		
		
		//Aus den Werten wird eine Messungsliste erstellt
		for (int i = 0; i < nodeList.getLength(); i++) {
			element = (Element) nodeList.item(i);
			wertName = element.getAttribute("wert");
			wertName = wertName.replace(',', '.');
			wert = Double.parseDouble(wertName);

			zeitstempel = LocalDateTime.parse(element.getAttribute("zeitstempel"));

			messung.add(new Messungen(wert, zeitstempel));

		}
		return new Sensor(id, messung);
	}

//	public static void main(String[] args) {
//
//		XmlLeser leser = new XmlLeser("C:/Users/Ad/Desktop/SensorTest/NeueXML.xml");
//		Sensor sensor = leser.sensorAuslesen();
//		System.out.println(sensor.getMessungen().get(0).getWert());
//		System.out.println(sensor.getMessungen().get(1).getWert());
//		System.out.println(sensor.getId());
//	}
}
