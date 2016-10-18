/**
* Praktikum PM2, WS 2016/17
* Gruppe: Adem Dagdeviren (adem.dagdeviren@haw-hamburg.de)
* Aufgabenblatt 1 Aufgabe 1.1
*/
package aufgabenblatt1.a1;

import java.util.Comparator;

/**
 * Zwei Studenten werden nach ihrem Nachname verglichen
 */
public class VergleichNachname implements Comparator<Student> {

	@Override
	public int compare(Student student, Student andererStudent) {
		return student.getNachname().compareTo(andererStudent.getNachname());

	}

}
