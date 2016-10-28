package main.java.myLists;

/**
 * Created by Vita on 20.10.2016.
 */

public interface MyList<T> {

    boolean add(T o);

    void add(int index, T o);

    void clear();

    boolean contains(T o);

    T get(int index);

    int indexOf(T o);

    boolean isEmpty();

    int lastIndexOf(T o);

    T remove(int index);

    boolean remove(T o);

    T set(int index, T o);

    int size();

    Object[] toArray();

}
