package hw.flowerGirl;

/**
 * Created by Vita on 18.10.2016.
 */
public class Daffodil extends Flower{

    public Daffodil(int stemSize) {
        super(stemSize);
    }

    public Daffodil(int stemSize, FreshnessLevel freshness) {
        super(stemSize, freshness);
    }

    @Override
    public double price() {
        return 7;
    }
}
