package main.java.set;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by gorobec on 13.11.16.
 */
public class MyBinarySearchTree<E> implements NavigableSet<E> {

    private Node<E> root;
    private int size;
    private Comparator<? super E> comparator;

    public MyBinarySearchTree() {
    }

    public MyBinarySearchTree(Comparator<? super E> comparator) {
        this.comparator = comparator;
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
    public boolean contains(Object o) {
        if (o == null) throw new NullPointerException("o == null");

        if (comparator != null) return getNodeWithComparator(o) != null;
        else return getNodeWithComparable(o) != null;
    }

    private Node<E> getNodeWithComparable(Object o) {
        @SuppressWarnings(value = "unchecked")

        Comparable<? super E> comparable = (Comparable<? super E>) o;

        Node<E> iterator = root;

        while (iterator != null) {
            if (comparable.compareTo(iterator.value) > 0) {
                iterator = iterator.rightChild;
            } else if (comparable.compareTo(iterator.value) < 0) {
                iterator = iterator.leftChild;
            } else {
                return iterator;
            }
        }

        return null;
    }

    private Node<E> getNodeWithComparator(Object o) {
        @SuppressWarnings(value = "unchecked")
        E forCompare = (E) o;

        Node<E> iterator = root;

        while (iterator != null) {
            if (comparator.compare(forCompare, iterator.value) > 0) {
                iterator = iterator.rightChild;
            } else if (comparator.compare(forCompare, iterator.value) < 0) {
                iterator = iterator.leftChild;
            } else {
                return iterator;
            }
        }

        return null;
    }

    @Override
    public boolean add(E o) {
        if (root == null) {
            root = new Node<>(o);
            size++;
            return true;
        }
        boolean result;

        if (comparator != null)
            result = addWithComparator(o);
        else
            result = addWithComparable(o);

        if (result) size++;

        return result;
    }

    private boolean addWithComparable(E o) {
        if (o == null) throw new NullPointerException("o == null");
        @SuppressWarnings(value = "unchecked")
        Comparable<? super E> comparable = (Comparable<? super E>) o;

        Node<E> iterator = root;
        Node<E> parent;

        do {
            parent = iterator;
            if (comparable.compareTo(iterator.value) > 0) {
                iterator = iterator.rightChild;
            } else if (comparable.compareTo(iterator.value) < 0) {
                iterator = iterator.leftChild;
            } else {
                return false;
            }
        } while (iterator != null);

        if (comparable.compareTo(parent.value) > 0) {
            parent.rightChild = new Node<>(parent, o);
        } else {
            parent.leftChild = new Node<>(parent, o);
        }

        return true;
    }

    private boolean addWithComparator(E o) {
        if (o == null) throw new NullPointerException("o == null");

        Node<E> iterator = root;
        Node<E> parent;

        do {
            parent = iterator;
            if (comparator.compare(o, iterator.value) > 0) {
                iterator = iterator.rightChild;
            } else if (comparator.compare(o, iterator.value) < 0) {
                iterator = iterator.leftChild;
            } else {
                return false;
            }
        } while (iterator != null);

        if (comparator.compare(o, parent.value) > 0) {
            parent.rightChild = new Node<>(parent, o);
        } else {
            parent.leftChild = new Node<>(parent, o);

        }

        return true;
    }


    @Override
    public boolean remove(Object o) {

        if (o == null) throw new NullPointerException();

        Node<E> forRemove;

        if (comparator != null) {
            forRemove = getNodeWithComparator(o);
        } else {
            forRemove = getNodeWithComparable(o);
        }

        if (forRemove == null) return false;

        if (forRemove.rightChild == null && forRemove.leftChild == null) {
            //no children
            deleteIfHasNotChild(forRemove);
        } else if (forRemove.rightChild == null) {
            //one children == left
            deleteIfHasOnlyLeftChild(forRemove);
        } else if (forRemove.leftChild == null) {
            //one children == right
            deleteIfHasOnlyRightChild(forRemove);
        } else {
            // two children
            deleteIfHasBothChild(forRemove);
        }
        size--;
        return true;

    }

    private void deleteIfHasBothChild(Node<E> forRemove) {
        Node<E> successor = findSuccessor(forRemove);
        if (forRemove == root) {
            root = successor;
            root.parent = null;
            root.leftChild = forRemove.leftChild;
            Node<E> successorRightChild = successor.rightChild;
            Node<E> successorParent = successor.parent;
            root.rightChild = forRemove.rightChild;
            successorParent.leftChild = successorRightChild;
            successorRightChild.parent = root.rightChild;
        } else if (isRightChild(forRemove)) {
            Node<E> removeNode = forRemove;
            Node<E> successorRightChild = successor.rightChild;
            Node<E> successorParent = successor.parent;
            successor.leftChild = removeNode.leftChild;
            removeNode.leftChild.parent = successor;
            successor.parent = removeNode.parent;
            removeNode.parent.rightChild = successor;
            if (successorParent != removeNode) {
                successor.rightChild = successorParent;
                successorParent.parent = successor;
                if (successorRightChild != null) {
                    successorRightChild.parent = successor.rightChild;
                    successorParent.leftChild = successorRightChild;
                }
            }
        } else if (!isRightChild(forRemove)) {
            Node<E> removeNode = forRemove;
            Node<E> successorRightChild = successor.rightChild;
            Node<E> successorParent = successor.parent;
            successor.leftChild = removeNode.leftChild;
            removeNode.leftChild.parent = successor;
            successor.parent = removeNode.parent;
            removeNode.parent.leftChild = successor;
            if (successorRightChild != null) {
                successor.rightChild = removeNode.rightChild;
                successorRightChild.parent = successor;
                successorParent.leftChild = successorRightChild;
                successorRightChild.parent = successorParent.leftChild;
            }
        }
    }

    private boolean isRightChild(Node<E> forRemove) {
        return forRemove == forRemove.parent.rightChild;
    }

    private Node<E> findSuccessor(Node<E> forRemove) {
        return getFirstNode(forRemove.rightChild);
    }


    private void deleteIfHasOnlyRightChild(Node<E> forRemove) {
        if (forRemove == root) {
            root = forRemove.rightChild;
            forRemove.rightChild.parent = null;
        } else if (forRemove == forRemove.parent.leftChild) {
            forRemove.rightChild.parent = forRemove.parent;
            forRemove.parent.leftChild = forRemove.rightChild;
        } else {
            forRemove.rightChild.parent = forRemove.parent;
            forRemove.parent.rightChild = forRemove.rightChild;
        }
    }

    private void deleteIfHasOnlyLeftChild(Node<E> forRemove) {
        if (forRemove == root) {
            root = forRemove.leftChild;
            forRemove.leftChild.parent = null;
        } else if (forRemove == forRemove.parent.leftChild) {
            forRemove.leftChild.parent = forRemove.parent;
            forRemove.parent.leftChild = forRemove.leftChild;
        } else {
            forRemove.leftChild.parent = forRemove.parent;
            forRemove.parent.rightChild = forRemove.leftChild;
        }
    }

    private void deleteIfHasNotChild(Node<E> forRemove) {
        if (forRemove == root) {
            root = null;
        } else if (forRemove == forRemove.parent.leftChild) {
            forRemove.parent.leftChild = null;
        } else if (forRemove == forRemove.parent.rightChild) {
            forRemove.parent.rightChild = null;
        }
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public E[] toArray() {
        E[] arrayOfTree = (E[]) new Object[size];

        if (!this.isEmpty()) {
            int i = 0;
            Iterator<E> tree = new MyBstIterator();
            while (tree.hasNext()) {
                arrayOfTree[i++] = tree.next();
            }
        }
        return arrayOfTree;
    }

    public void showTree() {
        E[] arrayOfTree = toArray();
        for (int i = 0; i < size; i++) {
            System.out.print(arrayOfTree[i] + ", ");
        }
    }

    @Override
    public E lower(E e) {
        if (e == null) throw new NullPointerException();

        E[] arrayOfTree = toArray();
        E result = null;

        for (int i = 0; i < arrayOfTree.length; i++) {
            if (compareValues(e, arrayOfTree[i]) > 0) {
                result = arrayOfTree[i];
            }
        }
        return result;
    }

    private int compareValues(E e1, E e2) {
        Comparable<? super E> comparable = (Comparable<? super E>) e1;

        if (comparable.compareTo(e2) > 0) {
            return 1;
        } else if (comparable.compareTo(e2) < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public E floor(E e) {
        if (e == null) throw new NullPointerException();

        E[] arrayOfTree = toArray();
        E result = null;

        for (int i = 0; i < arrayOfTree.length; i++) {
            if (compareValues(e, arrayOfTree[i]) >= 0) {
                result = arrayOfTree[i];
            }
        }
        return result;
    }

    @Override
    public E ceiling(E e) {
        if (e == null) throw new NullPointerException();

        E[] arrayOfTree = toArray();
        E result = null;

        for (int i = arrayOfTree.length - 1; i > 0; i--) {
            if (compareValues(e, arrayOfTree[i]) <= 0) {
                result = arrayOfTree[i];
                break;
            }
        }
        return result;
    }

    @Override
    public E higher(E e) {
        if (e == null) throw new NullPointerException();

        E[] arrayOfTree = toArray();
        E result = null;

        for (int i = arrayOfTree.length - 1; i > 0; i--) {
            if (compareValues(e, arrayOfTree[i]) < 0) {
                result = arrayOfTree[i];
                break;
            }
        }
        return result;
    }

    @Override
    public E pollFirst() {
        if (isEmpty())
            return null;

        E[] arrayOfTree = toArray();
        E result = arrayOfTree[0];

        remove(arrayOfTree[0]);

        return result;
    }

    @Override
    public E pollLast() {
        if (isEmpty())
            return null;

        E[] arrayOfTree = toArray();
        E result = arrayOfTree[arrayOfTree.length - 1];

        remove(arrayOfTree[arrayOfTree.length - 1]);

        return result;
    }

    @Override
    public Comparator<E> comparator() {
        return null;
    }

    @Override
    public E first() {
        return getFirstNode(root).value;
    }

    private Node<E> getFirstNode(Node<E> root) {
        if (isEmpty()) throw new NoSuchElementException("BST is empty");

        Node<E> iterator = root;

        while (iterator.leftChild != null) {
            iterator = iterator.leftChild;
        }
        return iterator;
    }

    /**
     * Returns the last (highest) element currently in this set.
     *
     * @return the first (lowest) element currently in this set
     * @throws NoSuchElementException - if this set is empty
     */
    @Override
    public E last() {
        if (isEmpty()) throw new NoSuchElementException("BST is empty");

        Node<E> iterator = root;

        while (iterator.rightChild != null) {
            iterator = iterator.rightChild;
        }
        return iterator.value;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyBstIterator();
    }


    private static class Node<E> {
        private Node<E> parent;
        private Node<E> leftChild;
        private Node<E> rightChild;
        private E value;


        public Node(E value) {
            this.value = value;
        }

        public Node(Node<E> parent, E value) {
            this.parent = parent;
            this.value = value;
        }

        public Node(Node<E> parent) {
            this.parent = parent;
        }
    }

    private class MyBstIterator implements Iterator<E> {

        Node<E> iterator;
        private boolean flag = true;
        private int numberOfNodes = 0;

        MyBstIterator() {
            iterator = new Node<>(getFirstNode(root));
        }

        @Override
        public boolean hasNext() {
            if (numberOfNodes == size())
                return false;
            return iterator.parent != null || iterator.rightChild != null;
        }

        @Override
        public E next() {
            numberOfNodes++;

            if (iterator == root && flag) {
                flag = false;
            }
            if (iterator.rightChild != null) {

                if (iterator != root && isRightChild(iterator) && flag) {
                    iterator = iterator.parent;
                    return iterator.value;
                }
                hasRight();
            } else if (iterator.parent != null) {

                if (isRightChild(iterator)) {
                    iterator = iterator.parent.parent;
                    return iterator.value;
                }

                if (iterator == null) {
                    iterator = iterator.parent;
                    hasRight();
                } else {
                    iterator = iterator.parent;
                }
            }
            return iterator.value;
        }

        private void hasRight() {
            iterator = iterator.rightChild;
            while (iterator.leftChild != null) {
                iterator = iterator.leftChild;
            }
        }

        private boolean isRightChild(Node<E> node) {
            return node == node.parent.rightChild;
        }

    }
}