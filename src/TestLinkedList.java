/**
 * Created by _red_ on 07.06.17.
 */
public class TestLinkedList<T> {

    private Node<T> tail;
    private Node<T> head;
    private int size;

    public TestLinkedList() {
        tail = new Node<T>(null, head, null);
        head = new Node<T>(null, null, tail);
    }

    public void addLast(T value){
        Node<T> prev = tail;
        prev.setData(value);
        tail = new Node<T>(null, prev, null);
        tail.setNext(prev);

        size++;
    }

    public void addFirst(T value){
        Node<T> next = head;
        next.setData(value);
        head = new Node<T>(null, null, next);
        head.setNext(next);

        size++;
    }

    public int size() { return this.size; }

    public class Node<T> {
        private Node<T> prev;
        private Node<T> next;
        private T data;

        public Node(T data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public Node<T> getPrev() { return prev; }
        public Node<T> getNext() { return next; }
        public T getData() { return data; }
        public void setPrev(Node<T> prev) { this.prev = prev; }
        public void setNext(Node<T> next) { this.next = next; }
        public void setData(T currentData) { this.data = currentData; }
    }
}
