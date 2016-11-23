
package aufgabenblatt3;

import java.util.Observable;

/**
 * Rangierbahnhof mit Gleisen in denen Zuege einfahren koennen.
 *
 */
public class Rangierbahnhof extends Observable {
	/**
	 * Die Gleise als array.
	 */
	private Zug[] gleise;
	/**
	 * Variable zum aktualieseren des Zustands.
	 */
	private Refresh change;

	public Rangierbahnhof(int anzahlGleise) {
		gleise = new Zug[anzahlGleise];
		change = new Refresh();
	}

	/**
	 * Synchronisierte Methode zum Einfahren eines Zuges sofern das Gleis frei
	 * ist. Neuer Zug wrd erstellt. Threads und Beobachter werden informiert.
	 * 
	 * @param gleis
	 */
	public synchronized void einfahren(int gleis) {
		while (gleise[gleis] != null) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		gleise[gleis] = new Zug();
		System.out.println("Zug ist auf Gleis " + (gleis + 1) + " eingefahren.");
		change.setGleis(gleis);
		change.setAufgabe(Lokfuehrer.Aufgabe.EINFAHREN);
		setChanged();
		notifyObservers(change);
		notify();
	}

	/**
	 * Synchronisierte Methode zum Ausfahren eines Zuges sofern das Gleis besetzt
	 * ist. Threads und Beobachter werden informiert.
	 * 
	 * @param gleis
	 */
	public synchronized void ausfahren(int gleis) {
		while (gleise[gleis] == null) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		gleise[gleis] = null;
		System.out.println("\t\tZug ist aus Gleis " + (gleis + 1) + " ausgefahren.");
		change.setGleis(gleis);
		change.setAufgabe(Lokfuehrer.Aufgabe.AUSFAHREN);
		setChanged();
		notifyObservers(change);
		notify();
	}

	public int getGleiseLaenge() {
		return gleise.length;
	}
}