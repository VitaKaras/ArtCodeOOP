package main.test.java.SetTest;

import static org.junit.Assert.*;

import main.java.set.MyBinarySearchTree;
import main.java.set.NavigableSet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Vita on 23.11.2016.
 */
public abstract class NavigableSetTest<E> {
    protected NavigableSet<Integer> navSet;

    @Before
    public abstract void setUp();

    @After
    public void tearDown() {
        navSet = null;
    }

    private MyBinarySearchTree createTree(int i) {
        MyBinarySearchTree tree = new MyBinarySearchTree();
        if (i == 1) {
            tree.add(25);
            tree.add(24);
            tree.add(19);
            tree.add(18);
            tree.add(35);
            tree.add(34);
            tree.add(16);
            tree.add(11);
            tree.add(45);
            tree.add(20);
            tree.add(17);
            tree.add(15);
            tree.add(14);
            tree.add(13);
        } else if (i == 2) {
            tree.add(45);
            tree.add(40);
            tree.add(38);
            tree.add(89);
            tree.add(67);
            tree.add(41);
        } else if (i == 3) {
            tree.add(20);
        }
        return tree;
    }

    @Test
    public void testLower() {
        navSet = createTree(1);
        assertEquals(Integer.valueOf(18), navSet.lower(19));
        assertEquals(null, navSet.lower(9));
    }

    @Test
    public void testFloor() {
        navSet = createTree(1);
        assertEquals(Integer.valueOf(19), navSet.floor(19));
        assertEquals(Integer.valueOf(11), navSet.floor(12));
        assertEquals(null, navSet.floor(9));
    }

    @Test
    public void testCeiling() {
        navSet = createTree(1);
        assertEquals(Integer.valueOf(45), navSet.ceiling(19));
        assertEquals(Integer.valueOf(45), navSet.ceiling(45));
        assertEquals(Integer.valueOf(45), navSet.ceiling(9));
        assertEquals(null, navSet.ceiling(78));
    }

    @Test
    public void testHigher() {
        navSet = createTree(1);
        assertEquals(Integer.valueOf(45), navSet.higher(19));
        assertEquals(null, navSet.higher(45));
        assertEquals(Integer.valueOf(45), navSet.higher(9));
        assertEquals(null, navSet.higher(78));
    }

    @Test
    public void testPollFirst() {
        navSet = createTree(1);
        assertEquals(Integer.valueOf(11), navSet.pollFirst());
        navSet.clear();
        navSet.add(1);
        assertEquals(Integer.valueOf(1), navSet.pollFirst());
        assertEquals(null, navSet.pollFirst());

    }

    @Test
    public void testPollLast() {
        navSet = createTree(1);
        assertEquals(Integer.valueOf(45), navSet.pollLast());
        navSet.clear();
        navSet.add(1);
        assertEquals(Integer.valueOf(1), navSet.pollLast());
        assertEquals(null, navSet.pollLast());
    }

}
