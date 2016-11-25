package main.test.java.SetTest;

import static org.junit.Assert.*;

import main.java.Collection;
import main.java.set.MyBinarySearchTree;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Vita on 13.11.16.
 */
public abstract class CollectionTest<E> {
    protected Collection<Integer> collection;

    //   create empty data structure
    @Before
    public abstract void setUp();

    @After
    public void tearDown() {
        collection = null;
    }

    @Test
    public void test_size_when_empty() {
        assertEquals(0, collection.size());
    }

    @Test
    public void test_isEmpty() {
        assertTrue(collection.isEmpty());
    }

    @Test
    public void test_isEmpty_after_adding() {
        assertTrue(collection.add(1));
        assertFalse(collection.isEmpty());
    }

    @Test
    public void test_first_add() {
        assertTrue(collection.add(1));
        assertEquals(1, collection.size());
    }

    @Test
    public void test_contains_when_true() {
        assertTrue(collection.add(1));
        assertTrue(collection.add(2));
        assertTrue(collection.add(3));
        assertTrue(collection.contains(3));
    }

    @Test
    public void test_add_few() {
        assertTrue(collection.add(1));
        assertTrue(collection.add(2));
        assertTrue(collection.add(3));
        assertEquals(3, collection.size());
    }

    @Test
    public void test_contains_when_false() {
        assertFalse(collection.contains("3"));
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
    public void testRemoveRightNodeIfHasNotChild() {
        collection = createTree(1);
        Object[] newTree = {11, 13, 14, 15, 16, 17, 18, 19, 20, 24, 25, 34, 35};
        assertTrue(collection.remove(45));
        assertFalse(collection.contains(45));
        assertTrue(Arrays.equals(newTree, collection.toArray()));
    }

    @Test
    public void testRemoveLeftNodeIfHasNotChild() {
        collection = createTree(2);
        Object[] newTree = {40, 41, 45, 67, 89};
        assertTrue(collection.remove(38));
        assertFalse(collection.contains(38));
        assertTrue(Arrays.equals(newTree, collection.toArray()));
    }

    @Test
    public void testRemoveRootIfHasNotChild() {
        collection = createTree(3);
        Object[] newTree = {};
        assertTrue(collection.remove(20));
        assertFalse(collection.contains(20));
        assertTrue(collection.isEmpty());
        assertTrue(Arrays.equals(newTree, collection.toArray()));
    }

    @Test
    public void testRemoveRightNodeIfHasOnlyRightChild() {
        collection = createTree(1);
        collection.add(46);
        Object[] newTree = {11, 13, 14, 15, 16, 17, 18, 19, 20, 24, 25, 34, 35, 46};
        assertTrue(collection.remove(45));
        assertFalse(collection.contains(45));
        assertTrue(Arrays.equals(newTree, collection.toArray()));
    }

    @Test
    public void testRemoveLeftNodeIfHasOnlyRightChild() {
        collection = createTree(2);
        collection.add(39);
        Object[] newTree = {39, 40, 41, 45, 67, 89};
        assertTrue(collection.remove(38));
        assertFalse(collection.contains(38));
        assertTrue(Arrays.equals(newTree, collection.toArray()));
    }

    @Test
    public void testRemoveRightNodeIfHasOnlyLeftChild() {
        collection = createTree(1);
        collection.add(44);
        Object[] newTree = {11, 13, 14, 15, 16, 17, 18, 19, 20, 24, 25, 34, 35, 44};
        assertTrue(collection.remove(45));
        assertFalse(collection.contains(45));
        assertTrue(Arrays.equals(newTree, collection.toArray()));
    }

    @Test
    public void testRemoveRightNodeIfHasOnlyLeftChild2() {
        collection = createTree(2);
        Object[] newTree = {38, 40, 41, 45, 67};
        assertTrue(collection.remove(89));
        assertFalse(collection.contains(89));
        assertTrue(Arrays.equals(newTree, collection.toArray()));
    }

    @Test
    public void testRemoveLeftNodeIfHasOnlyLeftChild() {
        collection = createTree(2);
        collection.add(37);
        Object[] newTree = {37, 40, 41, 45, 67, 89};
        assertTrue(collection.remove(38));
        assertFalse(collection.contains(38));
        assertTrue(Arrays.equals(newTree, collection.toArray()));
    }

    @Test
    public void testRemoveLeftNodeIfHasOnlyLeftChild2() {
        collection = createTree(1);
        Object[] newTree = {11, 13, 14, 15, 16, 17, 19, 20, 24, 25, 34, 35, 45};
        assertTrue(collection.remove(18));
        assertFalse(collection.contains(18));
        assertTrue(Arrays.equals(newTree, collection.toArray()));
    }

    @Test
    public void testRemoveLeftIfHasBothChild() {
        collection = createTree(1);
        Object[] newTree = {11, 13, 14, 15, 16, 17, 18, 20, 24, 25, 34, 35, 45};
        assertTrue(collection.remove(19));
        assertFalse(collection.contains(19));
        assertTrue(Arrays.equals(newTree, collection.toArray()));
    }

    @Test
    public void testRemoveRightIfHasBothChild() {
        collection = createTree(1);
        Object[] newTree = {11, 13, 14, 15, 16, 17, 18, 19, 20, 24, 25, 34, 45};
        assertTrue(collection.remove(35));
        assertFalse(collection.contains(35));
        assertTrue(Arrays.equals(newTree, collection.toArray()));
    }

    @Test
    public void testClear() {
        collection = createTree(1);
        assertTrue(collection.contains(11));
        collection.clear();
        assertEquals(0, collection.size());
    }

    @Test
    public void testToArray() {
        collection = createTree(1);
        Object[] newTree = {11, 13, 14, 15, 16, 17, 18, 19, 20, 24, 25, 34, 35, 45};
        assertTrue(Arrays.equals(newTree, collection.toArray()));
    }

}