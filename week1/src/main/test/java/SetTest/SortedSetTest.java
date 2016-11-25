package main.test.java.SetTest;


import main.java.set.SortedSet;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Vita on 13.11.16.
 */
public abstract class SortedSetTest {
    protected SortedSet<String> set;

    @Before
    public abstract void setUp();

    @Test(expected = NoSuchElementException.class)
    public void test_first_when_empty() {
        set.first();
    }

    @Test(expected = NoSuchElementException.class)
    public void test_last_when_empty() {
        set.last();
    }

    @Test
    public void test_first() {
        assertTrue(set.add("1"));
        assertTrue(set.add("2"));
        assertTrue(set.add("3"));
        assertTrue(set.add("4"));
        assertEquals("1", set.first());
    }

    @Test
    public void test_last() {
        assertTrue(set.add("1"));
        assertTrue(set.add("2"));
        assertTrue(set.add("3"));
        assertTrue(set.add("4"));
        assertEquals("4", set.last());
    }

}