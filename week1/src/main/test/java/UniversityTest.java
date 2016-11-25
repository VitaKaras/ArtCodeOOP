package main.test.java;

import main.java.day2_part2.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Vita on 09.11.2016.
 */
public class UniversityTest {

    protected University university;

    @Before
    public void init(){
        university = new University("KPI", 100);
    };

    @After
    public void tearDown() {
        university = null;
        System.out.println("After");

    }

    @Test
    public void testCloneUniversity() throws CloneNotSupportedException {
        University un = university.clone();
        un.setName("NAU");

        Assert.assertEquals("NAU", un.getName());
        Assert.assertEquals("KPI", university.getName());
    }

    @Test
    public void testCloneStudent() throws CloneNotSupportedException {
        Student student = new BudgetStudent("Nick", "North", 6, 560);
        Student stud = student.clone();
        stud.setAverageMark(10);

        Assert.assertEquals(10, stud.getAverageMark(), 0.001);
        Assert.assertEquals(6.0, student.getAverageMark(), 0.001);
    }

    @Test
    public void testCloneGroup() throws CloneNotSupportedException {
        Group group = new Group("IP-42", 24);
        Group gr = group.clone();
        group.setName("IA-41");

        Assert.assertEquals("IP-42", gr.getName());
        Assert.assertEquals("IA-41", group.getName());
    }

    @Test
    public void testCloneManyStudents() throws CloneNotSupportedException {
        Student student = new BudgetStudent("Nick", "North", 6, 560);
        Student student1 = new BudgetStudent("Nick", "Smith", 7, 560);
        Student student2 = new BudgetStudent("Bill", "Smith", 10, 780);
        Student student3 = new BudgetStudent("Liza", "Smith", 8, 780);

        Group group = new Group("1-A", 4);

        group.addStudent(student);
        group.addStudent(student1);
        group.addStudent(student2);
        group.addStudent(student3);

        Group gr = group.clone();

        group.deleteStudent(student);

        Assert.assertTrue(gr.contains(student));
        Assert.assertFalse(group.contains(student));
    }

    @Test
    public void testCloneManyGroups() throws CloneNotSupportedException {
        Student student = new BudgetStudent("Nick", "North", 6, 560);
        Student student1 = new BudgetStudent("Nick", "Smith", 7, 560);
        Student student2 = new BudgetStudent("Bill", "Smith", 10, 780);
        Student student3 = new BudgetStudent("Liza", "Smith", 8, 780);

        Student student4 = new ContractStudent("Vita", "Smith", 8, 2);
        Student student5 = new ContractStudent("Yura", "Smith", 8, 7);
        Student student6 = new ContractStudent("Vanya", "Smith", 9, 4);

        Group group = new Group("1-A", 4);
        Group group2 = new Group("ACO16", 3);

        group.addStudent(student);
        group.addStudent(student1);
        group.addStudent(student2);
        group.addStudent(student3);

        group2.addStudent(student4);
        group2.addStudent(student5);
        group2.addStudent(student6);

        university.addGroup(group2);
        university.showGroups();

        University artCode = university.clone();

        

        Assert.assertTrue(group2.contains(student));
        Assert.assertFalse(group.contains(student));
    }
}
