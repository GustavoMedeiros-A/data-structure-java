package datastructure.lruCache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class LRUTest {

    @Test
    void shouldCreateLRUCacheAndGet() {
        LRU<Integer, String> lru = new LRU<>(3);

        lru.update(1, "a");

        assertEquals(lru.get(1), "a");
    }

    @Test
    void shouldCreateLRUCacheAndGetAWrong() {
        LRU<Integer, String> lru = new LRU<>(3);

        lru.update(1, "a");

        assertEquals(lru.get(2), null);
    }

    @Test
    void shouldCreateLRUCacheAndAddMoreThatTheCapacity() {
        LRU<Integer, String> lru = new LRU<>(3);

        lru.update(1, "a");
        lru.update(2, "b");
        lru.update(3, "c");
        lru.update(4, "d");
        lru.update(5, "e");

        assertNull(lru.get(1));
        assertNull(lru.get(2));
        assertNotNull(lru.get(3));
    }

}
