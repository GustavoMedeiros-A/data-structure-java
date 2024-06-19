package datastructure.ringBuffer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RingBufferTest<T> {
    private RingBuffer<Integer> ringBuffer;

    @BeforeEach
    public void setUp() {
        ringBuffer = new RingBuffer<>(5);
    }

    @Test
    public void testEnqueueAndDequeue() {
        ringBuffer.enqueue(1);
        ringBuffer.enqueue(2);
        ringBuffer.enqueue(3);

        assertEquals(1, ringBuffer.dequeue());
        assertEquals(2, ringBuffer.dequeue());
        assertEquals(3, ringBuffer.dequeue());
    }

    @Test
    public void testPeek() {
        ringBuffer.enqueue(1);
        ringBuffer.enqueue(2);

        assertEquals(Integer.valueOf(1), ringBuffer.peek());
        assertEquals(Integer.valueOf(1), ringBuffer.dequeue());
        assertEquals(Integer.valueOf(2), ringBuffer.peek());
    }
}
