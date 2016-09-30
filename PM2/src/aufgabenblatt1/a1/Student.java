package aufgabenblatt1.a1;

import java.util.LinkedList;
import java.util.List;

public class Student implements Comparable<Student>{

	private String vorname;
	private String nachname;
	private int matrikelnummer;
	private List<Pruefungsleistung> liste;
	
	public Student(String vorname, String nachname, int matrikelnummer){
		this.vorname=vorname;
		this.nachname =nachname;
		this.matrikelnummer=matrikelnummer;
		liste = new LinkedList<Pruefungsleistung>();
		
	}

	

	

	@Override
	public int hashCode() {
		
		return matrikelnummer;
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (matrikelnummer != other.matrikelnummer)
			return false;
		return true;
	}





	@Override
	public int compareTo(Student andererStudent) {
		
		return Integer.compare(this.matrikelnummer, andererStudent.getMatrikelnummer());
		
	}
	
	
	public List<Pruefungsleistung> getListe() {
		return liste;
	}
	public String getVorname() {
		return vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public int getMatrikelnummer() {
		return matrikelnummer;
	}
}
