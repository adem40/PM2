/**
* Praktikum PM2, WS 2016/17
* Gruppe: Adem Dagdeviren (adem.dagdeviren@haw-hamburg.de)
* Aufgabenblatt 1 Aufgabe 1.2
*/
package aufgabenblatt1.a2;

import java.time.LocalDateTime;


/**
 * Diese Klasse repraesentiert eine Messung
 *
 */
public class Messungen {

	
	/**
	 * Wert einer Messung
	 */
	private double wert;
	/**
	 * Zeitstempel fuer den gemessenen Wert
	 */
	private LocalDateTime zeitstempel;
	
	public Messungen(double wert, LocalDateTime zeitstempel) {
		this.wert = wert;
		this.zeitstempel = zeitstempel;
	}

	public double getWert() {
		return wert;
	}

	public LocalDateTime getZeitstempel() {
		return zeitstempel;
	}
	@Override
	public String toString() {
		return "" + wert;
	}
}
