package day2.myLibrary.comparators;

import day2.myLibrary.model.Reader;

import java.util.Comparator;

public class NameReaderComparator implements Comparator<Reader> {

    @Override
    public int compare(Reader r1, Reader r2) {
        return r1.getName().compareTo(r2.getName());
    }
}
