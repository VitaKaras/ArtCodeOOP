package hw.flowerGirl;

import java.util.Comparator;

/**
 * Created by Vita on 18.10.2016.
 */
public abstract class Flower implements Comparable<Flower>, BouquetInterface{

    protected int stemSize;
    private FreshnessLevel freshness = FreshnessLevel.FRESH;

    public Flower(int stemSize) {
        this.stemSize = stemSize;
    }

    public Flower(int stemSize, FreshnessLevel freshness) {
        this.stemSize = stemSize;
        this.freshness = freshness;
    }

    public FreshnessLevel getFreshness() {
        return freshness;
    }

    public void setFreshness(FreshnessLevel freshness) {
        this.freshness = freshness;
    }

    @Override
    public int compareTo(Flower flower) {

        if (this.getFreshness().compareTo(flower.getFreshness()) > 0) {
            return 1;
        } else if (this.getFreshness().compareTo(flower.getFreshness()) < 0) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "stemSize=" + stemSize +
                ", freshness=" + freshness +
                '}';
    }

    public double price(){
        return this.price();
    }
}
