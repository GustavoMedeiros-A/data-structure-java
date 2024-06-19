package datastructure.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import datastructure.bubbleSort.Queue;

public class QueueTest {
    private Queue<Integer> queue;

    @BeforeEach
    public void setUp() {
        queue = new Queue<>();
    }

    @Test
    void shouldQueueAndDequeue() {
        queue.enqueue(1);
        queue.enqueue(2);

        assertEquals(queue.lenght, 2);
        assertEquals(queue.returnPeek(), 1);

        queue.dequeue();

        assertEquals(queue.returnPeek(), 2);
    }
}
