package aufgabenblatt3;

public class Lokfuehrer extends Thread {
	
	static public enum Aufgabe{
		EINFAHREN,AUSFAHREN;
	}
	/**
	 * Aufgabe eines Lokfuehrers.
	 * Ausfahren oder Einfahren.
	 */
	private Aufgabe aufgabe;
	/**
	 *  Der Bahnhof auf dem der Lokfuehrer seine Aufgabe ausfuehrt.
	 */
	private Rangierbahnhof bahnhof;

	public Lokfuehrer(Aufgabe aufgabe, Rangierbahnhof bahnhof) {
		this.aufgabe = aufgabe;
		this.bahnhof = bahnhof;
	}

	/**
	 * Lokfuehrer faehrt ein oder aus, abhaengig von seiner Aufgabe.
	 */
	public void run() {
		switch (aufgabe) {
		case EINFAHREN:
			bahnhof.einfahren((int) (Math.random() * bahnhof.getGleiseLaenge()));
			break;
		case AUSFAHREN:
			bahnhof.ausfahren((int) (Math.random() * bahnhof.getGleiseLaenge()));
			break;
		}
	}

}