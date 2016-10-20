package hw.flowerGirl;

/**
 * Created by Vita on 18.10.2016.
 */
public class Basket extends Accessory {

    public Basket(int size) {
        super(size);
    }

    public Basket(int size, Color color) {
        super(size, color);
    }

    @Override
    public double price() {
        if (this.getSize() < 15)
            return 3.45;
        else return 5;
    }
}
