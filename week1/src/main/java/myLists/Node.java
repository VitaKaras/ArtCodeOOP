package main.java.myLists;

import java.util.LinkedList;

/**
 * Created by Vita on 23.10.2016.
 */
public class Node<T> {
    public Node next;
    public Node previous;
    public T value;

    public Node(Node next, Node previous, T value) {
        this.next = next;
        this.previous = previous;
        this.value = value;
    }

    public Node(T value) {
        this.value = value;
    }

    public Node(Node previous, T value) {
        this.previous = previous;
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
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

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(5, 7);
        System.out.println(linkedList.toString());
    }
}
