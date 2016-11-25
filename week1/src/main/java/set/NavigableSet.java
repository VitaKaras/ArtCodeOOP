package main.java.set;

/**
 * Created by Vita on 13.11.2016.
 */
public interface NavigableSet<E> extends SortedSet<E> {
    E lower(E e);
    E floor(E e);
    E ceiling(E e);
    E higher(E e);
    E pollFirst();
    E pollLast();
}
