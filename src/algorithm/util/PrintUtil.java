package algorithm.util;

import algorithm.linkedlist.ListNode;

public class PrintUtil {

    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.value + ", ");
            head = head.next;
        }
    }
}
