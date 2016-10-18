package hw.flowerGirl;

/**
 * Created by Vita on 18.10.2016.
 */
public abstract class Accessory {
    private int size;
    private Color color = Color.COLORLESS;

    public Accessory(int size) {
        this.size = size;
    }

    public Accessory(int size, Color color) {
        this.size = size;
        this.color = color;
    }

    public abstract double price();

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
