package ua.edu.ucu;


import java.util.Objects;

class Student {

    private double GPA;
    private int year;
    private String name;
    private String surname;

    public Student(String name, String surname, double GPA, int year) {
        this.GPA = GPA;
        this.year = year;
        this.name = name;
        this.surname = surname;
    }

    public double getGPA() {
        return GPA;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Student{name=" + name + ", surname=" + surname
                + ", " + "GPA=" + GPA + ", year=" + year + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Student)) {
            return false;
        }
        Student student = (Student) o;
        return Double.compare(student.getGPA(), getGPA()) == 0
                && getYear() == student.getYear()
                && getName().equals(student.getName())
                && getSurname().equals(student.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGPA(), getYear(), getName(), getSurname());
    }
}
