/**
* Praktikum PM2, WS 2016/17
* Gruppe: Adem Dagdeviren (adem.dagdeviren@haw-hamburg.de)
* Aufgabenblatt 1 Aufgabe 1.1
*/
package aufgabenblatt1.a1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class testVergleicheVorname {
	
	@Test
	public void testGleicheVorname() {
		Student student1 = new Student("Maik", "Muster", 12345);
		student1.getListe().add(new Pruefungsleistung("Mathe", 9));
		student1.getListe().add(new Pruefungsleistung("Programmieren", 10));
		
		Student student2 = new Student("Maik", "Schulz", 88898);
		student1.getListe().add(new Pruefungsleistung("Mathe", 7));
		student1.getListe().add(new Pruefungsleistung("Programmieren", 11));
		
		VergleichVorname vergleichVorname = new VergleichVorname();
		int berechnet = vergleichVorname.compare(student1, student2);
		int erwartung = 0;
		assertEquals(erwartung, berechnet);
	}
	
	@Test
	public void testNichtGleicheVorname() {
		Student student1 = new Student("Maik", "Muster", 12345);
		student1.getListe().add(new Pruefungsleistung("Mathe", 9));
		student1.getListe().add(new Pruefungsleistung("Programmieren", 10));
		
		Student student2 = new Student("Stefan", "Perle", 88898);
		student1.getListe().add(new Pruefungsleistung("Mathe", 7));
		student1.getListe().add(new Pruefungsleistung("Programmieren", 11));
		
		VergleichVorname vergleichVorname = new VergleichVorname();
		int berechnet = vergleichVorname.compare(student1, student2);
		int erwartung = -6;
		assertEquals(erwartung, berechnet);
	}
}
