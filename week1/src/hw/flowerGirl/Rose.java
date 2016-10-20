package hw.flowerGirl;

/**
 * Created by Vita on 18.10.2016.
 */
public class Rose extends Flower {

    public Rose(int stemSize) {
        super(stemSize);
    }

    public Rose(int stemSize, FreshnessLevel freshness) {
        super(stemSize, freshness);
    }

    @Override
    public double price() {
        return 9;
    }

    @Override
    public String toString() {
        return super.toString() + "(Rose)";
    }
}
