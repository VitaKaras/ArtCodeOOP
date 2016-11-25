package main.test.java.SetTest;

import main.java.set.MyBinarySearchTree;

/**
 * Created by Vita on 13.11.2016.
 */
public class BSTCollectionTest<E> extends CollectionTest<E> {

    @Override
    public void setUp() {
        collection = new MyBinarySearchTree<>();
    }
}
