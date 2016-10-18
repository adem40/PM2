package aufgabenblatt1.a3;

/**
 * Praktikum PM2, WS 2016 
 * Adem Dagdeviren 
 * Aufgabe: Aufgabenblatt 1, Aufgabe 1.3
 */
public class ErsteElementNummer {
	
	/**
	 * Prueft ob das erste Element einer Liste eine Zahl ist.
	 * @param liste
	 * @return
	 */
	public static boolean ersteElementNummer(ArrayListe<?> liste){
		if (liste.get(0)!= null && liste.get(0) instanceof Number) {
			return true;
		}
		return false;
	}
}
