/**
* Praktikum PM2, WS 2016/17
* Gruppe: Adem Dagdeviren (adem.dagdeviren@haw-hamburg.de)
* Aufgabenblatt 1 Aufgabe 1.3
*/
package aufgabenblatt1.a3;

public class ArrayListe<T extends Comparable<T>> {

	/**
	 * Anzahl der Elemente im Array
	 */
	private int anzahlElemente;

	/**
	 * Array fuer die elemente
	 */
	private Object[] elemente;

	public ArrayListe() {
		this.anzahlElemente = 0;
		this.elemente = new Object[1];
	}

	/**
	 * Fuegt einem Array ein neues Element hinzu, wenn noertig wird das Array um
	 * das zweifache vergroeßert
	 * 
	 * @param weiteresElement
	 */
	public void hinzufuegen(T weiteresElement) {
		if (anzahlElemente == elemente.length) {
			Object[] kopie = new Object[anzahlElemente * 2];
			System.arraycopy(elemente, 0, kopie, 0, anzahlElemente);
			elemente = kopie;
		}
		elemente[anzahlElemente] = weiteresElement;
		anzahlElemente++;
	}

	/**
	 * Das Element an der gewuenschten Stelle wird zurueck gegeben, sofern es
	 * vorhanden ist.
	 * 
	 * @param i
	 * @return element[i]
	 */
	@SuppressWarnings("unchecked")
	public T get(int i) {
		if (i >= 0 && i <= anzahlElemente) {
			return (T) elemente[i];
		}
		return null;
	}

	/**
	 * Das zu entfernende Element wird gesucht und entfernt.
	 * 
	 * @param zuentfernen
	 */
	public void entfernen(T zuentfernen) {
		for (int i = 0; i < anzahlElemente; i++) {
			if (elemente[i].equals(zuentfernen)) {
				entferneElementAnIndex(i);
				i--;
			}
		}
	}

	/**
	 * Element an der Stelle "i" wird entfernt.
	 * 
	 * @param i
	 */
	public void entferneElementAnIndex(int i) {
	if (i >= 0 && i < anzahlElemente) {
			
			for (int j = i; j < anzahlElemente-1; j++) {
				elemente[j] = elemente[j + 1];
			}
			anzahlElemente--;
			elemente[anzahlElemente] = null;
		}
	}

	public int getAnzahlElemente() {
		return anzahlElemente;
	}

	@Override
	public String toString() {
		String string = "";
		for (int i = 0; i < anzahlElemente; i++) {
			string += elemente[i].toString();
			string += ", ";
		}
		return string;
	}

	/**
	 * Das kleinste Element der Liste wird gesucht, indem man jedes einzelne
	 * Element ueberprueft ob es ein kleineres Element besitzt.
	 * 
	 * @return kleinstesElement
	 */
	@SuppressWarnings("unchecked")
	public T getKleinstesElement() {
		T kleinstesElement = null;
		if (anzahlElemente > 0) {
			kleinstesElement = (T) elemente[0];
			for (int i = 1; i < anzahlElemente; i++) {
				if (kleinstesElement.compareTo((T) elemente[i]) > 0) {
					kleinstesElement = (T) elemente[i];
				}
			}
		}
		return kleinstesElement;
	}
}
