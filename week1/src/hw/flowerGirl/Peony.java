package hw.flowerGirl;

/**
 * Created by Vita on 18.10.2016.
 */
public class Peony extends Flower {

    public Peony(int stemSize) {
        super(stemSize);
    }

    public Peony(int stemSize, Flower.FreshnessLevel freshness) {
        super(stemSize, freshness);
    }

    @Override
    public double price() {
        return 7.5;
    }
}
