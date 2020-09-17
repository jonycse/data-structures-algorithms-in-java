package dsalgo.sort;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import utils.SortUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BubbleSortTest {

    @Test
    public void test1() {
        int[] a = {1, -1, 10, 9, 27, 12, 19, 4};
        int n = a.length;

        BubbleSort.sort(a);

        Assert.assertTrue(SortUtils.isSortedArrayAsc(a));

        assertEquals(1, a[1]);
        assertEquals(27, a[n - 1]);
    }


    @Test
    public void test2() {
        int[] a = {1};
        int n = a.length;

        BubbleSort.sort(a);

        Assert.assertTrue(SortUtils.isSortedArrayAsc(a));
        //Log.info(a);

        assertEquals(1, (int) a[0]);
    }

    @Test
    public void test3() {
        int[] a = {1, 3};
        int n = a.length;

        BubbleSort.sort(a);

        Assert.assertTrue(SortUtils.isSortedArrayAsc(a));
        //Log.info(a);

        assertEquals(1, (int) a[0]);
        assertEquals(3, (int) a[n - 1]);
    }


    @Test
    public void test4() {
        int[] a = {1, 3, 5};
        int n = a.length;

        BubbleSort.sort(a);

        Assert.assertTrue(SortUtils.isSortedArrayAsc(a));
        //Log.info(a);

        assertEquals(1, (int) a[0]);
        assertEquals(3, (int) a[n - 2]);
        assertEquals(5, (int) a[n - 1]);
    }
}
