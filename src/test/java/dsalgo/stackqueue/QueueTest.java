package dsalgo.stackqueue;

import org.junit.Assert;
import org.junit.Test;

public class QueueTest {


    @Test
    public void test1(){

        Queue<Integer> queue = new Queue<>(5);

        Assert.assertEquals(null, queue.dequeue());
        Assert.assertEquals(true, queue.isEmpty());
        Assert.assertEquals(false, queue.isFull());
        queue.enqueue(15);
        queue.enqueue(6);
        Assert.assertEquals(15, (int)queue.top());
        Assert.assertEquals(15, (int)queue.dequeue());
        Assert.assertEquals(6, (int)queue.dequeue());

        Assert.assertEquals(false, queue.isFull());
        queue.enqueue(66);
        queue.enqueue(8);
        queue.enqueue(10);
        Assert.assertEquals(true, queue.isFull());
        try {

            queue.enqueue(11);
            Assert.assertTrue(false);
        }catch (RuntimeException e){
            Assert.assertTrue(true);
        }
        Assert.assertEquals(false, queue.isEmpty());
        Assert.assertEquals(66, (int)queue.dequeue());
        Assert.assertEquals(8, (int)queue.dequeue());
        Assert.assertEquals(10, (int)queue.dequeue());
        Assert.assertEquals(true, queue.isEmpty());
    }
}
