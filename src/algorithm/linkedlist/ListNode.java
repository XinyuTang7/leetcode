package algorithm.linkedlist;



public class ListNode<T> {

    public ListNode<T> next;
    public T value;

    public ListNode() {
    }

    public ListNode(T value) {
        this.value = value;
    }

    public ListNode(T value,ListNode<T> next) {
        this.value = value;
        this.next = next;
    }
}
