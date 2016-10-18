/**
* Praktikum PM2, WS 2016/17
* Gruppe: Adem Dagdeviren (adem.dagdeviren@haw-hamburg.de)
* Aufgabenblatt 1 Aufgabe 1.2
*/
package aufgabenblatt1.a2;

import java.util.List;


/**
 * Ein Sensor die eine Liste von Messungen beinhaltet
 *
 */
public class Sensor {
	
	
	/**
	 * ID des Sensors
	 */
	private String id;
	/**
	 * Liste von Messungen
	 */
	private List<Messungen> messungen;
	
	public Sensor(String id, List<Messungen> messungen) {
		this.id = id;
		this.messungen = messungen;
	}

	public String getId() {
		return id;
	}

	public List<Messungen> getMessungen() {
		return messungen;
	}
}
