package datastructure;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BubbleSortTest {

    @Test
    void shouldOrderTheArray() {
        int[] arr = { 100, 20, 1, 30 };
        int[] expected = { 1, 20, 30, 100 };

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }

}
