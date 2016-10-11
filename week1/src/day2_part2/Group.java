package day2_part2;

import java.util.Arrays;

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
        if (contains(student) || studentCount == students.length || student == null) return false;

        students[studentCount] = student;
        studentCount++;
        return true;
    }

    public boolean deleteStudent(Student student) {
        if (students[0] == null) return false;
        int index = -1;
        for (int i = 0; i < studentCount; i++) {
            if (students[i].equals(student))
                index = i;
        }
        if (index >= 0) {
            for (int i = index; i < studentCount - 1; i++) {
                students[i] = students[i + 1];
            }
            System.arraycopy(students, 0, students, 0, students.length - 1);
            studentCount--;
            return true;
        }
        return false;
    }

    public boolean equals(Group gr) {
        if (this.getName().equals(gr.getName())) return true;
        else return false;
    }

    public boolean contains(Student student) {
        if (student != null && students[0] != null) {
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
