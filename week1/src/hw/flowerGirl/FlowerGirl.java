package hw.flowerGirl;

/**
 * Created by Vita on 18.10.2016.
 */
public class FlowerGirl {

    private Bouquet bouquet;
    private int flowerCount;
    private int accessoryCount;

    public void createBouquet(int flowerCount) {
        bouquet = new Bouquet(flowerCount);
    }

    public boolean addFlower(Flower flower) {
        if (flowerCount == bouquet.getFlowers().length || flower == null) return false;

        bouquet.getFlowers()[flowerCount++] = flower;
        return true;
    }

    public boolean addAccessory(Accessory accessory) {
        if (accessoryCount == bouquet.getFlowers().length || accessory == null) return false;

        bouquet.getAccessories()[accessoryCount++] = accessory;
        return true;
    }

    public double price() {
        double sum = 0;
        for (int i = 0; i < flowerCount; i++) {
            sum += bouquet.getFlowers()[i].price();
        }
        for (int i = 0; i < accessoryCount; i++) {
            sum += bouquet.getAccessories()[i].price();
        }
        return sum;
    }

    public boolean searchFlower(int minStem, int maxStem) {

        for (int i = 0; i < flowerCount; i++) {
            int stemSize = bouquet.getFlowers()[i].stemSize;
            if (stemSize >= minStem && stemSize <= maxStem) {
                System.out.println("Range (" + minStem + ";" + maxStem + "):" + bouquet.getFlowers()[i]);
                return true;
            }
        }
        return false;
    }

    public void sort() {
        for (int i = 0; i < flowerCount - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < flowerCount - i - 1; j++) {
                if (bouquet.getFlowers()[j].compareTo(bouquet.getFlowers()[j + 1]) > 0) {
                    Flower tmp = bouquet.getFlowers()[j];
                    bouquet.getFlowers()[j] = bouquet.getFlowers()[j + 1];
                    bouquet.getFlowers()[j + 1] = tmp;
                    swapped = true;
                }
            }

            if (!swapped)
                break;
        }
    }

    public void showFlowers() {
        for (int i = 0; i < flowerCount; i++) {
            System.out.println(bouquet.getFlowers()[i]);
        }
    }

    public static void main(String[] args) {

        FlowerGirl flowerGirl = new FlowerGirl();

        flowerGirl.createBouquet(5);

        flowerGirl.addFlower(new Peony(1, FreshnessLevel.FRESH));
        flowerGirl.addFlower(new Peony(4, FreshnessLevel.FRESH));
        flowerGirl.addFlower(new Rose(3, FreshnessLevel.LIMP));
        flowerGirl.addFlower(new Rose(1, FreshnessLevel.LIMP));
        flowerGirl.addFlower(new Daffodil(2, FreshnessLevel.LIMP));

        flowerGirl.addAccessory(new Ribbon(4, Color.BLUE));
        flowerGirl.addAccessory(new Cellophane(5, Color.COLORLESS));
        flowerGirl.addAccessory(new Basket(10, Color.BROWN));

        flowerGirl.showFlowers();

        System.out.println();

        flowerGirl.sort();
        flowerGirl.showFlowers();

        System.out.println();

        flowerGirl.searchFlower(1, 3);

        System.out.println("Price: "+flowerGirl.price());

    }
}
