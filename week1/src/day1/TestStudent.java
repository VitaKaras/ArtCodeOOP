package day1;

/**
 * Created by Vita on 08.10.2016.
 */
public class TestStudent {
    public static void main(String[] args) {
        Student student = new Student("Nick", "Smith", 20);

        System.out.println(student.name);

        student.setName("Bill");

        System.out.println(student.name);
        System.out.println(student.surname);
        System.out.println(student.age);

        System.out.println(student);

    }
}
