package recursion.fib;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class FibTest {

    @Test
    public void testFib() {
        Assert.assertEquals(0, Fib.fib(0));
        Assert.assertEquals(1, Fib.fib(1));
        Assert.assertEquals(1, Fib.fib(2));
        Assert.assertEquals(2, Fib.fib(3));
        Assert.assertEquals(3, Fib.fib(4));
        Assert.assertEquals(5, Fib.fib(5));
        Assert.assertEquals(8, Fib.fib(6));
        Assert.assertEquals(13, Fib.fib(7));
        Assert.assertEquals(21, Fib.fib(8));
        Assert.assertEquals(34, Fib.fib(9));
        Assert.assertEquals(55, Fib.fib(10));
    }
}
