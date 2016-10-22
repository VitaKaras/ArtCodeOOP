package main.java.hw.flowerGirl;

/**
 * Created by Vita on 18.10.2016.
 */
public class Peony extends Flower {

    public Peony(int stemSize) {
        super(stemSize);
    }

    public Peony(int stemSize, FreshnessLevel freshness) {
        super(stemSize, freshness);
    }

    @Override
    public double price() {
        return 7.5;
    }

    @Override
    public String toString() {
        return super.toString() + "(Peony)";
    }
}
