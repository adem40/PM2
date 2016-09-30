package aufgabenblatt1.a1;

import java.util.Comparator;

public class VergleichVorname implements Comparator<Student> {

	@Override
	public int compare(Student student, Student andererStudent) {
		
		return student.getVorname().compareTo(andererStudent.getVorname());
		
	}

}


