package main.java.set;

import java.util.Comparator;

/**
 * Created by Vita on 13.11.2016.
 */
public interface SortedSet<E> extends Set<E> {
    Comparator<? super E> comparator();
    E first();
    E last();
}
