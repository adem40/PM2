/**
* Praktikum PM2, WS 2016/17
* Gruppe: Adem Dagdeviren (adem.dagdeviren@haw-hamburg.de)
* Aufgabenblatt 1 Aufgabe 1.1
*/
package aufgabenblatt1.a1;

import static org.junit.Assert.*;

import org.junit.Test;

public class testVergleichNachname {
	
	@Test
	public void testGleicheNachname() {
		Student student1 = new Student("Maik", "Muster", 12345);
		student1.getListe().add(new Pruefungsleistung("Mathe", 9));
		student1.getListe().add(new Pruefungsleistung("Programmieren", 10));
		
		Student student2 = new Student("Stefan", "Muster", 88898);
		student1.getListe().add(new Pruefungsleistung("Mathe", 7));
		student1.getListe().add(new Pruefungsleistung("Programmieren", 11));
		
		VergleichNachname vergleichNachname = new VergleichNachname();
		int berechnet = vergleichNachname.compare(student1, student2);
		int erwartung = 0;
		assertEquals(erwartung, berechnet);
	}
	
	@Test
	public void testNichtGleicheNachname() {
		Student student1 = new Student("Maik", "Muster", 12345);
		student1.getListe().add(new Pruefungsleistung("Mathe", 9));
		student1.getListe().add(new Pruefungsleistung("Programmieren", 10));
		
		Student student2 = new Student("Stefan", "Perle", 88898);
		student1.getListe().add(new Pruefungsleistung("Mathe", 7));
		student1.getListe().add(new Pruefungsleistung("Programmieren", 11));
		
		VergleichNachname vergleichNachname = new VergleichNachname();
		int berechnet = vergleichNachname.compare(student1, student2);
		int erwartung = -3;
		assertEquals(erwartung, berechnet);
	}
}
