package hw.flowerGirl;

/**
 * Created by Vita on 18.10.2016.
 */
public class Cellophane extends Accessory{

    public Cellophane(int size) {
        super(size);
    }

    public Cellophane(int size, Color color) {
        super(size, color);
    }

    @Override
    public double price() {
        if(this.getColor()==Color.COLORLESS)
            return 1.29;
        else return 2;
    }
}
