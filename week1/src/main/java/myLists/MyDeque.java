package main.java.myLists;

/**
 * Created by Vita on 04.11.2016.
 */
public interface MyDeque<T> extends MyQueue<T> {

    boolean addFirst(T el);

    boolean addLast(T el);

    T getFirst();

    T getLast();

    boolean offerFirst(T el);

    boolean offerLast(T el);

    T peekFirst();

    T peekLast();

    T pollFirst();

    T pollLast();

    boolean push(T el);

    T removeFirst();

    T removeLast();

}
