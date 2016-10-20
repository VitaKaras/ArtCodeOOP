package day2_part2;

/**
 * Created by Vita on 08.10.2016.
 */
public class Student implements Comparable<Student>{

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

    @Override
    public int compareTo(Student student){
        if(this.getName().compareTo(student.getName())>0){
            return 1;
        } else if(this.getName().compareTo(student.getName())<0) {
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object object) {
        if(!(object instanceof Student) || object == null) return false;

        Student student = (Student)object;
        if (this.getName().equals(student.getName()) && this.getSurname().equals(student.getSurname())) return true;
        else return false;
    }

    @Override
    public String toString() {
        return String.format("Student name - %s, surname - %s, averageMark - %.2f ", name, surname, averageMark);
    }
}
