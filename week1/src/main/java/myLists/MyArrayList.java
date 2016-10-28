package main.java.myLists;

/**
 * Created by Vita on 19.10.2016.
 */
public class MyArrayList<T> implements MyList<T> {
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

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T o) {
        return indexOf(o) >= 0;
    }

    @Override
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

    @Override
    public boolean remove(T o) {
        int idx = indexOf(o);
        if (idx >= 0) {
            remove(idx);
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        elements = (T[]) new Object[capacity];
        size = 0;
    }

    @Override
    public T get(int index) {
        if ((index < 0 || index >= size()))
            throw new IndexOutOfBoundsException();

        return elements[index];
    }

    @Override
    public T set(int index, T element) {
        if ((index < 0 || index >= size()))
            throw new IndexOutOfBoundsException();

        T previousElement = elements[index];
        elements[index] = element;

        return previousElement;
    }

    @Override
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

    @Override
    public T remove(int index) {
        if ((index < 0 || index >= size())) {
            throw new IndexOutOfBoundsException();
        }

        T element = elements[index];

        System.arraycopy(elements, index + 1, elements, index, elements.length - index - 1);
        elements[elements.length - 1] = null;
        size--;

        return element;
    }

    @Override
    public int indexOf(Object element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == element)
                    return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i]))
                    return i;
            }
        }
        return -1;
    }

    @Override
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

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];

        for (int i = 0; i < size; i++) {
            array[i] = elements[i];
        }
        return array;
    }
}
