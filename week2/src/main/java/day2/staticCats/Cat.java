package day2.staticCats;

import java.util.ArrayList;

/**
 * Created by Vita on 03.11.2016.
 */
public class Cat {
    public static ArrayList<Cat> cats = new ArrayList<>();
    private String name;

    public Cat(String name) {
        this.name = name;
        cats.add(this);
    }

    public static void printCats() {
        for (Cat cat : cats) {
            System.out.println(cat);
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Cat cat = new Cat("Tom");
        Cat cat1 = new Cat("Luna");
        Cat cat2 = new Cat("Lusy");
        Cat cat3 = new Cat("Kitty");
        Cat cat4 = new Cat("Molly");
        Cat cat5 = new Cat("Smokey");
        Cat cat6 = new Cat("Simba");
        Cat cat7 = new Cat("Tiger");
        Cat cat8 = new Cat("Shadow");
        Cat cat9 = new Cat("Oliver");
        printCats();
        System.out.println();
        cat3.printCats();
        System.out.println();
        Cat.printCats();
    }
}
