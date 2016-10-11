package day2;

/**
 * Created by Vita on 09.10.2016.
 */
public class Junior extends Coder {
    public Junior(String name, String surname) {
        super(name, surname);
    }

    public Junior(String name, String surname, String programmingLanguage) {
        super(name, surname, programmingLanguage);
    }

    @Override
    public void work() {
        System.out.println("I`m Junior");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
