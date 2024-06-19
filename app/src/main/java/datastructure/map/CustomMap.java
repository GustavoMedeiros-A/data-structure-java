package datastructure.map;

import java.util.HashMap;
import java.util.Map;

public class CustomMap<K, V> {

    private final Map<K, V> items;
    private int size;

    public CustomMap() {
        this.items = new HashMap<>();
        this.size = 0;
    }

    public V get(K key) {
        return items.get(key);
    }

    public void set(K key, V value) {

        if (!this.items.containsKey(key)) {
            size++;
        }

        this.items.put(key, value);
    }

    public void remove(K key) {
        V value = this.items.get(key);
        if (value != null) {
            size--;
        }

        this.items.remove(key);
    }

    public int size() {
        return this.size;
    }
}
