package day2_part2;

/**
 * Created by Vita on 08.10.2016.
 */
public class Student {

    private String name;
    private String surname;
    private double averageMark;

    public Student(String name, String surname, double averageMark) {
        this.name = name;
        this.surname = surname;
        this.averageMark = averageMark;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }

    public boolean equals(Student student) {
        if (this.getName().equals(student.getName()) && this.getSurname().equals(student.getSurname())) return true;
        else return false;
    }

    @Override
    public String toString() {
        return String.format("Student name - %s, surname - %s, averageMark - %.2f ", name, surname, averageMark);
    }
}
