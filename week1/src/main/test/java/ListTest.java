package main.test.java;


import main.java.myLists.MyList;
import org.junit.*;

/**
 * Created by Vita on 16.10.16.
 */
public abstract class ListTest {

    protected MyList myList;

    @Before
    public abstract void init();

    @After
    public void tearDown() {
        myList = null;
        System.out.println("After");

    }

    @Test
    public void myListTest() {
        boolean actual = myList.add("1");
        Assert.assertTrue(actual);
    }

    @Test
    public void testmyListSizeAfterAdd() {
        myList.add("1");
        myList.add(1, "9");

        int result = myList.size();

        Assert.assertEquals(2, result);
    }

    @Test
    public void testmyListAddTooElements() {
        myList.add("1");
        myList.add("2");

        Assert.assertEquals(2, myList.size());
        Assert.assertEquals("1", myList.get(0));
        Assert.assertEquals("2", myList.get(1));
    }

    @Test
    public void testmyListSizeAfterAddMoreThanCapacity() {
        myList.add("1");
        myList.add("2");
        myList.add("3");
        myList.add("4");
        myList.add("5");
        myList.add("6");
        myList.add("7");
        myList.add("8");
        myList.add("9");
        myList.add("10");
        myList.add("11");

        Assert.assertEquals(11, myList.size());
    }

    @Test
    public void testIsEmpty() {
        Assert.assertEquals(0, myList.size());
        Assert.assertEquals(true, myList.isEmpty());

        myList.add("1");
        Assert.assertEquals(false, myList.isEmpty());

    }

    @Test
    public void testContains() {
        myList.add("1");
        myList.add("2");
        myList.add("1");
        myList.add("1");
        myList.add("5");
        myList.add("1");
        myList.add("7");

        Assert.assertEquals(true, myList.contains("1"));
        Assert.assertEquals(false, myList.contains("0"));
        Assert.assertEquals(false, myList.contains(null));
    }

    @Test
    public void testRemoveObjectByIndex() {
        myList.add("1");
        myList.add("2");
        myList.add("1");
        myList.add("1");
        myList.add("5");

        Assert.assertEquals("2", myList.remove(1));
        Assert.assertEquals("1", myList.remove(0));
        Assert.assertEquals("5", myList.remove(2));
        Assert.assertEquals(2, myList.size());
    }

    @Test
    public void testIndexOf() {
        myList.add("1");
        myList.add("2");
        myList.add("1");
        myList.add("1");
        myList.add("5");

        Assert.assertEquals(0, myList.indexOf("1"));
        Assert.assertEquals(4, myList.indexOf("5"));
        Assert.assertEquals(-1, myList.indexOf(null));
    }

    @Test
    public void testRemoveObject() {
        myList.add("1");
        myList.add("2");
        myList.add("1");
        myList.add("1");
        myList.add("5");

        Assert.assertEquals(true, myList.remove("1"));
        Assert.assertEquals(true, myList.remove("1"));
        Assert.assertEquals(true, myList.remove("1"));
        Assert.assertEquals(2, myList.size());
        Assert.assertEquals(false, myList.contains("1"));
    }

    @Test
    public void testClear() {
        myList.add("1");
        myList.add("2");
        myList.add("1");

        myList.clear();

        Assert.assertEquals(0, myList.size());

    }

    @Test
    public void testGet() {
        myList.add("1");
        myList.add("2");
        myList.add("1");

        Assert.assertEquals("2", myList.get(1));
        Assert.assertEquals("1", myList.get(0));
    }

    @Test
    public void testSet() {
        myList.add("1");
        myList.add("2");
        myList.add("1");

        Assert.assertEquals("2", myList.set(1, "5"));
        Assert.assertEquals("1", myList.set(2, null));
        Assert.assertEquals(1, myList.indexOf("5"));
        Assert.assertEquals(2, myList.indexOf(null));
        Assert.assertEquals(-1, myList.indexOf("2"));
    }

    @Test
    public void addElementByIndex() {
        myList.add("1");
        myList.add("2");
        myList.add("1");

        myList.add(2, "5");
        myList.add(0, "7");

        Assert.assertEquals(3, myList.indexOf("5"));
        Assert.assertEquals(1, myList.indexOf("1"));

    }

    @Test
    public void testLastIndexOf() {
        myList.add("1");
        myList.add("2");
        myList.add("1");
        myList.add("1");
        myList.add("5");

        Assert.assertEquals(3, myList.lastIndexOf("1"));
        Assert.assertEquals(-1, myList.lastIndexOf(null));

    }

    @Test
    public void testToArray() {
        myList.add("1");
        myList.add("2");
        myList.add(null);
        myList.add("1");
        myList.add("5");

        Object[] array = myList.toArray();

        Assert.assertEquals("2", array[1]);
        Assert.assertEquals(null, array[2]);
        Assert.assertEquals("5", array[4]);

    }


}
