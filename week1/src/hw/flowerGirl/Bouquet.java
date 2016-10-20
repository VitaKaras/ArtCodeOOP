package hw.flowerGirl;

/**
 * Created by Vita on 19.10.2016.
 */
public class Bouquet {

    private Flower[] flowers;
    private Accessory[] accessories;
    private int size;

    public Bouquet(int size) {
        flowers = new Flower[size];
        accessories = new Accessory[size];
    }

    public Flower[] getFlowers() {
        return flowers;
    }

    public void setFlowers(Flower[] flowers) {
        this.flowers = flowers;
    }

    public Accessory[] getAccessories() {
        return accessories;
    }

    public void setAccessories(Accessory[] accessories) {
        this.accessories = accessories;
    }
}
