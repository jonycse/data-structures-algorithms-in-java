package recursion.gen47;

import org.junit.Assert;
import org.junit.Test;
import utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

public class Generate47Test {

    @Test
    public void test1() {
        int n = 1000;
        List<Integer> original = Generate47.generate(n);
        List<Integer> local = gen47Local(n);
        LogUtils.plInt(original);
        LogUtils.plInt(local);

        Assert.assertEquals(original.size(), local.size());
        for (int i = 0; i < local.size(); i++) {
            Assert.assertEquals(original.get(i), local.get(i));
        }
    }

    @Test
    public void test2() {
        int n = 500;
        List<Integer> original = Generate47.generate(n);
        List<Integer> local = gen47Local(n);

        Assert.assertEquals(original.size(), local.size());
        for (int i = 0; i < local.size(); i++) {
            Assert.assertEquals(original.get(i), local.get(i));
        }
    }

    @Test
    public void test3() {
        int n = 5000;
        List<Integer> original = Generate47.generate(n);
        List<Integer> local = gen47Local(n);

        Assert.assertEquals(original.size(), local.size());
        for (int i = 0; i < local.size(); i++) {
            Assert.assertEquals(original.get(i), local.get(i));
        }
    }

    @Test
    public void test4() {
        int n = 500000;
        List<Integer> original = Generate47.generate(n);
        List<Integer> local = gen47Local(n);

        Assert.assertEquals(original.size(), local.size());
        for (int i = 0; i < local.size(); i++) {
            Assert.assertEquals(original.get(i), local.get(i));
        }
    }

    private List<Integer> gen47Local(int n) {
        List<Integer> a = new ArrayList<>();
        for (int i = 4; i <= n; i++) {
            if (has47(i)) {
                a.add(i);
            }
        }
        return a;
    }

    private boolean has47(int num) {
        while (num > 0) {
            int d = num % 10;
            if (d != 4 && d != 7) {
                return false;
            }
            num = num / 10;
        }
        return true;
    }
}
