package recursion.fib;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class FibMemoTest {

    @Test
    public void testFibMemo() {
        Assert.assertEquals(0, FibMemo.fib(0));
        Assert.assertEquals(1, FibMemo.fib(1));
        Assert.assertEquals(1, FibMemo.fib(2));
        Assert.assertEquals(2, FibMemo.fib(3));
        Assert.assertEquals(3, FibMemo.fib(4));
        Assert.assertEquals(5, FibMemo.fib(5));
        Assert.assertEquals(8, FibMemo.fib(6));
        Assert.assertEquals(13, FibMemo.fib(7));
        Assert.assertEquals(21, FibMemo.fib(8));
        Assert.assertEquals(34, FibMemo.fib(9));
        Assert.assertEquals(55, FibMemo.fib(10));
    }
}
