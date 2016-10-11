package day2;

/**
 * Created by Vita on 09.10.2016.
 */
public class TestInheritance {
    public static void main(String[] args) {
        Employee employee = new Employee("Jack","Smith");
        System.out.println(employee);

        Manager manager = new Manager("John", "Smith", 2500, 15);
        System.out.println(manager);

        Manager manager2 = new Manager("John", "Smith", 2500, 15);
        System.out.println(manager);

        boolean b=manager instanceof Employee;
        System.out.println(b);

        Junior junior=new Junior("Ann", "Smith", "Java");
        Middle middle=new Middle("Kate", "Smith", "Java");
        Senior senior=new Senior("Vanya", "Smith", "Java");

        employee.work();
        manager.work();
        manager2.work();

        System.out.println(junior);
        System.out.println(middle);
        System.out.println(senior);
        junior.work();
        middle.work();
        senior.work();
    }
}
