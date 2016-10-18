/**
* Praktikum PM2, WS 2016/17
* Gruppe: Adem Dagdeviren (adem.dagdeviren@haw-hamburg.de)
* Aufgabenblatt 1 Aufgabe 1.1
*/
package aufgabenblatt1.a1;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Testet die Reihenfolge von zwei Studenten nach ihrer Matrikelnummer
 *
 */
public class TestStudentCompareTo {

	@Test
	public void testCompareTo() {
		Student student1 = new Student("Maik", "Muster", 12345);
		student1.getListe().add(new Pruefungsleistung("Mathe", 9));
		student1.getListe().add(new Pruefungsleistung("Programmieren", 10));
		
		Student student2 = new Student("Stefan", "Muster", 18898);
		student1.getListe().add(new Pruefungsleistung("Mathe", 7));
		student1.getListe().add(new Pruefungsleistung("Programmieren", 11));
		
		int erwartung = -1;
		int berechnet = student1.compareTo(student2);
		assertEquals(erwartung, berechnet);

	}

}
