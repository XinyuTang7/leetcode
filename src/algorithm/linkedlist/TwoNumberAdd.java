package algorithm.linkedlist;

public class TwoNumberAdd {

    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     *
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     *
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     */

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //定义一个新联表伪指针，用来指向头指针，返回结果
        ListNode prev = new ListNode(0);
        //定义一个进位数的指针，用来存储当两数之和大于10的时候，
        int carry = 0;
        //定义一个可移动的指针，用来指向存储两个数之和的位置
        ListNode cur = prev;
        //当l1 不等于null或l2 不等于空时，就进入循环
        while(l1!=null || l2!=null){
            //如果l1 不等于null时，就取他的值，等于null时，就赋值0，保持两个链表具有相同的位数
            int x= l1 !=null ? (int) l1.value : 0;
            //如果l1 不等于null时，就取他的值，等于null时，就赋值0，保持两个链表具有相同的位数
            int y = l2 !=null ? (int) l2.value : 0;
            //将两个链表的值，进行相加，并加上进位数
            int sum = x + y + carry;
            //计算进位数
            carry = sum / 10;
            //计算两个数的和，此时排除超过10的请况（大于10，取余数）
            sum = sum % 10;
            //将求和数赋值给新链表的节点，
            //注意这个时候不能直接将sum赋值给cur.next = sum。这时候会报，类型不匹配。
            //所以这个时候要创一个新的节点，将值赋予节点
            cur.next = new ListNode(sum);
            //将新链表的节点后移
            cur = cur.next;
            //当链表l1不等于null的时候，将l1 的节点后移
            if(l1 !=null){
                l1 = l1.next;
            }
            //当链表l2 不等于null的时候，将l2的节点后移
            if(l2 !=null){
                l2 = l2.next;
            }
        }
        //如果最后两个数，相加的时候有进位数的时候，就将进位数，赋予链表的新节点。
        //两数相加最多小于20，所以的的值最大只能时1
        if(carry == 1){
            cur.next = new ListNode(carry);
        }
        //返回链表的头节点
        return prev.next;

    }

    public static void main(String[] args) {
        //测试用例1
        ListNode l1 = new ListNode(9);


        ListNode r1 = new ListNode(1);
        ListNode r2 = new ListNode(9);
        ListNode r3 = new ListNode(9);
        ListNode r4 = new ListNode(9);
        ListNode r5 = new ListNode(9);
        ListNode r6 = new ListNode(9);
        ListNode r7 = new ListNode(9);
        ListNode r8 = new ListNode(9);
        ListNode r9 = new ListNode(9);
        ListNode r10 = new ListNode(9);

        r1.next = r2;
        r2.next = r3;
        r3.next = r4;
        r4.next = r5;
        r5.next = r6;
        r6.next = r7;
        r7.next = r8;
        r8.next = r9;
        r9.next = r10;


        //测试用例2
//        ListNode l1 = new ListNode(-1);
//        ListNode head1 = l1;
//        for(int i = 1; i <= 7;i++){
//            ListNode node = new ListNode<>(9);
//            head1.next = node;
//            head1 = head1.next;
//        }
//
//        ListNode r1 = new ListNode(-1);
//        ListNode head2 = r1;
//        for(int i = 1; i <= 4;i++){
//            ListNode node = new ListNode<>(9);
//            head2.next = node;
//            head2 = head2.next;
//        }
//        ListNode l1 = new ListNode(0);
//        ListNode r1 = new ListNode(0);

        ListNode res = addTwoNumbers(l1, r1);
        while (res != null) {
            System.out.print(res.value + "->");
            res = res.next;
        }
    }
}
