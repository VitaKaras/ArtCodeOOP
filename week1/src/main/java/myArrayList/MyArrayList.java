package main.java.myArrayList;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Vita on 19.10.2016.
 */
public class MyArrayList<T> {
    private int size;
    private T[] elements;
    private int capacity;

    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        elements = (T[]) new Object[capacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(T o) {
        return indexOf(o) >= 0;
    }

    public boolean add(T element) {

        if (size == elements.length) {
            growCapacity();
        }

        elements[size] = element;
        size++;
        return true;
    }

    public void growCapacity() {
        capacity *= 2;
        T[] newMyArrayList = (T[]) new Object[capacity];

        for (int i = 0; i < size; i++) {
            newMyArrayList[i] = elements[i];
        }

        elements = newMyArrayList;

    }

    public boolean remove(T o) {
        if (contains(o)) {
            remove(indexOf(o));
            return true;
        }
        return false;
    }

    public void clear() {
        elements = (T[]) new Object[capacity];
        size = 0;
    }

    public T get(int index) {
        if ((index < 0 || index >= size()))
            throw new IndexOutOfBoundsException();

        return elements[index];
    }

    public T set(int index, T element) {
        if ((index < 0 || index >= size()))
            throw new IndexOutOfBoundsException();

        T previousElement = elements[index];
        elements[index] = element;

        return previousElement;
    }

    public void add(int index, T element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }

        if (size + 1 == elements.length) {
            growCapacity();
        }



        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }

        elements[index] = element;
        size++;

    }

    public T remove(int index) {
        if ((index < 0 || index >= size())) {
            throw new IndexOutOfBoundsException();
        }

        T element = elements[index];

        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }

        size--;

        return element;
    }

    public int indexOf(Object element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == element)
                    return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) //TODO
                    return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T element) {
        if (element == null) {
            for (int i = size; i < 0; i--) {
                if (elements[i] == element)
                    return i;
            }
        } else {
            for (int i = size; i > 0; i--) {
                if (element.equals(elements[i]))
                    return i;
            }
        }
        return -1;
    }

    public Object[] toArray() {
        Object[] array = new Object[size];

        for (int i = 0; i < size; i++) {
            array[i] = elements[i];
        }
        return array;
    }
}
