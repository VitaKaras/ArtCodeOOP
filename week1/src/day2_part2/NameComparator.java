package day2_part2;

import java.util.Comparator;
import java.util.stream.Stream;

/**
 * Created by Vita on 16.10.2016.
 */
public class NameComparator implements Comparator<Student> {

    @Override
    public int compare(Student student1, Student student2) {
        return student1.getName().compareTo(student2.getName());
    }
}
