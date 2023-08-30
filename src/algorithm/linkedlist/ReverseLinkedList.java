package algorithm.linkedlist;

public class ReverseLinkedList {

    public static ListNode reverseLinkedList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode firstNode = new ListNode(0);
        ListNode head = firstNode;
        for (int i = 1; i <= 5; i++) {
            ListNode node = new ListNode(i);
            head.next = node;
            head = head.next;
        }
        printListNoe(firstNode.next);
        printListNoe(reverseLinkedList(firstNode.next));
    }

    private static void printListNoe(ListNode head) {
        while (head != null) {
            System.out.print(head.value + ", ");
            head = head.next;
        }
    }
}
