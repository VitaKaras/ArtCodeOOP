package main.java.day2_part2;

import java.util.Comparator;

/**
 * Created by Vita on 16.10.2016.
 */
public class NameComparator implements Comparator<Student> {

    @Override
    public int compare(Student student1, Student student2) {
        return student1.compareTo(student2);
    }

}
