package day2_part2;


/**
 * Created by Vita on 09.10.2016.
 */
public class ContractStudent extends Student{
    private int period;

    public ContractStudent(String name, String surname, double averageMark, int period) {
        super(name, surname, averageMark);
        this.period=period;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "ContractStdent: " +
                "period - " + period + " "+ super.toString();
    }
}
