package main.test.java;

import main.java.myLists.MyArrayList;
import org.junit.Before;

/**
 * Created by Vita on 21.10.2016.
 */
public class TestMyArrayList extends ListTest {

    @Before
    public void init() {
        myList = new MyArrayList();
    }


}
