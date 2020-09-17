package dsalgo.stackqueue;

/**
 * Implement generic stack
 */
public class Stack<T> {

    private int capacity;
    T[] stack;
    private int top;

    public Stack(int capacity) {
        this.capacity = capacity;

        stack = (T[]) new Object[capacity];
        top = 0;
    }

    public void push(T item) {
        if (isFull()) {
            throw new RuntimeException("Overflow");
        }
        stack[top++] = item;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Underflow");
        }
        return stack[--top];
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Empty stack");
        }
        return stack[top - 1];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public boolean isFull() {
        return top == capacity;
    }
}
