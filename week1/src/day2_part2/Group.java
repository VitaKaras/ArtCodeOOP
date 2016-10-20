package day2_part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Vita on 09.10.2016.
 */
public class Group {

    private String name;
    private Student[] students;
    private int studentCount;

    public Group(String name, int groupSize) {
        this.name = name;
        this.students = new Student[groupSize];
    }

    public int getStudentCount() {
        return studentCount;
    }

    public boolean addStudent(Student student) {
        if (studentCount == students.length || student == null || contains(student)) return false;

        students[studentCount++] = student;
        return true;
    }

    public boolean deleteStudent(Student student) {
        if (student == null) return false;

        for (int i = 0; i < studentCount; i++) {
            if (student.equals(students[i])) {
                System.arraycopy(students, i + 1, students, i, studentCount - i - 1);
                students[--studentCount] = null;
                return true;
            }
        }
        return false;

    }

    public ArrayList<Student> searchStudentByName(Student student){
        ArrayList <Student> arrayList = new ArrayList<>();
        for(int i=0; i<studentCount; i++){
            if(student.getName().equals(students[i].getName()))
                arrayList.add(students[i]);
        }
        return arrayList;
    }

    public void sort(Comparator <Student> comparator){
        for (int i = 0; i < studentCount - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < studentCount- i - 1; j++) {
                if (students[j].compareTo(students[j + 1]) > 0) {
                    Student tmp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = tmp;
                    swapped = true;
                }
            }

            if(!swapped)
                break;
        }
    }

    public boolean equals(Group gr) {
        if(gr == null) return false;

        if (this.getName().equals(gr.getName())) return true;
        else return false;
    }

    public boolean contains(Student student) {
        if (student != null) {
            for (int i = 0; i < studentCount; i++) {
                if (students[i].equals(student))
                    return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", students=" + Arrays.toString(students) +
                '}';
    }

    public String getName() {
        return name;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void showStudents() {
        for (int i = 0; i < studentCount; i++) {
            System.out.println(students[i]);
        }
    }
}
