package main.test.java.SetTest;

import main.java.set.MyBinarySearchTree;

/**
 * Created by Vita on 23.11.2016.
 */
public class BSTNavigableSet extends NavigableSetTest {
    @Override
    public void setUp() {
        navSet = new MyBinarySearchTree<>();
    }
}
