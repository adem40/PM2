package aufgabenblatt1.a1;

import java.util.Comparator;

public class VergleichNachname implements Comparator<Student> {

	@Override
	public int compare(Student student, Student andererStudent) {
		
		return student.getNachname().compareTo(andererStudent.getNachname());
		
	}

}
