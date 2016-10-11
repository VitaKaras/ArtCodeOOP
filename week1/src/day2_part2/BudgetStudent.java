package day2_part2;

/**
 * Created by Vita on 09.10.2016.
 */
public class BudgetStudent extends Student {
    private long scholarship;

    public BudgetStudent(String name, String surname, double averageMark, long scholarship) {
        super(name, surname, averageMark);
        this.scholarship = scholarship;
    }

    public long getScholarship() {
        return scholarship;
    }

    public void setScholarship(long scholarship) {
        this.scholarship = scholarship;
    }

    @Override
    public String toString() {
        return "BudgetStudent: " +
                "scholarship - " + scholarship + " " + super.toString();
    }
}
