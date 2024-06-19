package datastructure.queue;

public class Queue<T> {
    public static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    public int lenght;
    private Node<T> head;
    private Node<T> tail;

    public Queue() {
        this.lenght = 0;
        this.head = this.tail = null;
    }

    public int getLenght() {
        return lenght;
    }

    public void enqueue(T item) {
        var newNode = new Node<>(item);
        if (this.tail != null) {
            this.tail.next = newNode;
        }
        this.tail = newNode;
        if (this.head == null) {
            this.head = newNode;
        }
        this.lenght++;
    }

    public T dequeue() {
        if (this.head == null) {
            return null;
        }

        var oldHead = this.head;
        this.head = this.head.next;
        oldHead.next = null;
        this.lenght--;
        return head.value;
    }

    public T returnPeek() {
        return this.head.value;
    }

}
