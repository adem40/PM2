package aufgabenblatt1.a3;

import java.util.Arrays;

public class ArrayListe<T> {

	private int anzahlElemente;
	private Object[] elemente;

	public ArrayListe() {
		this.anzahlElemente = 0;
		this.elemente = new Object[2];
	}

	public void hinzufuegen(T weiteresElement) {
		if (anzahlElemente == elemente.length) {
			Object[] kopie = new Object[anzahlElemente * 2];
			System.arraycopy(elemente, 0, kopie, 0, anzahlElemente);
			elemente = kopie;
		}
		elemente[anzahlElemente] = weiteresElement;
	}


	public T get(int i) {
		return (T) elemente[i];
	}

	public void entfernen(T a) {
		
	}

	public void entferneElementAnIndex(int i) {
		elemente[i]= null;
	}

	public int getAnzahlElemente() {
		return anzahlElemente;
	}

	@Override
	public String toString() {
		return "ArrayListe [anzahlElemente=" + anzahlElemente + ", elemente=" + Arrays.toString(elemente) + "]";
	}

	public T getKleinstesElement() {
		return null;
	}
}
