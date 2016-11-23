package aufgabenblatt3;

/**
 * Klasse zur aktualiesierung der Gleise und Aufgaben.
 *
 */
public class Refresh {
	/**
	 * Gleis welches aktualiesiert werden soll.
	 */
	private int gleis;
	/**
	 * Aufgabe welche aktualisiert werden soll.
	 */
	private Lokfuehrer.Aufgabe aufgabe;

	public Refresh() {
		gleis = 0;
		aufgabe = Lokfuehrer.Aufgabe.EINFAHREN;
	}

	public void setGleis(int gleis) {
		this.gleis = gleis;
	}

	public void setAufgabe(Lokfuehrer.Aufgabe aufgabe) {
		this.aufgabe = aufgabe;
	}

	public int getGleis() {
		return gleis;
	}

	public Lokfuehrer.Aufgabe getAufgabe() {
		return aufgabe;
	}

}