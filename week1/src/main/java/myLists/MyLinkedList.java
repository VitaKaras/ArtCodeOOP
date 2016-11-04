package main.java.myLists;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Created by Vita on 23.10.2016.
 */
public class MyLinkedList<T> implements MyList<T>, MyDeque<T> {

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
            head = tail = new Node<>(o);
            size++;
            return true;
        }
        tail.next = new Node<>(tail, o);
        tail = tail.next;
        size++;
        return true;
    }

    @Override
    public T element() {
        if (isEmpty())
            throw new NoSuchElementException();

        return get(0);
    }

    @Override
    public boolean offer(T el) {
        add(size - 1, el);
        return true;
    }

    @Override
    public T peek() {
        if (isEmpty()) return null;

        return get(0);
    }

    @Override
    public T poll() {
        if (isEmpty()) return null;

        return remove();
    }

    @Override
    public T remove() {
        if (isEmpty())
            throw new NoSuchElementException();

        T element = get(0);
        remove(0);
        return element;
    }

    @Override
    public void add(int index, T o) {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException();

        Node<T> iterator = head;
        Node<T> newNode = new Node<>(o);
        if (index == size) {
            add(o);
            return;
        } else if (index == 0) {
            head.previous = newNode;
            newNode.next = head;
            head = newNode;
        } else {
            for (int i = 0; i < index; i++) {
                iterator = iterator.getNext();
            }
            newNode.next = iterator;
            iterator.previous.next = newNode;
            newNode.previous = iterator.previous;
            iterator.previous = newNode;
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
        iterator.value = o;

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
            array[i] = iterator.value;
        }
        return array;
    }

    public void showList() {
        Iterator<T> myLinkedListIterator = iterator();
        while (myLinkedListIterator.hasNext()) {
            System.out.println(myLinkedListIterator.next());
        }

    }

    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }

    @Override
    public boolean addFirst(T el) {
        add(0, el);
        return true;
    }

    @Override
    public boolean addLast(T el) {
        add(size - 1, el);
        return true;
    }

    @Override
    public T getFirst() {
        return get(0);
    }

    @Override
    public T getLast() {
        return get(size - 1);
    }

    @Override
    public boolean offerFirst(T el) {
        add(0, el);
        return true;
    }

    @Override
    public boolean offerLast(T el) {
        add(0, el);
        return true;
    }

    @Override
    public T peekFirst() {
        if (isEmpty()) return null;

        return get(0);
    }

    @Override
    public T peekLast() {
        if (isEmpty()) return null;

        return get(size - 1);
    }

    @Override
    public T pollFirst() {
        if (isEmpty()) return null;

        return remove(0);
    }

    @Override
    public T pollLast() {
        if (isEmpty()) return null;
        return remove(size - 1);
    }

    @Override
    public boolean push(T el) {
        return addFirst(el);
    }

    @Override
    public T removeFirst() {
        T element = getFirst();
        remove(0);
        return element;
    }

    @Override
    public T removeLast() {
        T element = getLast();
        remove(0);
        return element;
    }

    private static class Node<T> {
        private Node<T> next;
        private Node<T> previous;
        private T value;

        public Node(Node<T> next, Node<T> previous, T value) {
            this.next = next;
            this.previous = previous;
            this.value = value;
        }

        public Node(T value) {
            this.value = value;
        }

        public Node() {

        }

        public Node(Node<T> previous, T value) {
            this.previous = previous;
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node<T> getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

    }

    private class MyLinkedListIterator implements Iterator<T> {


        private Node<T> iterator;

        public MyLinkedListIterator() {
            iterator = new Node<>();
            iterator.next = head;
        }

        @Override
        public boolean hasNext() {
            return iterator.next != null;
        }

        @Override
        public T next() {
            iterator = iterator.next;
            return iterator.value;
        }
    }

    public static void main(String[] args) {
//        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
//        myLinkedList.add("1");
//        myLinkedList.add("2");
//        myLinkedList.add(null);
//        myLinkedList.add("1");
//        myLinkedList.add("5");
//
//        myLinkedList.showList();
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("1");

    }
}
