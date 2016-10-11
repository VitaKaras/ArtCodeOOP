package day2;

/**
 * Created by Vita on 09.10.2016.
 */
public class Middle extends Coder {
    public Middle(String name, String surname) {
        super(name, surname);
    }

    public Middle(String name, String surname, String programmingLanguage) {
        super(name, surname, programmingLanguage);
    }

    @Override
    public void work() {
        System.out.println("I`m Middle");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
