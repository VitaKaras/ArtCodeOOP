package hw.flowerGirl;

/**
 * Created by Vita on 18.10.2016.
 */
public class Ribbon extends Accessory{

    public Ribbon(int size) {
        super(size);
    }

    public Ribbon(int size, Color color) {
        super(size, color);
    }

    @Override
    public double price() {
        if(this.getSize()>5)
            return 1.5;
        else return 1;
    }
}
