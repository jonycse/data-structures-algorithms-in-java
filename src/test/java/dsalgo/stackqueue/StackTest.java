package dsalgo.stackqueue;

import org.junit.Assert;
import org.junit.Test;

public class StackTest {


    @Test
    public void test1(){
        Stack<String> stack = new Stack<>(3);

        try {
            stack.pop();
            Assert.assertTrue(false);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            Assert.assertEquals(true, stack.isEmpty());
        }

        stack.push("A");
        Assert.assertEquals("A",stack.pop());
        Assert.assertEquals(true, stack.isEmpty());
        Assert.assertEquals(false, stack.isFull());

        stack.push("A");
        stack.push("B");
        Assert.assertEquals("B",stack.pop());

        stack.push("B");
        stack.push("C");

        Assert.assertEquals(true, stack.isFull());
        try {
            stack.push("D");
            Assert.assertTrue(false);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        Assert.assertEquals("C",stack.peek());
        Assert.assertEquals("C",stack.pop());
        Assert.assertEquals(false, stack.isFull());
        Assert.assertEquals("B",stack.pop());
        Assert.assertEquals("A",stack.pop());

        Assert.assertEquals(true, stack.isEmpty());
        Assert.assertEquals(false, stack.isFull());

    }

    @Test
    public void test2(){

        Stack<Integer> stackInt = new Stack<>(3);
        stackInt.push(1);
        Assert.assertEquals(false, stackInt.isEmpty());
        stackInt.push(2);
        Assert.assertEquals(2, (int)stackInt.peek());
        Assert.assertEquals(2, (int)stackInt.pop());
        Assert.assertEquals(1, (int)stackInt.peek());
        Assert.assertEquals(1, (int)stackInt.pop());
        Assert.assertEquals(true, stackInt.isEmpty());


        Assert.assertEquals(false, stackInt.isFull());
        stackInt.push(10);
        Assert.assertEquals(false, stackInt.isFull());
        stackInt.push(20);
        Assert.assertEquals(false, stackInt.isFull());
        stackInt.push(30);
        Assert.assertEquals(true, stackInt.isFull());

        Assert.assertEquals(false, stackInt.isEmpty());
        Assert.assertEquals(30, (int)stackInt.pop());
        Assert.assertEquals(false, stackInt.isEmpty());
        Assert.assertEquals(20, (int)stackInt.pop());
        Assert.assertEquals(10, (int)stackInt.pop());
        Assert.assertEquals(true, stackInt.isEmpty());
    }
}
