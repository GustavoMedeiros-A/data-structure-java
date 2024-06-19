package datastructure.ringBuffer;

// this.tail % lenght -> Make the ring buffer works
public class RingBuffer<T> {
    private final T[] buffer;
    private int head;
    private int tail;
    private int size;
    private final int capacity;

    @SuppressWarnings("unchecked")
    public RingBuffer(int capacity) {
        this.buffer = (T[]) new Object[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
        this.capacity = capacity;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(T item) {
        if (isFull()) {
            throw new IllegalStateException("Buffer is full");
        }
        buffer[tail] = item;
        tail = (tail + 1) % capacity;
        size++;

        // Update Tail:
        // After adding the element, we move the tail pointer to the next position.
        // If the tail reaches the end of the buffer, it wraps around to the beginning
        // using the modulo operation.
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Buffer is empty");
        }
        T item = buffer[head];
        head = (head + 1) % capacity;
        size--;
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer is empty");
        }
        return buffer[head];
    }
}
