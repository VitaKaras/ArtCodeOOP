package main.java.hw.createDog;

/**
 * Created by Vita on 15.10.2016.
 */
public class Dog extends Animal {

    private String name;

    public Dog(String name) {
        super(name);
    }

    @Override
    public void jump() {
        super.jump();
        System.out.println("(Dog)");
    }

    @Override
    public void run() {
        super.run();
        System.out.println("(Dog)");
    }

    @Override
    public void voice() {
        super.voice();
        System.out.println("(Dog)");
    }

    @Override
    public void bite() {
        super.bite();
        System.out.println("(Dog)");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + this.getName() + '\'' +
                '}';
    }
}
