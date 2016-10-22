package main.java.hw.createCar;

/**
 * Created by Vita on 15.10.2016.
 */
public class Car {

    private Wheel[] wheels;
    private String brand;
    private Engine engine;
    private boolean isFilledTank;
    int countWheel;

    public Car(String brand, Engine engine, int sizeOfWheel, boolean isFilledTank) {
        this.brand = brand;
        this.engine = engine;
        wheels = new Wheel[sizeOfWheel];
        this.isFilledTank = isFilledTank;
    }

    public boolean addWheel(Wheel wheel) {
        if (wheel == null || countWheel == wheels.length)
            return false;
        wheels[countWheel++] = wheel;
        return true;
    }

    public boolean drive() {
        if (countWheel == 4 && isFilledTank)
            return true;
        return false;
    }

    public void fillCar() {
        if (!isFilledTank) {
            isFilledTank = true;
        }
    }

    public boolean hasWheel(Wheel wheel) {
        if (wheel == null)
            return false;
        for (int i = 0; i < countWheel; i++) {
            if (wheel.equals(wheels[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean changeWheel(Wheel wheel1, Wheel wheel2) {
        if (wheel1 == null || wheel2 == null || (this.hasWheel(wheel1) && this.hasWheel(wheel2)))
            return false;
        for (int i = 0; i < countWheel; i++) {
            if (wheel1.equals(wheels[i])) {
                wheels[i] = wheel2;
                break;
            }
        }
        return true;
    }

    public boolean changeWheel(Wheel wheel) {
        if (wheel == null)
            return false;
        for (int i = 0; i < countWheel; i++) {
            if (!wheels[i].isDamaged()) {
                wheels[i] = wheel;
                break;
            }
        }
        return true;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void showWheels() {
        for (int i = 0; i < countWheel; i++) {
            System.out.println(i + " - " + wheels[i].isDamaged());
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "wheels=" + wheels.length +
                ", brand='" + brand + '\'' +
                ", engine=" + engine +
                ", isFilledTank=" + isFilledTank +
                '}';
    }
}
