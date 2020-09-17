package dsalgo.binarysearch;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {

    @Test
    public void testSmall() {
        int[] a = {1};

        Assert.assertEquals(0, BinarySearch.search(a, 1));
        Assert.assertEquals(-1, BinarySearch.search(a, 2));

        int[] b = {};

        Assert.assertEquals(-1, BinarySearch.search(b, 1));
        Assert.assertEquals(-1, BinarySearch.search(b, 2));
    }

    @Test
    public void testOddLength() {
        int[] a = {2, 5, 6, 9, 10};
        Assert.assertEquals(-1, BinarySearch.search(a, 1));
        Assert.assertEquals(-1, BinarySearch.search(a, 11));
        Assert.assertEquals(-1, BinarySearch.search(a, 100));
        Assert.assertEquals(4, BinarySearch.search(a, 10));
        Assert.assertEquals(0, BinarySearch.search(a, 2));
        Assert.assertEquals(1, BinarySearch.search(a, 5));
        Assert.assertEquals(3, BinarySearch.search(a, 9));
        Assert.assertEquals(2, BinarySearch.search(a, 6));
    }

    @Test
    public void testEvenLength() {
        int[] a = {2, 4, 5, 6};
        Assert.assertEquals(-1, BinarySearch.search(a, 1));
        Assert.assertEquals(-1, BinarySearch.search(a, 0));
        Assert.assertEquals(-1, BinarySearch.search(a, 10));
        Assert.assertEquals(0, BinarySearch.search(a, 2));
        Assert.assertEquals(1, BinarySearch.search(a, 4));
        Assert.assertEquals(2, BinarySearch.search(a, 5));
        Assert.assertEquals(3, BinarySearch.search(a, 6));
    }
}
