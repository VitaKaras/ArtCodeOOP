package day2_part2;

import java.util.ArrayList;

/**
 * Created by Vita on 08.10.2016.
 */
public class TestStudent {
    public static void main(String[] args) {

        Student student = new BudgetStudent("Nick", "Smith", 6, 560);
        Student student1 = new BudgetStudent("Nick", "North", 7, 560);
        Student student2 = new BudgetStudent("Bill", "Smith", 10, 780);
        Student student3 = new BudgetStudent("Liza", "Smith", 8, 780);

        Student student4 = new ContractStudent("Vita", "Smith", 8, 2);
        Student student5 = new ContractStudent("Yura", "Smith", 8, 7);
        Student student6 = new ContractStudent("Vanya", "Smith", 9, 4);

        Group group = new Group("1-A", 4);
        Group group2 = new Group("ACO16", 3);

        University artCode = new University("ArtCode", 5);

        group.addStudent(student);
        group.addStudent(student1);
        group.addStudent(student2);
        group.addStudent(student3);

        group2.addStudent(student4);
        group2.addStudent(student5);
        group2.addStudent(student6);

        artCode.addGroup(group);
        artCode.addGroup(group2);

        artCode.showGroups();
        artCode.showStudents();

        artCode.deleteGroup(group2);
        artCode.showGroups();

        System.out.println();

        artCode.addGroup(group2);
        artCode.showGroups();

        System.out.println();

        artCode.addGroup(group2);
        artCode.showGroups();

        System.out.println();

        group.showStudents();
        group.deleteStudent(student);

        System.out.println();

        group.showStudents();
        group.addStudent(student);

        System.out.println();

        group.showStudents();

        System.out.println();

        group.showStudents();
        group.deleteStudent(student2);

        System.out.println();

        group.showStudents();

        System.out.println("Sorting: ");

        group.sort(new NameComparator());
        group.showStudents();

        System.out.println();

        group.sort(new AverageMarkComparator());
        group.showStudents();

        System.out.println();

        ArrayList<Student> arrayList;
        arrayList = group.searchStudentByName(student);
        for(Student stud : arrayList) {
            System.out.println(stud.toString());
        }

    }
}
