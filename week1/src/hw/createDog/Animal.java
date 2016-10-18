package hw.createDog;

/**
 * Created by Vita on 15.10.2016.
 */
public abstract class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public void jump() {
        System.out.print("The animal " + this.name + " jump");
    }

    public void run() {
        System.out.print("The animal " + this.name + " run");
    }

    public void voice() {
        System.out.print("The animal " + this.name + " voice");
    }

    public void bite() {
        System.out.print("The animal " + this.name + " bite");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract String toString();
}
