package main.test.java.SetTest;

import main.test.java.SetTest.BSTCollectionTest;
import main.test.java.SetTest.BSTSortedSetTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Vita on 20.11.2016.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BSTCollectionTest.class,
        BSTSortedSetTest.class,
        BSTNavigableSet.class
})
public class BstTestSuit {
}
