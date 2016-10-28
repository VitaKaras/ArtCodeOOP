package main.java.myLists;

/**
 * Created by Vita on 23.10.2016.
 */
public class MyLinkedList<T> implements MyList<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;

    public MyLinkedList() {

    }


    public void count() {
        Node<T> node = head;
        while (node != null) {
            System.out.print(node.getValue() + " ");
            node = node.next;
        }
        System.out.println();
    }

    @Override
    public boolean add(T o) {
        if (isEmpty()) {
            head = tail = new Node(o);
            size++;
            return true;
        }
        tail.setNext(new Node(tail, o));
        tail = tail.getNext();
        size++;
        return true;
    }

    @Override
    public void add(int index, T o) {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException();

        Node<T> iterator = head;
        Node<T> newNode = new Node(o);
        if (index == size) {
            add(o);
            return;
        } else if (index == 0) {
            head.setPrevious(newNode);
            newNode.setNext(head);
            head = newNode;
        } else {
            for (int i = 0; i < index; i++) {
                iterator = iterator.getNext();
            }
            newNode.setNext(iterator);
            iterator.previous.setNext(newNode);
            newNode.setPrevious(iterator.previous);
            iterator.setPrevious(newNode);
        }

        size++;

    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public boolean contains(T o) {
        return indexOf(o) >= 0;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();

        Node<T> iterator = head;
        if (index == size - 1) {
            iterator = tail;
        } else {
            for (int i = 0; i < index; i++) {
                iterator = iterator.next;
            }
        }
        return iterator.getValue();
    }

    @Override
    public int indexOf(Object o) {
        Node iterator = head;
        if (o == null) {
            for (int i = 0; i < size; i++, iterator = iterator.getNext()) {
                if (iterator.getValue() == o)
                    return i;
            }
        } else {
            for (int i = 0; i < size(); i++, iterator = iterator.getNext()) {
                if (o.equals(iterator.getValue()))
                    return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int lastIndexOf(T o) {
        Node iterator = tail;
        if (o == null) {
            for (int i = size - 1; i > 0; i--, iterator = iterator.previous) {
                if (iterator.getValue() == o)
                    return i;
            }
        } else {
            for (int i = size - 1; i > 0; i--, iterator = iterator.previous) {
                if (o.equals(iterator.getValue()))
                    return i;
            }
        }
        return -1;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();

        Node<T> removedNode = head;
        T value = null;
        if (index == 0) {
            head = head.next;
            if (head != null)
                head.previous = null;
        } else if (index == size - 1) {
            removedNode = tail;
            tail = tail.previous;
            if (tail != null)
                tail.next = null;
        } else {
            for (int i = 0; i < index; i++) {
                removedNode = removedNode.next;
            }
            removedNode.previous.next = removedNode.next;
            removedNode.next.previous = removedNode.previous;
        }
        size--;
        return removedNode.getValue();

    }

    @Override
    public boolean remove(T o) {
        int index = indexOf(o);
        if (index >= 0) {
            remove(index);
            return true;
        }
        return false;

    }

    @Override
    public T set(int index, T o) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();

        Node<T> newNode = new Node<T>(o);
        Node<T> iterator = head;
        for (int i = 0; i < index; i++) {
            iterator = iterator.next;
        }
        T oldValue = iterator.getValue();
        iterator.setValue(o);

        return oldValue;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<T> iterator = head;
        for (int i = 0; i < size(); i++, iterator = iterator.next) {
            array[i] = iterator.getValue();
        }
        return array;
    }
}
