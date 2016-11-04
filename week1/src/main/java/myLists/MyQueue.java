package main.java.myLists;

import java.util.Queue;

/**
 * Created by Vita on 04.11.2016.
 */
public interface MyQueue<T> {
    boolean add(T el);

    T element();

    boolean offer(T el);

    T peek();

    T poll();

    T remove();
}
