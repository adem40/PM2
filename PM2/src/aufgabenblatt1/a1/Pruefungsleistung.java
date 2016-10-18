/**
* Praktikum PM2, WS 2016/17
* Gruppe: Adem Dagdeviren (adem.dagdeviren@haw-hamburg.de)
* Aufgabenblatt 1 Aufgabe 1.1
*/
package aufgabenblatt1.a1;


/**
 * Diese Klasse repraesentiert eine Liste von Pruefungsleistungen
 * die ein Student besitzen kann.
 */
public class Pruefungsleistung {

	
	/**
	 * Modulname der Pruefung
	 */
	private String modulname;
	
	/**
	 * Note der Pruefung
	 */
	private int note;
	
	public Pruefungsleistung(String modulname, int note) {
		this.modulname = modulname;
		this.note = note;
	}

	public String getModulname() {
		return modulname;
	}

	public int getNote() {
		return note;
	}
	
}
