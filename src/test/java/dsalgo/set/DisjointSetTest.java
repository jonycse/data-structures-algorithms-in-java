package dsalgo.set;

import org.junit.Assert;
import org.junit.Test;

public class DisjointSetTest {

    @Test
    public void test1() {

        // n = 11
        // (2 4 6) (1 3 5) (7 9 10 8)

        DisjointSet set = new DisjointSet(11);
        // group 1
        set.union(2, 6);
        set.union(4, 6);

        // group 2
        set.union(5, 3);
        set.union(3, 1);

        // group 3
        set.union(7, 10);
        set.union(9, 8);
        set.union(10, 8);

        Assert.assertTrue(set.connected(2, 4));
        Assert.assertTrue(set.connected(6, 4));
        Assert.assertTrue(set.connected(6, 2));

        Assert.assertTrue(set.connected(1, 3));
        Assert.assertTrue(set.connected(5, 3));

        Assert.assertTrue(set.connected(7, 10));
        Assert.assertTrue(set.connected(9, 10));
        Assert.assertTrue(set.connected(8, 10));

        Assert.assertTrue(set.connected(11, 11));

        Assert.assertFalse(set.connected(10, 11));
        Assert.assertFalse(set.connected(10, 1));
        Assert.assertFalse(set.connected(10, 4));
        Assert.assertFalse(set.connected(5, 9));
        Assert.assertFalse(set.connected(1, 4));
        Assert.assertFalse(set.connected(2, 8));

    }
}
