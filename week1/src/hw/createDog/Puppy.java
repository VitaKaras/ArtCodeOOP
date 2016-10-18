package hw.createDog;

/**
 * Created by Vita on 15.10.2016.
 */
public class Puppy extends Dog {

    public Puppy (String name) {
        super(name);
    }

    @Override
    public void jump() {
        super.jump();
        System.out.println("(Puppy)");
    }

    @Override
    public void run() {
        super.run();
        System.out.println("(Puppy)");
    }

    @Override
    public void voice() {
        super.voice();
        System.out.println("(Puppy)");
    }

    @Override
    public void bite() {
        super.bite();
        System.out.println("(Puppy)");
    }

    @Override
    public String toString() {
        return super.toString()+"(Puppy)";
    }
}

