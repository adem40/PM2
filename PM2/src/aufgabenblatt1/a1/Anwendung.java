package aufgabenblatt1.a1;

import java.awt.List;

public class Anwendung {

	public static void main(String[] args) {
			
		Student student1 = new Student("Maik", "Muster", 12345);
		student1.getListe().add(new Pruefungsleistung("Mathe", 9));
		student1.getListe().add(new Pruefungsleistung("Programmieren", 10));
		
		Student student2 = new Student("Stefan", "Muster", 88898);
		student1.getListe().add(new Pruefungsleistung("Mathe", 7));
		student1.getListe().add(new Pruefungsleistung("Programmieren", 11));
		
		Student student3 = new Student("Maik", "Mueller", 11458);
		student1.getListe().add(new Pruefungsleistung("Mathe", 6));
		student1.getListe().add(new Pruefungsleistung("Programmieren", 15));
		
		VergleichNachname vergleichNachname = new VergleichNachname();
		System.out.println(vergleichNachname.compare(student1, student2));
		System.out.println(vergleichNachname.compare(student1, student3));
		

	}

}
