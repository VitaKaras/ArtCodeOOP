package hw.flowerGirl;

/**
 * Created by Vita on 18.10.2016.
 */
public abstract class Flower {
    protected enum FreshnessLevel {lIMP, FRESH }
    private int stemSize;
    private Flower.FreshnessLevel  freshness = FreshnessLevel.FRESH;

    public Flower(int stemSize) {
        this.stemSize = stemSize;
    }

    public Flower(int stemSize, FreshnessLevel freshness) {
        this.stemSize = stemSize;
        this.freshness = freshness;
    }

    public abstract double price();

    public int getStemSize() {
        return stemSize;
    }

    public void setStemSize(int stemSize) {
        this.stemSize = stemSize;
    }

    public FreshnessLevel getFreshness() {
        return freshness;
    }

    public void setFreshness(FreshnessLevel freshness) {
        this.freshness = freshness;
    }
}
