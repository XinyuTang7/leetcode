package algorithm.linkedlist;

public class DeleteNum {

    /**
     * 删除链表的倒数第 N 个结点
     * <p>
     * 1->2->3->4->5
     * 5->4->3->2->1
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0, num = 0;
        ListNode node = new ListNode(0,head);
        ListNode res = node;
        while (head != null) {
            head = head.next;
            len++;
        }

        while (node != null) {
            if (++num == len - n + 1) {
                node.next = node.next.next;
            }
            node = node.next;
        }
        return res.next;
    }


    public static ListNode reverse(ListNode head) {
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

        ListNode node = removeNthFromEnd(firstNode.next, 5);
        printListNoe(node);
    }

    private static void printListNoe(ListNode head) {
        while (head != null) {
            System.out.print(head.value + ", ");
            head = head.next;
        }
    }

}
