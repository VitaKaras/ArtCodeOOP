package main.java.day1;

/**
 * Created by Vita on 08.10.2016.
 */
public class Student {

    String name;
    String surname;
    int age;

    public Student() {
    }

    public Student(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return String.format("Student name - %s, surname - %s, age - %d", name, surname, age);
    }
}
