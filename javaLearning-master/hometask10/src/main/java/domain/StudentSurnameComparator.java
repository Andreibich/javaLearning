package domain;

import java.util.Comparator;

public class StudentSurnameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getStudentSurname().compareTo(o2.getStudentSurname());
    }
}
