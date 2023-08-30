package algorithm.linkedlist;

import algorithm.util.PrintUtil;

public class MergeLinkedList {

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     *
     * @param
     */

    public static ListNode mergeLinkedList(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-101, null);
        ListNode res = head;
        while (list1 != null && list2 != null) {
            ListNode cur = new ListNode();
            if ((int) list1.value < (int) list2.value) {
                cur.value = list1.value;
                list1 = list1.next;
            } else {
                cur.value = list2.value;
                list2 = list2.next;
            }
            head.next = cur;
            head = head.next;
        }
        if (list1 != null) {
            head.next = list1;
        }
        if (list2 != null) {
            head.next = list2;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(0);
        ListNode list1 = head1;
        ListNode head2 = new ListNode(0);
        ListNode list2 = head2;
        for (int i = 1; i <= 5; i++) {
            ListNode node = new ListNode(i);
            head1.next = node;
            head1 = head1.next;

            head2.next = node;
            head2 = head2.next;
        }
        ListNode node = mergeLinkedList(list1.next, list2.next);
        PrintUtil.printListNode(node);
    }
}
