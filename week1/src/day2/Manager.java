package day2;

/**
 * Created by Vita on 09.10.2016.
 */
public class Manager extends Employee{ //is a
    int salary;

    Employee [] employees; // has a

    private int employeeCount;

    public Manager(String name, String surname){
        super(name, surname);
    }

    @Override
    public void work(){
        System.out.println("I`m Manager and I`m working");
    }

    public boolean addEmployee(Employee employee){
        if(employeeCount == employees.length) return false;
        employees[employeeCount] = employee;
        employeeCount++;
        return true;
    }

    public Manager(String name, String surname, int salary, int employeesSize){
        super(name, surname);
        this.salary=salary;
        employees=new Employee[employeesSize];
    }
}
