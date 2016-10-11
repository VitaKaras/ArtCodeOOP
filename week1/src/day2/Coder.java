package day2;

/**
 * Created by Vita on 09.10.2016.
 */
public class Coder extends Employee{
    String programmingLanguage;

    public Coder(String name, String surname) {
        super(name, surname);
    }

    public Coder(String name, String surname, String programmingLanguage){
        super(name, surname);
        this.programmingLanguage=programmingLanguage;
    }

    @Override
    public void work(){
        super.work();
        System.out.println("I'm programmer");
    }

    @Override
    public String toString(){
        return super.toString() + "; PL - "+ programmingLanguage;
    }
}
