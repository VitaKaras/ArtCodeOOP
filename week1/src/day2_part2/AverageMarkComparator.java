package day2_part2;

import java.util.Comparator;

/**
 * Created by Vita on 21.10.2016.
 */
public class AverageMarkComparator implements Comparator<Student> {

    @Override
    public int compare(Student student1, Student student2) {
        if(student1.getAverageMark() - student2.getAverageMark()>0)
            return 1;
        else if(student1.getAverageMark() - student2.getAverageMark()<0)
            return -1;
        return 0;
    }
}
