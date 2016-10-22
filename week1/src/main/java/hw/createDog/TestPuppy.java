package main.java.hw.createDog;

/**
 * Created by Vita on 15.10.2016.
 */
public class TestPuppy {
    public static void main(String[] args) {

        Animal dog = new Dog("Bars");
        dog.jump();
        System.out.println(dog.toString());

        Animal puppy = new Puppy("Rocky");
        puppy.run();
        System.out.println(puppy.toString());

        Dog puppy2 = new Puppy("Jack");
        puppy2.bite();
        System.out.println(puppy2.toString());
    }
}
