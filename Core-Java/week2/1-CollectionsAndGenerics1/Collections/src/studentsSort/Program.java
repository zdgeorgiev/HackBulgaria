package studentsSort;

import java.util.ArrayList;
import java.util.Collections;

public class Program {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>();

        students.add(new Student("Atanas", 6));
        students.add(new Student("Atanas", 5));
        students.add(new Student("Anastas", 6));
        students.add(new Student("Petur", 5));
        students.add(new Student("Mariq", 3));
        students.add(new Student("Stefan", 2));
        students.add(new Student("Boris", 5));

        Collections.sort(students);

        for (Student student : students) {
            System.out.println(student);
        }
    }
}
