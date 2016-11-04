package main.test.java;

import main.java.myLists.MyLinkedList;
import main.java.myLists.MyList;
import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;

/**
 * Created by Vita on 23.10.16.
 */
public class MyLinkedListTest extends ListTest {
    @Override
    public void init() {
        myList = new MyLinkedList();

    }

    @Test
    public void testIterator() {

        myList.add("1");
        myList.add("2");
        myList.add("3");

        Iterator iterator = myList.iterator();

        for (int i = 0; i < myList.size(); i++) {
            assertSame(iterator.next(), myList.get(i));
        }
    }

    @Test
    public void testIteratorWhenListEmpty() {
        Iterator iterator = myList.iterator();

        assertFalse(iterator.hasNext());
    }
}