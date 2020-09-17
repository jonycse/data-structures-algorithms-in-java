package dsalgo.stackqueue;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class StackUsingQueueTest {

    @Test
    public void test1() {
        StackUsingQueue stack = new StackUsingQueue();
        try {
            stack.pop();
            Assert.assertTrue(false);
        } catch (RuntimeException e) {
        }
        stack.push(10);
        Assert.assertEquals(10, (int) stack.pop());
        try {
            stack.pop();
            Assert.assertTrue(false);
        } catch (RuntimeException e) {
        }

        stack.push(6);
        stack.push(5);
        stack.push(10);
        Assert.assertEquals(10, (int) stack.pop());
        Assert.assertEquals(5, (int) stack.pop());
        Assert.assertEquals(6, (int) stack.pop());
        try {
            stack.pop();
            Assert.assertTrue(false);
        } catch (RuntimeException e) {
        }
    }
}
