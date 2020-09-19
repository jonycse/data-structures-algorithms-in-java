package recursion.subset;

import org.junit.Assert;
import org.junit.Test;
import utils.ArrayUtils;
import utils.LogUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class SubsetTest {

    @Test
    public void test1() {

        Subset subsets = new Subset(4);

        Assert.assertEquals(16, subsets.getSubSets().size());
    }

    @Test
    public void test2() {

        Subset subsets = new Subset(3);

        List<Set<Integer>> sets = subsets.getSubSets();
        Assert.assertEquals(8, sets.size());
        Assert.assertTrue(ArrayUtils.isEqualI(Arrays.asList(), sets.get(0)));
        Assert.assertTrue(ArrayUtils.isEqualI(Arrays.asList(0), sets.get(1)));
        Assert.assertTrue(ArrayUtils.isEqualI(Arrays.asList(0, 1), sets.get(2)));
        Assert.assertTrue(ArrayUtils.isEqualI(Arrays.asList(0, 1, 2), sets.get(3)));
        Assert.assertTrue(ArrayUtils.isEqualI(Arrays.asList(0, 2), sets.get(4)));
        Assert.assertTrue(ArrayUtils.isEqualI(Arrays.asList(1), sets.get(5)));
        Assert.assertTrue(ArrayUtils.isEqualI(Arrays.asList(1, 2), sets.get(6)));
        Assert.assertTrue(ArrayUtils.isEqualI(Arrays.asList(2), sets.get(7)));
    }


    @Test
    public void test3() {

        Subset subsets = new Subset(5);

        Assert.assertEquals(32, subsets.getSubSets().size());
    }


    private void logSubSets(List<Set<Integer>> sets) {
        System.out.println("Sunset size : " + sets.size());
        int cnt = 1;
        for (Set<Integer> set : sets) {
            System.out.println(cnt + " : " + LogUtils.psInt(set, false));
            cnt++;
        }

    }
}
