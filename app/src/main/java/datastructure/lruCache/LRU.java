package datastructure.lruCache;

import java.util.HashMap;
import java.util.Map;

// Least Recently Used

public class LRU<K, V> {

    public static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> prev;

        public Node(T value) {
            this.value = value;
        }
    }

    private int lenght;
    private final int capacity = 10;
    private Node<V> head;
    private Node<V> tail;

    private Map<K, Node<V>> lookup; // Go to the KEY to the node
    private Map<Node<V>, K> reverseLookup; // Go to the Node back to the KEY

    public LRU(int capacity) {
        capacity = 10;
        this.lenght = 0;
        this.head = this.tail = null;
        this.lookup = new HashMap<K, Node<V>>();
        this.reverseLookup = new HashMap<Node<V>, K>();
    }

    public void update(K key, V value) {
        // does it exist?
        // call get();
        var node = this.lookup.get(key);
        if (node == null) {
            node = this.createNode(value);
            this.lenght++;
            this.prepend(node);
            this.trimCache();

            this.lookup.put(key, node);
            this.reverseLookup.put(node, key);
        } else {
            // Move the current Nonde that already exists to the front of the list
            this.detach(node);
            this.prepend(node);
            node.value = value;
        }

        // it does exist
        // Move to the FRONT of the linkedList
    }

    public V get(K key) {
        // check the cache for existence
        Node<V> node = this.lookup.get(key);
        if (node == null) {
            return null;
        }
        // update the value we found and move to the front
        this.detach(node);
        this.prepend(node);
        // return the vaue we found or undefined if not exists
        return node.value;
    }

    // Para mover o nó para frente da lista ou quando está sendo removido
    private void detach(Node<V> node) {

        if (node.prev != null) {
            node.prev.next = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }

        if (this.lenght == 1) {
            this.head = this.tail = null;
        }

        if (this.head == node) {
            this.head = this.head.next;
        }

        if (this.tail == node) {
            this.tail = this.tail.prev;
        }

        node.next = null;
        node.prev = null;
    }

    // Adiciona o Nó na frente da list
    private void prepend(Node<V> node) {
        if (this.head == null) {
            this.head = this.tail = null;
            return;
        }

        node.next = this.head;
        this.head.prev = node;
        this.head = node;
    }

    private Node<V> createNode(V value) {
        return new Node<>(value);
    }

    private void trimCache() {
        if (this.lenght <= this.capacity) {
            return;
        }

        Node<V> tail = this.tail;
        this.detach(this.tail);

        var key = this.reverseLookup.get(tail);
        this.lookup.remove(key);
        this.reverseLookup.remove(tail);

        this.lenght--;
    }

}
