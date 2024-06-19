package datastructure.map;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomMapTest {
    private CustomMap<String, Integer> map;

    @BeforeEach
    void setUp() {
        map = new CustomMap<>();
    }

    @Test
    void shouldTestMap() {
        map.set("foo", 2);
        map.set("test", 4);

        assertEquals(map.get("foo"), 2);
        assertEquals(map.get("test"), 4);
        assertEquals(2, map.size());
        map.remove("test");
        assertEquals(map.size(), 1);

    }
}
