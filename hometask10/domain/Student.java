package com.htp.hometask10.domain;

public class Student {
    private String studentSurname;
    private String studentName;
    private Integer studentAge;


    public Student() {
    }

    public Student(String studentSurname, String studentName, Integer studentAge) {
        this.studentSurname = studentSurname;
        this.studentName = studentName;
        this.studentAge = studentAge;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (studentSurname != null ? !studentSurname.equals(student.studentSurname) : student.studentSurname != null)
            return false;
        if (studentName != null ? !studentName.equals(student.studentName) : student.studentName != null) return false;
        return studentAge != null ? studentAge.equals(student.studentAge) : student.studentAge == null;
    }

    @Override
    public int hashCode() {
        int result = studentSurname != null ? studentSurname.hashCode() : 0;
        result = 31 * result + (studentName != null ? studentName.hashCode() : 0);
        result = 31 * result + (studentAge != null ? studentAge.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentSurname='" + studentSurname + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentAge=" + studentAge +
                '}';
    }
}
