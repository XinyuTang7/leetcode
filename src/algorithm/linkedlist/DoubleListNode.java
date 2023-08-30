package algorithm.linkedlist;

public class DoubleListNode<T> {

    public DoubleListNode before;
    public DoubleListNode next;
    public T value;

    public DoubleListNode(T value) {
        this.value = value;
    }
}
