package algorithm.linkedlist;

public class ReverseDoubleLinkedList {

    public static DoubleListNode reverseDoubleLinkedList(DoubleListNode head) {
        DoubleListNode pre = null;
        while(head != null){
            DoubleListNode next = head.next;
            head.before = next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        DoubleListNode node1 = new DoubleListNode(1);
        DoubleListNode node2 = new DoubleListNode(2);
        DoubleListNode node3 = new DoubleListNode(3);
        DoubleListNode node4 = new DoubleListNode(4);
        DoubleListNode node5 = new DoubleListNode(5);
        node1.before = null;
        node1.next = node2;
        node2.before = node1;
        node2.next = node3;
        node3.next = node4;
        node3.before = node2;
        node4.next = node5;
        node4.before = node3;
        node5.next = null;
        node5.before = node4;
        DoubleListNode reverseNode = reverseDoubleLinkedList(node1);
        while(reverseNode != null){
            System.out.print( reverseNode.value + "->");
            reverseNode = reverseNode.next;
        }
    }
}
