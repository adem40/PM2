/**
* Praktikum PM2, WS 2016/17
* Gruppe: Adem Dagdeviren (adem.dagdeviren@haw-hamburg.de)
* Aufgabenblatt 1 Aufgabe 1.1
*/
package aufgabenblatt1.a1;

import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse repraesentiert einen Studenten
 */
public class Student implements Comparable<Student> {

	/**
	 * Vorname des Studenten
	 */
	private String vorname;
	/**
	 * Nachname des Studenten
	 */
	private String nachname;
	/**
	 * Matrikelnummer des Studenten
	 */
	private int matrikelnummer;
	/**
	 * Liste mit Pruefungsleistungen des Studenten
	 */
	private List<Pruefungsleistung> liste;

	public Student(String vorname, String nachname, int matrikelnummer) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.matrikelnummer = matrikelnummer;
		liste = new ArrayList<Pruefungsleistung>();

	}

	@Override
	public int hashCode() {
		return matrikelnummer;

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (matrikelnummer != other.matrikelnummer)
			return false;
		return true;
	}

	/**
	 * Vergleich von zwei Studenten anhand ihrer Matrikelnummer
	 */
	@Override
	public int compareTo(Student andererStudent) {
		return Integer.compare(this.matrikelnummer, andererStudent.getMatrikelnummer());

	}

	public List<Pruefungsleistung> getListe() {
		return liste;
	}

	public String getVorname() {
		return vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public int getMatrikelnummer() {
		return matrikelnummer;
	}
}
