package dsalgo.stackqueue;

/**
 * Implement generic queue
 */
public class Queue<T> {
    private int front;
    private int rear;
    private int capacity;
    private T[] a;

    public Queue(int capacity) {
        this.capacity = capacity;
        a = (T[]) new Object[capacity];

        front = 0;
        rear = 0;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return front == capacity;
    }

    public void enqueue(T data) {
        if (isFull()) {
            throw new RuntimeException("Out of capacity");
        }
        a[front++] = data;
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        return a[rear++];
    }

    public T top() {
        if (isEmpty()) {
            return null;
        }
        return a[rear];
    }
}
