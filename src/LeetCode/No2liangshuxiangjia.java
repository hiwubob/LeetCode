package LeetCode;


public class No2liangshuxiangjia {
//    给出两个 非空 的链表用来表示两个非负的整数。其中，
//    它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = l1, q = l2, cur = dummy;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
            if (carry > 0) {
                cur.next = new ListNode(carry);
            }

        }
        return dummy.next;
    }
}
