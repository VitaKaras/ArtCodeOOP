package day2;

/**
 * Created by Vita on 09.10.2016.
 */
public class Employee {
    String name;
    String surname;

    public Employee(String name, String surname){
        this.name = name;
        this.surname=surname;
    }

    public void work(){
        System.out.println("I`m Employee and I`m working");
    }

    @Override
    public String toString(){
        return String.format("Student name - %s, surname - %s", name, surname);
    }

}
