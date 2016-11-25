package main.java;

/**
 * Created by Vita on 13.11.2016.
 */
public interface Collection<T> extends Iterable{
    int size();
    boolean isEmpty();
    boolean contains(Object o);
    <T> T[] toArray();
    boolean add(T e);
    boolean remove(Object o);
    void clear();
}
