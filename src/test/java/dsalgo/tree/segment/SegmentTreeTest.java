package dsalgo.tree.segment;

import org.junit.Assert;
import org.junit.Test;
import utils.LogUtils;

public class SegmentTreeTest {

    @Test
    public void test1() {
        int[] a = {1, 3, -2, 8, -7};

        System.out.println("Running segment tree test");
        SegmentTree tree = new SegmentTree(a);
        System.out.println("Input ");
        LogUtils.paInt(a);
        System.out.println("Tree");
        LogUtils.paInt(tree.getTree());

        Assert.assertEquals(15, tree.getTree().length);

        Assert.assertEquals(3, tree.getSum(0, 4));
        Assert.assertEquals(2, tree.getSum(0, 2));
        Assert.assertEquals(4, tree.getSum(0, 1));

        Assert.assertEquals(9, tree.getSum(1, 3));
        Assert.assertEquals(-1, tree.getSum(2, 4));


        Assert.assertEquals(-7, tree.getSum(4, 4));
        Assert.assertEquals(3, tree.getSum(1, 1));

        tree.update(5, 1);
        Assert.assertEquals(5, tree.getSum(0, 4));
        // {1, 5, -2, 11, -4};
        tree.update(-4, 4);
        tree.update(11, 3);
        Assert.assertEquals(11, tree.getSum(0, 4));
        Assert.assertEquals(-4, tree.getSum(4, 4));
        Assert.assertEquals(11, tree.getSum(3, 3));
        Assert.assertEquals(7, tree.getSum(3, 4));
    }

    @Test
    public void test2() {
        int[] a = {7, 2, 7, 2, 0};
        System.out.println("Running segment tree test2");
        SegmentTree tree = new SegmentTree(a);

        tree.update(6, 4);
        tree.update(2, 0);
        tree.update(9, 0);

        Assert.assertEquals(6, tree.getSum(4, 4));

        LogUtils.paInt(tree.getTree());
        tree.update(8, 3);
        LogUtils.paInt(tree.getTree());
        Assert.assertEquals(32, tree.getSum(0, 4));
    }


    @Test
    public void test3() {
        int[] a = {2, 3, -1, 5, -2, 4, 8, 10};
        System.out.println("Running segment tree test3");
        SegmentTree tree = new SegmentTree(a);

        Assert.assertEquals(15, tree.getTree().length);

        Assert.assertEquals(29, tree.getSum(0, 7));
        Assert.assertEquals(9, tree.getSum(0, 3));
        Assert.assertEquals(5, tree.getSum(0, 1));
        Assert.assertEquals(3, tree.getSum(1, 1));
        Assert.assertEquals(20, tree.getSum(4, 7));
        Assert.assertEquals(2, tree.getSum(4, 5));
        Assert.assertEquals(4, tree.getSum(5, 5));
        Assert.assertEquals(18, tree.getSum(6, 7));

        tree.update(10, 3);
        Assert.assertEquals(34, tree.getSum(0, 7));
        Assert.assertEquals(10, tree.getSum(3, 3));
        Assert.assertEquals(14, tree.getSum(0, 3));
        Assert.assertEquals(9, tree.getSum(2, 3));
        tree.update(8, 7);
        Assert.assertEquals(32, tree.getSum(0, 7));
        Assert.assertEquals(16, tree.getSum(6, 7));
        Assert.assertEquals(18, tree.getSum(4, 7));
    }

    @Test
    public void test4() {
        int[] a = {2, 3, -1, 5, -2, 4, 8, 10, 10};
        System.out.println("Running segment tree test3");
        SegmentTree tree = new SegmentTree(a);

        Assert.assertEquals(39, tree.getSum(0, 8));
        Assert.assertEquals(29, tree.getSum(0, 7));
        Assert.assertEquals(20, tree.getSum(7, 8));
        Assert.assertEquals(28, tree.getSum(6, 8));
    }
}
