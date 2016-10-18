package hw.createCar;

/**
 * Created by Vita on 15.10.2016.
 */
public class TestCar {
    public static void main(String[] args) {
        Engine engine = new Engine("injected");

        Car car = new Car("BMW", engine, 4, false);

        Wheel wheel = new Wheel(true);
        Wheel wheel1 = new Wheel(false);
        Wheel wheel2 = new Wheel(true);
        Wheel wheel3 = new Wheel(true);

        car.addWheel(wheel);
        car.addWheel(wheel1);
        car.addWheel(wheel2);
        car.addWheel(wheel3);

        car.showWheels();

        System.out.println(car.getBrand());
        System.out.println(car.toString());

        Wheel wheel4 = new Wheel(true);

        car.changeWheel(wheel4);

        car.showWheels();

        System.out.println();

        Wheel wheel5 = new Wheel(true);

        car.changeWheel(wheel1, wheel5);

        car.showWheels();
    }
}
