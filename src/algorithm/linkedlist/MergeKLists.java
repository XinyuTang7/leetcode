package algorithm.linkedlist;

import algorithm.util.PrintUtil;

public class MergeKLists {
    /**
     * 给你一个链表数组，每个链表都已经按升序排列。
     * <p>
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     */

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return process(lists, 0, lists.length - 1);
    }

    private static ListNode process(ListNode[] lists, int L, int R) {
        if (L > R) {
            return null;
        }
        if (L == R) {
            return lists[L];
        }
        int M = (R + L) >> 1;
        return merge(process(lists, L, M), process(lists, M + 1, R));
    }

    private static ListNode merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1, null);
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
        ListNode node1 = new ListNode(-1);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(11);
        node1.next = node2;
        node2.next = node3;

        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        head1.next = head2;
        head2.next = head3;

        ListNode curr1 = new ListNode(6);
        ListNode curr2 = new ListNode(10);
        curr1.next = curr2;

        ListNode[] listNodes = new ListNode[]{node1,head3.next,curr1,curr2.next};
        ListNode node = mergeKLists(listNodes);
        PrintUtil.printListNode(node);
    }
}
