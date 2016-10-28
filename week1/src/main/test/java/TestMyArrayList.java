package main.test.java;

import main.java.myArrayList.MyArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Vita on 21.10.2016.
 */
public class testMyArrayList {

    private MyArrayList myArrayList;

    @Before
    public void init() {
        myArrayList = new MyArrayList();
        System.out.println("Before");
    }

    @Test
    public void myArrayListTest() {
        System.out.println("Test1");

        boolean actual = myArrayList.add("1");

        Assert.assertTrue(actual);
    }

    @Test
    public void testMyArrayListSizeAfterAdd() {
        System.out.println("Test2");

        myArrayList.add("1");
        myArrayList.add(1, "9");

        int result = myArrayList.size();

        Assert.assertEquals("Some description", 2, result);
    }

    @Test
    public void testMyArrayListAddTooElements() {
        System.out.println("Test3");

        myArrayList.add("1");
        myArrayList.add("2");

        Assert.assertEquals(2, myArrayList.size());
        Assert.assertEquals("1", myArrayList.get(0));
        Assert.assertEquals("2", myArrayList.get(1));
    }

    @Test
    public void testMyArrayListSizeAfterAddMoreThanCapacity() {
        System.out.println("Test4");

        myArrayList.add("1");
        myArrayList.add("2");
        myArrayList.add("3");
        myArrayList.add("4");
        myArrayList.add("5");
        myArrayList.add("6");
        myArrayList.add("7");
        myArrayList.add("8");
        myArrayList.add("9");
        myArrayList.add("10");
        myArrayList.add("11");

        Assert.assertEquals("Some description", 11, myArrayList.size());
    }

    @Test
    public void testIsEmpty() {
        System.out.println("Test5");

        Assert.assertEquals("Some description", 0, myArrayList.size());
        Assert.assertEquals("Some description", true, myArrayList.isEmpty());

        myArrayList.add("1");
        Assert.assertEquals("Some description", false, myArrayList.isEmpty());

    }

    @Test
    public void testContains(){
        System.out.println("Test6");

        myArrayList.add("1");
        myArrayList.add("2");
        myArrayList.add("1");
        myArrayList.add("1");
        myArrayList.add("5");
        myArrayList.add("1");
        myArrayList.add("7");

        Assert.assertEquals("Some description", true, myArrayList.contains("1"));
        Assert.assertEquals("Some description", false, myArrayList.contains("0"));
        Assert.assertEquals("Some description", false, myArrayList.contains(null));
    }

    @Test
    public void testRemoveObjectByIndex(){
        System.out.println("Test7");

        myArrayList.add("1");
        myArrayList.add("2");
        myArrayList.add("1");
        myArrayList.add("1");
        myArrayList.add("5");

        Assert.assertEquals("Some description", "2", myArrayList.remove(1));
        Assert.assertEquals("Some description", "1", myArrayList.remove(0));
        Assert.assertEquals("Some description", "5", myArrayList.remove(2));
        Assert.assertEquals("Some description", 2, myArrayList.size());
    }

    @Test
    public void testIndexOf(){
        System.out.println("Test8");

        myArrayList.add("1");
        myArrayList.add("2");
        myArrayList.add("1");
        myArrayList.add("1");
        myArrayList.add("5");

        Assert.assertEquals("Some description", 0, myArrayList.indexOf("1"));
        Assert.assertEquals("Some description", 4, myArrayList.indexOf("5"));
        Assert.assertEquals("Some description", -1, myArrayList.indexOf(null));
    }

    @Test
    public void testRemoveObject(){
        System.out.println("Test9");

        myArrayList.add("1");
        myArrayList.add("2");
        myArrayList.add("1");
        myArrayList.add("1");
        myArrayList.add("5");

        Assert.assertEquals("Some description", true, myArrayList.remove("1"));
        Assert.assertEquals("Some description", true, myArrayList.remove("1"));
        Assert.assertEquals("Some description", true, myArrayList.remove("1"));
        Assert.assertEquals("Some description", 2, myArrayList.size());
        Assert.assertEquals("Some description", false, myArrayList.contains("1"));
    }

    @Test
    public void testClear(){
        System.out.println("Test10");

        myArrayList.add("1");
        myArrayList.add("2");
        myArrayList.add("1");

        myArrayList.clear();

        Assert.assertEquals("Some description", 0, myArrayList.size());

    }

    @Test
    public void testGet(){
        System.out.println("Test11");

        myArrayList.add("1");
        myArrayList.add("2");
        myArrayList.add("1");

        Assert.assertEquals("Some description", "2", myArrayList.get(1));
        Assert.assertEquals("Some description", "1", myArrayList.get(0));
    }

    @Test
    public void testSet(){
        System.out.println("Test12");

        myArrayList.add("1");
        myArrayList.add("2");
        myArrayList.add("1");

        Assert.assertEquals("Some description", "2",myArrayList.set(1, "5"));
        Assert.assertEquals("Some description", "1",myArrayList.set(2, null));
        Assert.assertEquals("Some description", 1, myArrayList.indexOf("5"));
        Assert.assertEquals("Some description", 2, myArrayList.indexOf(null));
        Assert.assertEquals("Some description", -1, myArrayList.indexOf("2"));
    }

    @Test
    public void addElementByIndex(){
        System.out.println("Test13");

        myArrayList.add("1");
        myArrayList.add("2");
        myArrayList.add("1");

        myArrayList.add(2, "5");
        myArrayList.add(0, "7");

        Assert.assertEquals("Some description", 3, myArrayList.indexOf("5"));
        Assert.assertEquals("Some description", 1, myArrayList.indexOf("1"));

    }

    @Test
    public void testLastIndexOf(){
        System.out.println("Test14");

        myArrayList.add("1");
        myArrayList.add("2");
        myArrayList.add("1");
        myArrayList.add("1");
        myArrayList.add("5");

        Assert.assertEquals("Some description", 3, myArrayList.lastIndexOf("1"));
        Assert.assertEquals("Some description", -1, myArrayList.lastIndexOf(null));

    }

    @Test
    public void testToArray(){
        System.out.println("Test15");

        myArrayList.add("1");
        myArrayList.add("2");
        myArrayList.add(null);
        myArrayList.add("1");
        myArrayList.add("5");

        Object[] array = myArrayList.toArray();

        Assert.assertEquals("Some description", "2", array[1]);
        Assert.assertEquals("Some description", null, array[2]);
        Assert.assertEquals("Some description", "5", array[4]);

    }
}
