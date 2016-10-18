/**
* Praktikum PM2, WS 2016/17
* Gruppe: Adem Dagdeviren (adem.dagdeviren@haw-hamburg.de)
* Aufgabenblatt 1 Aufgabe 1.2
*/
package aufgabenblatt1.a2;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.TransformerException;

import org.junit.Test;

public class testXml {

	@Test
	public void testSensorID() {
		List<Messungen> messung = new ArrayList<Messungen>();
		messung.add(new Messungen(20,LocalDateTime.now()));
		messung.add(new Messungen(22,LocalDateTime.now()));
		messung.add(new Messungen(24,LocalDateTime.now()));
		Sensor sensor = new Sensor("12345", messung);
		
		try {
			XmlSchreiber schreiber = new XmlSchreiber("C:/Users/Ad/Desktop/SensorTest/NeueXML.xml", sensor);
		} catch (TransformerException e) {
			e.printStackTrace();
		}

		XmlLeser leser = new XmlLeser("C:/Users/Ad/Desktop/SensorTest/NeueXML.xml");
		Sensor gelesenerSensor = leser.sensorAuslesen();
		String gelesenerID = gelesenerSensor.getId();
		String erwarteterID = sensor.getId();
		assertEquals(erwarteterID, gelesenerID);
		
	}
}
