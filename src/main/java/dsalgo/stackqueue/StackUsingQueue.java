package dsalgo.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    public StackUsingQueue() {
    }

    public void push(int x) {

        while (!queue1.isEmpty()) {
            queue2.add(queue1.poll());
        }

        this.queue1.add(x);

        while (!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
    }

    public Integer pop() {
        Integer x = queue1.poll();
        if (x == null) {
            throw new RuntimeException("underflow");
        }
        return x;
    }
}
