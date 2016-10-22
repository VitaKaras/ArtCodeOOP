package main.java.hw.flowerGirl;

/**
 * Created by Vita on 18.10.2016.
 */
public class Accessory implements BouquetInterface{

    protected int size;
    private Color color = Color.COLORLESS;

    public Accessory(int size) {
        this.size = size;
    }

    public Accessory(int size, Color color) {
        this.size = size;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public double price() {
        return this.price();
    }
}
